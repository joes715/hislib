
package com.hospital.adapt.service.remote.view.impl;


import com.github.pagehelper.Page;
import com.hospital.adapt.mapper.remote.RbnEmpMapper;
import com.hospital.adapt.model.common.MyPage;
import com.hospital.adapt.model.remote.RbnEmp;
import com.hospital.adapt.service.common.impl.CommonServiceImpl;
import com.hospital.adapt.service.local.LoEmpService;
import com.hospital.adapt.service.local.LoLogService;
import com.hospital.adapt.service.remote.view.RviEmpService;
import com.hospital.adapt.utils.Utl2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.hospital.adapt.utils.U2;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RviEmpServiceImpl extends CommonServiceImpl<RbnEmp> implements RviEmpService {
    private RbnEmpMapper rbnEmpMapper = null;

    @Resource
    private LoEmpService loEmpService = null;
    @Resource
    private LoLogService loLogService = null;

    Logger log = LoggerFactory.getLogger(RviEmpServiceImpl.class);

    @Resource
    public void setRbnEmployeeMapper(RbnEmpMapper rbnEmpMapper) {
        this.rbnEmpMapper = rbnEmpMapper;
        this.setMapper(rbnEmpMapper);
    }

    @Override
    public void synAll() {
        try {
            List<RbnEmp> rEmployees = rbnEmpMapper.queryAll();
            if (null != rEmployees && rEmployees.size() > 0) {
                loEmpService.synData(rEmployees);
            } else {
                log.warn("");
            }
        } catch (Exception e) {
            log.error("ViEmployeeServiceImpl synAll exception:", e);
            Utl2.insertLogMsg(loLogService, "ViEmployeeServiceImpl synAll exception", "adapter", "adapter", e);
        }

    }

    @Override
    public String queryByParam(Map<String, String[]> param) {
        String result = "[]";

        String keyword = U2.get("keyword", param);

        MyPage<RbnEmp> mPage = new MyPage<RbnEmp>();
        mPage.setPageNum(parseInt(U2.get("page", param)));
        mPage.setPageSize(parseInt(U2.get("rows", param)));

        Map<String, Object> mparam = new HashMap<String, Object>();
        mparam.put("keyword", keyword);
        mPage.setParams(mparam);

        try {
            List<RbnEmp> emps = rbnEmpMapper.queryByParam(mPage);
            Page<RbnEmp> pg = (Page<RbnEmp>) emps;

            mPage.setRows(pg.getResult());
            mPage.setTotal(pg.getTotal());
            pg.close();

            result = toJSON(emps);
        } catch (Exception e) {
            log.error("ViEmployeeServiceImpl queryByParam exception:", e);
        }

        return result;
    }

}
