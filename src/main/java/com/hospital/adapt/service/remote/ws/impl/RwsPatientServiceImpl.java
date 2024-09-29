
package com.hospital.adapt.service.remote.ws.impl;

import com.hospital.adapt.model.remote.RbnPatient;
import com.hospital.adapt.model.wrapper.PatsWrapper;
import com.hospital.adapt.service.local.LoPatientService;
import com.hospital.adapt.service.remote.ws.RwsPatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RwsPatientServiceImpl implements RwsPatientService {
    @Autowired
    private LoPatientService loPatientService = null;
    private static Logger logger = LoggerFactory.getLogger(RwsPatientServiceImpl.class);

    @Override
    public void synData(PatsWrapper sp) {

        if (null != sp) {
            List<RbnPatient> rPatients = sp.getWsPats();
            if (null != rPatients && rPatients.size() > 0) {
                logger.info("patient count: " + rPatients.size());
                loPatientService.synData(rPatients);
            } else {
                logger.error("");
            }
        }
    }

    @Override
    synchronized public void synDelete(String stayNos) {
        loPatientService.synDelete(stayNos);
    }

}
