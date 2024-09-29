
package com.hospital.adapt.service.remote.ws.impl;


import com.hospital.adapt.model.remote.RbnEmp;
import com.hospital.adapt.model.wrapper.EmpsWrapper;
import com.hospital.adapt.service.local.LoEmpService;
import com.hospital.adapt.service.remote.ws.RwsEmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class RwsEmpServiceImpl implements RwsEmpService {
    @Resource
    private LoEmpService loEmpService = null;
    private static Logger logger = LoggerFactory.getLogger(RwsEmpServiceImpl.class);

    @Override
    public void synData(EmpsWrapper se) {
        if (null != se) {
            List<RbnEmp> rEmployees = se.getWsEmps();
            if (null != rEmployees && rEmployees.size() > 0) {
                logger.info("employee count: " + rEmployees.size());
                loEmpService.synData(rEmployees);
            } else {
                logger.error("");
            }
        }
    }
}
