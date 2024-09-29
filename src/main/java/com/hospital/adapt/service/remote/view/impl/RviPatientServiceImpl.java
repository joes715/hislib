
package com.hospital.adapt.service.remote.view.impl;


import com.github.pagehelper.Page;
import com.hospital.adapt.constant.Statics;
import com.hospital.adapt.mapper.remote.RbnPatientMapper;
import com.hospital.adapt.model.common.MyPage;
import com.hospital.adapt.model.remote.RbnPatient;
import com.hospital.adapt.service.common.impl.CommonServiceImpl;
import com.hospital.adapt.service.local.LoLogService;
import com.hospital.adapt.service.local.LoPatientService;
import com.hospital.adapt.service.remote.view.RviPatientService;
import com.hospital.adapt.utils.U2;
import com.hospital.adapt.utils.Utl2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RviPatientServiceImpl extends CommonServiceImpl<RbnPatient> implements RviPatientService {
    private RbnPatientMapper rbnPatientMapper = null;

    @Resource
    private LoPatientService loPatientService = null;
    @Resource
    private LoLogService loLogService = null;

    Logger log = LoggerFactory.getLogger(RviPatientServiceImpl.class);

    @Resource
    public void setRbnPatientMapper(RbnPatientMapper rbnPatientMapper) {
        this.rbnPatientMapper = rbnPatientMapper;
        this.setMapper(rbnPatientMapper);
    }

    @Override
    public void synAll() {
        try {
            List<RbnPatient> rPatients = rbnPatientMapper.queryAll();
            if (null != rPatients && rPatients.size() > 0) {
                loPatientService.synData(rPatients);
            } else {
                log.error("");
            }

            Statics.setDockSucc();
        } catch (Exception e) {
            Statics.setDockFail();
            log.error("ViPatientServiceImpl synAll exception:", e);
            Utl2.insertLogMsg(loLogService, "ViPatientServiceImpl synAll exception", "adapter", "adapter", e);
        }

    }

    @Override
    public void deleteNotExist() {
        try {
            List<String> stay_nos = rbnPatientMapper.queryAllZyhm();
            String stayNos = "";
            if (null != stay_nos && stay_nos.size() > 0) {
                stayNos = String.join(",", stay_nos);
            }
            loPatientService.synDelete(stayNos);
        } catch (Exception e) {
            log.error("ViPatientServiceImpl deleteNotExist exception:", e);
        }
    }

    @Override
    public String queryByParam(Map<String, String[]> param) {
        String result = "[]";

        String ward_code = U2.get("ward_code", param);
        String keyword = U2.get("keyword", param);

        MyPage<RbnPatient> mPage = new MyPage<RbnPatient>();
        mPage.setPageNum(parseInt(U2.get("page", param)));
        mPage.setPageSize(parseInt(U2.get("rows", param)));

        Map<String, Object> mparam = new HashMap<String, Object>();
        mparam.put("ward_code", ward_code);
        mparam.put("keyword", keyword);
        mPage.setParams(mparam);

        try {
            List<RbnPatient> patients = rbnPatientMapper.queryByParam(mPage);
            Page<RbnPatient> pg = (Page<RbnPatient>) patients;

            mPage.setRows(pg.getResult());
            mPage.setTotal(pg.getTotal());
            pg.close();

            result = toJSON(patients);
        } catch (Exception e) {
            log.error("ViPatientServiceImpl queryByParam exception:", e);
        }

        return result;
    }

}
