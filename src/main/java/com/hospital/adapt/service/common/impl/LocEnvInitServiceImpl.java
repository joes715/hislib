package com.hospital.adapt.service.common.impl;

import com.hospital.adapt.mapper.local.*;
import com.hospital.adapt.model.local.*;
import com.hospital.adapt.service.remote.view.impl.RviAdaptServiceImpl;
import com.hospital.adapt.mapper.local.*;
import com.hospital.adapt.model.local.*;
import com.hospital.adapt.service.common.LocEnvInitService;
import com.hospital.adapt.utils.LDataBufferUtil;
import com.hospital.adapt.utils.Str2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class LocEnvInitServiceImpl implements LocEnvInitService {
    @Resource
    private LbnNursLvlMapper lbnNursLvlMapper = null;
    @Resource
    private LbnPayTypeMapper lbnPayTypeMapper = null;
    @Resource
    private LbnPatientMapper lbnPatientMapper = null;
    @Resource
    private LbnHisWardMapper lbnHisWardMapper = null;
    @Resource
    private LbnBedMapper lbnBedMapper = null;
    @Resource
    private LbnRoomMapper lbnRoomMapper = null;
    @Resource
    private LbnEmpMapper lbnEmpMapper = null;
    @Resource
    private LbnDeptMapper lbnDeptMapper = null;
    @Resource
    private LbnSaIsMapper lbnSaIsMapper = null;
    @Resource
    private LbnSafeLvlMapper lbnSafeLvlMapper = null;

    Logger log = LoggerFactory.getLogger(RviAdaptServiceImpl.class);


    @Override
    public void initAllBuff() {
        initDockIdBuf();
        initDockDataBuff();
    }

    @Override
    public void initDockIdBuf() {
        initDockWardIdBuff();
        initDockBedIdBuff();
        initDockRoomIdBuff();
        initDockEmpIdBuff();
        initDockDeptIdBuff();
        initSafeIsoIdBuff();
        initSafeLevelIdBuff();
    }

    @Override
    public void initDockDataBuff() {
        initPatientBuff();
        initPaymentTypeBuff();
        initNursingLevelBuff();
        initHisWardCodesBuff();
        initDeptCodesBuff();
    }

    @Override
    public void initNursingLevelBuff() {
        try {
            LDataBufferUtil.levelCodeBuff.clear();
            List<String> sns = lbnNursLvlMapper.queryAllNursingLevelSn();
            if (null != sns && sns.size() > 0) {
                LDataBufferUtil.levelCodeBuff.addAll(sns);
            }
        } catch (Exception e) {
            log.error("LEnvInitServiceImpl initNursingLevelBuff exception:", e);
        }
    }

    @Override
    public void initPaymentTypeBuff() {
        try {
            LDataBufferUtil.payTypeNamesBuff.clear();
            List<String> types = lbnPayTypeMapper.queryAllPaymentTypeName();
            if (null != types && types.size() > 0) {
                LDataBufferUtil.payTypeNamesBuff.addAll(types);
            }
        } catch (Exception e) {
            log.error("LEnvInitServiceImpl initPaymentTypeBuff exception:", e);
        }
    }

    @Override
    public void initPatientBuff() {
        try {
            LDataBufferUtil.patientBuff.clear();
            Map<String, LbnPatient> patients = lbnPatientMapper.queryAllToMap();
            if (null != patients && patients.size() > 0) {
                LDataBufferUtil.patientBuff.putAll(patients);
            }
        } catch (Exception e) {
            log.error("LEnvInitServiceImpl initPatientBuff exception:", e);
        }
    }

    @Override
    public void initDockWardIdBuff() {
        try {
            LDataBufferUtil.adaptWardIdBuff.clear();
            List<LbnHisWard> dockAreas = lbnHisWardMapper.queryAll();
            if (null != dockAreas && dockAreas.size() > 0) {
                for (LbnHisWard bizHisArea : dockAreas) {
                    if (null != bizHisArea
                            && Str2.notNull(bizHisArea.getward_code())
                            && Str2.notNull(bizHisArea.getlocal_ward_id())) {

                        LDataBufferUtil.adaptWardIdBuff.put(bizHisArea.getward_code(), bizHisArea.getlocal_ward_id());
                    }
                }
            }
        } catch (Exception e) {
            log.error("LEnvInitServiceImpl initDockWardIdBuff exception:", e);
        }
    }

    @Override
    public void initDockBedIdBuff() {
        try {
            LDataBufferUtil.adaptBedIdBuff.clear();
            List<LbnBed> dockBeds = lbnBedMapper.queryForBuff();
            if (null != dockBeds && dockBeds.size() > 0) {
                for (LbnBed bizBed : dockBeds) {
                    if (null != bizBed && Str2.notNull(bizBed.getbed_code())) {
                        LDataBufferUtil.adaptBedIdBuff.put(bizBed.getward_id() + "_" + bizBed.getbed_code(), bizBed.getbed_id());
                    }
                }
            }
        } catch (Exception e) {
            log.error("LEnvInitServiceImpl initDockBedIdBuff exception:", e);
        }
    }

    @Override
    public void initDockRoomIdBuff() {
        try {
            LDataBufferUtil.adaptRoomIdBuff.clear();
            List<LbnRoom> dockRooms = lbnRoomMapper.queryForBuff();

            if (null != dockRooms && dockRooms.size() > 0) {
                for (LbnRoom bizRoom : dockRooms) {
                    if (null != bizRoom && Str2.notNull(bizRoom.getroom_code())) {
                        LDataBufferUtil.adaptRoomIdBuff.put(bizRoom.getward_id() + "_" + bizRoom.getroom_code(), bizRoom.getroom_id());
                    }
                }
            }
        } catch (Exception e) {
            log.error("LEnvInitServiceImpl initDockRoomIdBuff exception:", e);
        }
    }

    @Override
    public void initDockEmpIdBuff() {
        try {
            LDataBufferUtil.adaptEmpIdBuff.clear();
            List<LbnEmp> dockEmps = lbnEmpMapper.queryForBuff();

            if (null != dockEmps && dockEmps.size() > 0) {
                for (LbnEmp bizEmployee : dockEmps) {
                    if (null != bizEmployee
                            && Str2.notNull(bizEmployee.getemp_name())
                            && Str2.notNull(bizEmployee.getemp_job())) {

                        LDataBufferUtil.adaptEmpIdBuff.put(bizEmployee.getemp_name() + "_" + bizEmployee.getemp_job(), bizEmployee.getemp_id());
                    }
                }
            }
        } catch (Exception e) {
            log.error("LEnvInitServiceImpl initDockEmpIdBuff exception:", e);
        }
    }

    @Override
    public void initDockDeptIdBuff() {
        try {
            LDataBufferUtil.adaptDeptIdBuff.clear();
            List<LbnDept> dockDepts = lbnDeptMapper.queryForBuff();

            if (null != dockDepts && dockDepts.size() > 0) {
                for (LbnDept bizDept : dockDepts) {
                    if (null != bizDept && Str2.notNull(bizDept.getdept_code())) {
                        LDataBufferUtil.adaptDeptIdBuff.put(bizDept.getdept_code(), bizDept.getdept_id());
                    }
                }
            }
        } catch (Exception e) {
            log.error("LEnvInitServiceImpl initDockDeptIdBuff exception:", e);
        }
    }

    @Override
    public void initSafeIsoIdBuff() {
        try {
            LDataBufferUtil.pat_safe_idBuff.clear();
            List<LbnSaIs> safeIsolates = lbnSaIsMapper.queryForBuff();

            if (null != safeIsolates && safeIsolates.size() > 0) {
                for (LbnSaIs si : safeIsolates) {
                    if (null != si && Str2.notNull(si.getsafe_name())) {
                        LDataBufferUtil.pat_safe_idBuff.put(si.getsafe_name(), si.getsafe_id());
                    }
                }
            }
        } catch (Exception e) {
            log.error("LEnvInitServiceImpl initSafeIsaIdBuff exception:", e);
        }
    }

    @Override
    public void initHisWardCodesBuff() {
        try {
            LDataBufferUtil.hisWardCodesBuff.clear();
            List<String> names = lbnHisWardMapper.queryHisWardCodes();
            if (null != names && names.size() > 0) {
                LDataBufferUtil.hisWardCodesBuff.addAll(names);
            }
        } catch (Exception e) {
            log.error("LEnvInitServiceImpl initHisWardNamesBuff exception:", e);
        }
    }

    @Override
    public void initDeptCodesBuff() {
        try {
            LDataBufferUtil.deptCodesBuff.clear();
            List<String> names = lbnDeptMapper.queryDeptCodes();
            if (null != names && names.size() > 0) {
                LDataBufferUtil.deptCodesBuff.addAll(names);
            }
        } catch (Exception e) {
            log.error("LEnvInitServiceImpl initDeptNamesBuff exception:", e);
        }
    }

    @Override
    public void initSafeLevelIdBuff() {
        try {
            LDataBufferUtil.saLvlIdBuff.clear();
            List<LbnSafeLvl> safeLevels = lbnSafeLvlMapper.queryForBuff();

            if (null != safeLevels && safeLevels.size() > 0) {
                for (LbnSafeLvl sl : safeLevels) {
                    if (null != sl && Str2.notNull(sl.getsafe_level_name())) {
                        LDataBufferUtil.saLvlIdBuff.put(sl.getsafe_level_name(), sl.getsafe_level_id());
                    }
                }
            }
        } catch (Exception e) {
            log.error("LEnvInitServiceImpl initSafeLevelIdBuff exception:", e);
        }
    }
}
