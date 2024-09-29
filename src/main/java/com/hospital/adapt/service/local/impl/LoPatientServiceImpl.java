
package com.hospital.adapt.service.local.impl;


import com.hospital.adapt.mapper.local.*;
import com.hospital.adapt.model.local.*;
import com.hospital.adapt.service.common.impl.CommonServiceImpl;
import com.hospital.adapt.mapper.local.*;
import com.hospital.adapt.model.local.*;
import com.hospital.adapt.model.remote.RbnPatient;
import com.hospital.adapt.service.local.LoPatientService;
import com.hospital.adapt.service.local.MqService;
import com.hospital.adapt.utils.CodecUtil2;
import com.hospital.adapt.utils.LDataBufferUtil;
import com.hospital.adapt.utils.Str2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoPatientServiceImpl extends CommonServiceImpl<LbnPatient> implements LoPatientService {
    @Resource
    private LbnPayTypeMapper lbnPayTypeMapper = null;
    @Resource
    private LbnEmpMapper lbnEmpMapper = null;
    @Resource
    private LbnPatientSaIsMapper lbnPatientSaIsMapper = null;
    @Resource
    private LbnSaIsMapper lbnSaIsMapper = null;

    @Resource
    private MqService mqService = null;

    private LbnPatientMapper lbnPatientMapper = null;
    private Logger log = LoggerFactory.getLogger(LoPatientServiceImpl.class);
    private static Class<?> clz = RbnPatient.class;
    private static Integer SAFE_TYPE = 1;
    private static Integer ISOLATE_TYPE = 2;

    @Resource
    public void setLoBzPatientMapper(LbnPatientMapper lbnPatientMapper) {
        this.lbnPatientMapper = lbnPatientMapper;
        this.setMapper(lbnPatientMapper);
    }

    @Override
    public void synData(List<RbnPatient> rPatients) {
        int x = 0;
        int y = 0;
        int z = 0;

        if (null != rPatients && rPatients.size() > 0) {
            for (RbnPatient rPatient : rPatients) {
                if (null != rPatient) {
                    try {
                        if (needUpdate(rPatient)) {
                            x++;
                            String wardId = LDataBufferUtil.adaptWardIdBuff.get(rPatient.getward_code());
                            if (Str2.notNull(wardId)) {
                                if (Str2.notNull(rPatient.getbed_name())) {
                                    String bedId = LDataBufferUtil.adaptBedIdBuff.get(wardId + "_" + rPatient.getbed_name());
                                    if (Str2.notNull(bedId)) {
                                        String fp = getFingerprint(rPatient);

                                        if (Str2.notNull(rPatient.getlevel_code())) {
                                            if (!LDataBufferUtil.levelCodeBuff.contains(rPatient.getlevel_code())) {
                                                rPatient.setlevel_code(null);
                                            }
                                        }

                                        if (Str2.notNull(rPatient.getpay_name())) {
                                            if (!LDataBufferUtil.payTypeNamesBuff.contains(rPatient.getpay_name())) {
                                                addPaymentType(rPatient.getpay_name().trim());
                                            }
                                        }

                                        LbnPatient bizPatient = LDataBufferUtil.patientBuff.get(rPatient.getadm_num());

                                        if (null == bizPatient) {
                                            bizPatient = new LbnPatient();
                                        }

                                        BeanUtils.copyProperties(rPatient, bizPatient);
                                        bizPatient.setbed_id(bedId);
                                        bizPatient.setward_id(wardId);
                                        bizPatient.setupdate_fingerpring(fp);

                                        String ekey = rPatient.getdoctor_name() + "_" + rPatient.getdoctor_job();
                                        String empId = LDataBufferUtil.adaptEmpIdBuff.get(ekey);
                                        if (Str2.isNull(empId)) {
                                            empId = addEmp(rPatient.getdoctor_name(), rPatient.getdoctor_job(), "Doctor");
                                        }
                                        bizPatient.setdoctor_id(empId);

                                        ekey = rPatient.getnurse_name() + "_" + rPatient.getnurse_job();
                                        empId = LDataBufferUtil.adaptEmpIdBuff.get(ekey);
                                        if (Str2.isNull(empId)) {
                                            empId = addEmp(rPatient.getnurse_name(), rPatient.getnurse_job(), "Nurse");
                                        }
                                        bizPatient.setnurse_id(empId);

                                        String deptId = null;
                                        if (Str2.notNull(rPatient.getdept_code())) {
                                            deptId = LDataBufferUtil.adaptDeptIdBuff.get(rPatient.getdept_code());
                                        }
                                        bizPatient.setdept_id(deptId);

                                        edit(bizPatient);
                                        z++;

                                        parseSafeIsolate(bizPatient.getpat_id(), bizPatient.getpat_safe(), SAFE_TYPE);
                                        parseSafeIsolate(bizPatient.getpat_id(), bizPatient.getpat_isolate(), ISOLATE_TYPE);

                                        mqService.refreshData(bizPatient.getadm_num());
                                    } else {
                                        lbnPatientMapper.deleteByZyhm(rPatient.getadm_num());
                                    }
                                } else {
                                    lbnPatientMapper.deleteByZyhm(rPatient.getadm_num());
                                }
                            } else {
                                lbnPatientMapper.deleteByZyhm(rPatient.getadm_num());
                            }
                        } else {
                            y++;
                        }
                    } catch (Exception e) {
                        log.error("LoPatientServiceImpl synData exception:", e);
                    }
                }
            }
        }
    }

    @Override
    public void synDelete(String stayNos) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("stayNos", stayNos);

        try {
            lbnPatientMapper.deleteNotInadm_nums(params);
        } catch (Exception e) {
            log.error("LoPatientServiceImpl synDelete exception:", e);
        }
    }

    private String addEmp(String eName, String eJn, String type) {
        String empId = null;

        try {
            if (Str2.notNull(eName) && Str2.notNull(eJn)) {
                LbnEmp bizEmployee = new LbnEmp();
                bizEmployee.setemp_name(eName.trim());
                bizEmployee.setemp_job(eJn.trim());
                bizEmployee.setemp_type(type);
                lbnEmpMapper.add(bizEmployee);
                empId = bizEmployee.getemp_id();
                LDataBufferUtil.adaptEmpIdBuff.put(eName + "_" + eJn, empId);
            }
        } catch (Exception e) {
            log.error("LoPatientServiceImpl addEmp exception:", e);
        }

        return empId;
    }

    private String addPaymentType(String typeName) {
        String id = null;
        try {
            if (Str2.notNull(typeName)) {
                LbnPayType pType = new LbnPayType();
                pType.setpay_name(typeName);
                lbnPayTypeMapper.add(pType);
                id = pType.getroom_id();
                LDataBufferUtil.payTypeNamesBuff.add(typeName);
            }
        } catch (Exception e) {
            log.error("LoPatientServiceImpl addPaymentType exception:", e);
        }
        return id;
    }

    private String getFingerprint(RbnPatient rpt) {
        String result = null;

        if (null != rpt) {
            try {
                Field fields[] = clz.getDeclaredFields();
                StringBuffer sb = new StringBuffer();
                for (Field field : fields) {
                    field.setAccessible(true);
                    Object obj = field.get(rpt);
                    if (null != obj) {
                        String v = String.valueOf(obj);
                        sb.append(v);
                    }
                }

                if (sb.length() > 0) {
                    String msg = sb.toString();
                    MessageDigest sha = MessageDigest.getInstance("SHA");
                    sha.update(msg.getBytes());
                    byte[] shaBin = sha.digest();
                    result = CodecUtil2.bytesToHex(shaBin);
                }
            } catch (Exception e) {
                log.error("LoPatientServiceImpl getFingerprint exception:", e);
            }
        }

        return result;
    }

    private boolean needUpdate(RbnPatient rpt) {
        boolean result = true;

        LbnPatient lbnPatient = LDataBufferUtil.patientBuff.get(rpt.getadm_num());
        if (null != lbnPatient) {
            String oldFingerPrint = lbnPatient.getupdate_fingerpring();
            if (Str2.notNull(oldFingerPrint)) {
                String fp1 = getFingerprint(rpt);
                result = !(null != fp1 && fp1.equals(oldFingerPrint));
            }
        }

        return result;
    }

    synchronized private void parseSafeIsolate(String patientId, String info, Integer type) {
        if (null != patientId) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("pat_id", patientId);
            params.put("safe_type", type);
            lbnPatientSaIsMapper.deleteForPatient(params);
            if (Str2.notNull(info)) {
                info = info.trim();
                if (info.indexOf("=") > 0 || info.indexOf(";") > 0) {
                    String kvs[] = info.split(";");
                    if (null != kvs && kvs.length > 0) {
                        for (String kv : kvs) {
                            String kvs2[] = kv.split("=");
                            if (kvs2.length > 0) {
                                addSafeIsolate(kvs2[0], type);
                                String safeIsolateId = LDataBufferUtil.pat_safe_idBuff.get(kvs2[0]);
                                String safeLevelId = (kvs2.length == 2) ? LDataBufferUtil.saLvlIdBuff.get(kvs2[1]) : null;
                                addPatientSafeIsolate(patientId, safeIsolateId, safeLevelId, type);
                            }
                        }
                    }
                } else {
                    String[] kvs = info.split(",");
                    if (null != kvs && kvs.length > 0) {
                        for (String name : kvs) {
                            addSafeIsolate(name, type);
                            String safeIsolateId = LDataBufferUtil.pat_safe_idBuff.get(name);
                            addPatientSafeIsolate(patientId, safeIsolateId, null, type);
                        }
                    }
                }
            }
        }
    }

    private void addSafeIsolate(String safe_name, Integer safe_type) {
        if (Str2.notNull(safe_name) && null != safe_type) {
            String safe_id = LDataBufferUtil.pat_safe_idBuff.get(safe_name);
            if (Str2.isNull(safe_id)) {
                String timeStr = Long.toString(System.currentTimeMillis());
                String safe_code = timeStr.substring(timeStr.length() - 4);
                LbnSaIs si = new LbnSaIs();
                si.setsafe_name(safe_name);
                si.setsafe_code(safe_code);
                si.setsafe_type(safe_type);
                try {
                    lbnSaIsMapper.add(si);
                    LDataBufferUtil.pat_safe_idBuff.put(safe_name, si.getsafe_id());
                } catch (Exception e) {

                }
            }
        }
    }

    private void addPatientSafeIsolate(String patientId, String safeIsolateId, String safeLevelId, Integer type) {
        if (null != patientId && null != safeIsolateId && null != type) {
            LbnPatientSaIs psi = new LbnPatientSaIs();
            psi.setpat_id(patientId);
            psi.setsafe_id(safeIsolateId);
            psi.setsafe_level_id(safeLevelId);
            psi.setsafe_type(type);
            try {
                lbnPatientSaIsMapper.add(psi);
            } catch (Exception e) {

            }
        }
    }
}
