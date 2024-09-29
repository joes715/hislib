
package com.hospital.adapt.service.remote.view.impl;


import com.github.pagehelper.Page;
import com.hospital.adapt.mapper.remote.RbnBedMapper;
import com.hospital.adapt.model.common.MyPage;
import com.hospital.adapt.model.remote.RbnBed;
import com.hospital.adapt.service.common.impl.CommonServiceImpl;
import com.hospital.adapt.service.local.LoBedService;
import com.hospital.adapt.service.local.LoLogService;
import com.hospital.adapt.service.remote.view.RviBedService;
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
public class RviBedServiceImpl extends CommonServiceImpl<RbnBed> implements RviBedService {
    private RbnBedMapper rbnBedMapper = null;

    @Resource
    private LoBedService loBedService = null;
    @Resource
    private LoLogService loLogService = null;

    Logger log = LoggerFactory.getLogger(RviBedServiceImpl.class);

    @Resource
    public void setRbnBedMapper(RbnBedMapper rbnBedMapper) {
        this.rbnBedMapper = rbnBedMapper;
        this.setMapper(rbnBedMapper);
    }

    @Override
    public void synAll() {
        try {
            List<RbnBed> rBeds = rbnBedMapper.queryAll();
            if (null != rBeds && rBeds.size() > 0) {
                loBedService.synData(rBeds);
            } else {

            }
        } catch (Exception e) {
            Utl2.insertLogMsg(loLogService, "Data sync exception", "adapter", "adapter", e);
        }

    }

    @Override
    public String queryByParam(Map<String, String[]> param) {
        String result = "[]";

        String ward_code = U2.get("ward_code", param);

        MyPage<RbnBed> mPage = new MyPage<RbnBed>();
        mPage.setPageNum(parseInt(U2.get("page", param)));
        mPage.setPageSize(parseInt(U2.get("rows", param)));

        Map<String, Object> mparam = new HashMap<String, Object>();
        mparam.put("ward_code", ward_code);
        mPage.setParams(mparam);

        try {
            List<RbnBed> emps = rbnBedMapper.queryByParam(mPage);
            Page<RbnBed> pg = (Page<RbnBed>) emps;

            mPage.setRows(pg.getResult());
            mPage.setTotal(pg.getTotal());
            pg.close();

            result = toJSON(emps);
        } catch (Exception e) {
            log.error("ViBedServiceImpl queryByParam exception:", e);
        }

        return result;
    }

}
