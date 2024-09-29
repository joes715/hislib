package com.hospital.adapt.service.remote.view.impl;


import com.hospital.adapt.service.remote.view.RviPayTypeService;
import com.hospital.adapt.mapper.remote.RbnPayTypeMapper;
import com.hospital.adapt.model.remote.RbnPayType;
import com.hospital.adapt.service.common.impl.CommonServiceImpl;
import com.hospital.adapt.service.local.LoLogService;
import com.hospital.adapt.service.local.LoPayTypeService;
import com.hospital.adapt.utils.Utl2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RviPayTypeServiceImpl extends CommonServiceImpl<RbnPayType> implements RviPayTypeService {

    @Resource
    private RbnPayTypeMapper rbnPayTypeMapper = null;
    @Resource
    private LoPayTypeService loPayTypeService = null;
    @Resource
    private LoLogService loLogService = null;

    private static Logger log = LoggerFactory.getLogger(RviPayTypeServiceImpl.class);

    @Override
    public void synAll() {
        try {
            List<RbnPayType> rPaymentTypes = rbnPayTypeMapper.queryAll();
            if (null != rPaymentTypes && rPaymentTypes.size() > 0) {
                loPayTypeService.synData(rPaymentTypes);
            } else {
                log.warn("");
            }
        } catch (Exception e) {
            log.error("ViPaymentTypeServiceImpl synAll exception:", e);
            Utl2.insertLogMsg(loLogService, "ViPaymentTypeServiceImpl synAll exception", "adapter", "adapter", e);
        }

    }

}
