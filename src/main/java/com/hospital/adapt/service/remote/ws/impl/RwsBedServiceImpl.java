
package com.hospital.adapt.service.remote.ws.impl;

import com.hospital.adapt.service.remote.ws.RwsBedService;
import com.hospital.adapt.model.remote.RbnBed;
import com.hospital.adapt.model.wrapper.BedsWrapper;
import com.hospital.adapt.service.local.LoBedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RwsBedServiceImpl implements RwsBedService {
    @Autowired
    private LoBedService loBedService = null;
    private static Logger logger = LoggerFactory.getLogger(RwsBedServiceImpl.class);

    @Override
    public void synData(BedsWrapper sb) {
        if (null != sb) {
            List<RbnBed> rBeds = sb.getWsBeds();
            if (null != rBeds && rBeds.size() > 0) {
                loBedService.synData(rBeds);
            } else {
            }
        }
    }
}
