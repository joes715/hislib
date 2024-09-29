
package com.hospital.adapt.service.remote.view.impl;


import com.hospital.adapt.mapper.remote.RbnDeptMapper;
import com.hospital.adapt.model.remote.RbnDept;
import com.hospital.adapt.service.common.impl.CommonServiceImpl;
import com.hospital.adapt.service.local.LoDeptService;
import com.hospital.adapt.service.local.LoLogService;
import com.hospital.adapt.service.remote.view.RviDeptService;
import com.hospital.adapt.utils.Utl2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RviDeptServiceImpl extends CommonServiceImpl<RbnDept> implements RviDeptService {

    private RbnDeptMapper rbnDeptMapper = null;

    @Resource
    private LoDeptService loDeptService = null;
    @Resource
    private LoLogService loLogService = null;

    Logger log = LoggerFactory.getLogger(RviDeptServiceImpl.class);

    @Resource
    public void setRbnDeptMapper(RbnDeptMapper rbnDeptMapper) {
        this.rbnDeptMapper = rbnDeptMapper;
        this.setMapper(rbnDeptMapper);
    }

    @Override
    public void synAll() {
        try {
            List<RbnDept> rDepts = rbnDeptMapper.queryAll();
            if (null != rDepts && rDepts.size() > 0) {
                loDeptService.synData(rDepts);
            } else {
                log.warn("");
            }
        } catch (Exception e) {
            log.error("ViDeptServiceImpl synAll exception:", e);
            Utl2.insertLogMsg(loLogService, "Sync data exception", "adapter", "adapter", e);
        }
    }
}
