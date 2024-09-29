
package com.hospital.adapt.service.remote.view.impl;


import com.hospital.adapt.service.common.impl.CommonServiceImpl;
import com.hospital.adapt.service.local.LoHisWardService;
import com.hospital.adapt.service.local.LoLogService;
import com.hospital.adapt.utils.Utl2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hospital.adapt.model.remote.RbnWard;
import com.hospital.adapt.mapper.remote.RbnWardMapper;
import com.hospital.adapt.service.remote.view.RviWardService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RviWardServiceImpl extends CommonServiceImpl<RbnWard> implements RviWardService {

    private RbnWardMapper rbnWardMapper = null;

    @Resource
    private LoHisWardService loHisWardService = null;
    @Resource
    private LoLogService loLogService = null;

    Logger log = LoggerFactory.getLogger(RviWardServiceImpl.class);

    @Resource
    public void setRbnWardMapper(RbnWardMapper rbnWardMapper) {
        this.rbnWardMapper = rbnWardMapper;
        this.setMapper(rbnWardMapper);
    }

    @Override
    public void synAll() {
         try {
            List<RbnWard> rAreas = rbnWardMapper.queryAll();
            if (null != rAreas && rAreas.size() > 0) {
                loHisWardService.synData(rAreas);
            } else {
                log.warn("");
            }
        } catch (Exception e) {
            log.error("ViWardServiceImpl synAll exception:", e);
            Utl2.insertLogMsg(loLogService, "ViWardServiceImpl synAll exception", "adapter", "adapter", e);
        }
    }
}
