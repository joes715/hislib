
package com.hospital.adapt.service.remote.ws.impl;

import com.hospital.adapt.model.remote.RbnPayType;
import com.hospital.adapt.model.wrapper.PayTypesWrapper;
import com.hospital.adapt.service.local.LoPayTypeService;
import com.hospital.adapt.service.remote.ws.RwsPayTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RwsPayTypeServiceImpl implements RwsPayTypeService {
    @Autowired
    private LoPayTypeService loPayTypeService = null;
    private static Logger logger = LoggerFactory.getLogger(RwsPayTypeServiceImpl.class);

    @Override
    public void synData(PayTypesWrapper spt) {
        if (null != spt) {
            List<RbnPayType> rPaymentTypes = spt.getWsTypes();
            if (null != rPaymentTypes && rPaymentTypes.size() > 0) {
                logger.info("payment type count: " + rPaymentTypes.size());
                loPayTypeService.synData(rPaymentTypes);
            } else {
                logger.error("");
            }
        }
    }

}
