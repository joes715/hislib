package com.hospital.adapt.service.local.impl;

import com.hospital.adapt.service.common.impl.CommonServiceImpl;
import com.hospital.adapt.mapper.local.LbnLogMapper;
import com.hospital.adapt.model.local.LbnLog;
import com.hospital.adapt.service.local.LoLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoLogServiceImpl extends CommonServiceImpl<LbnLog> implements LoLogService {
    private LbnLogMapper lbnLogMapper = null;

    @Resource
    public void setLbnLogMapper(LbnLogMapper lbnLogMapper) {
        this.lbnLogMapper = lbnLogMapper;
        this.setMapper(lbnLogMapper);
    }
}
