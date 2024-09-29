
package com.hospital.adapt.service.remote.ws.impl;

import com.hospital.adapt.model.remote.RbnDept;
import com.hospital.adapt.model.wrapper.DeptsWrapper;
import com.hospital.adapt.service.local.LoDeptService;
import com.hospital.adapt.service.remote.ws.RwsDeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RwsDeptServiceImpl implements RwsDeptService {
    @Autowired
    private LoDeptService loDeptService = null;
    private static Logger logger = LoggerFactory.getLogger(RwsDeptServiceImpl.class);

    @Override
    public void synData(DeptsWrapper sa) {
        if (null != sa) {
            List<RbnDept> rDepts = sa.getWsDepts();
            if (null != rDepts && rDepts.size() > 0) {
                logger.info("Dept count: " + rDepts.size());
                loDeptService.synData(rDepts);
            } else {
                logger.error("");
            }
        }
    }

}
