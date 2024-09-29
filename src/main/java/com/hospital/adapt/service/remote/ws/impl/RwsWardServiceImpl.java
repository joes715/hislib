
package com.hospital.adapt.service.remote.ws.impl;

import com.hospital.adapt.model.remote.RbnWard;
import com.hospital.adapt.model.wrapper.WardsWrapper;
import com.hospital.adapt.service.local.LoHisWardService;
import com.hospital.adapt.service.remote.ws.RwsWardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RwsWardServiceImpl implements RwsWardService {
    @Autowired
    private LoHisWardService loHisWardService = null;
    private static Logger logger = LoggerFactory.getLogger(RwsWardServiceImpl.class);

    @Override
    public void synData(WardsWrapper sa) {
        if (null != sa) {
            List<RbnWard> rWards = sa.getWsWards();
            if (null != rWards && rWards.size() > 0) {
                logger.info("Ward count: " + rWards.size());
                loHisWardService.synData(rWards);
            } else {
                logger.error("");
            }
        }
    }

}
