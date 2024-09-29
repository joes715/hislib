
package com.hospital.adapt.service.common.impl;

import com.hospital.adapt.mapper.common.BnCommonMapper;
import com.hospital.adapt.mapper.common.CommonMapper;
import com.hospital.adapt.service.common.BnCommonService;


public abstract class BnCommonServiceImpl<T> extends CommonServiceImpl<T> implements BnCommonService<T> {

    private BnCommonMapper<T> bzMapper = null;


    @Override
    public void setMapper(CommonMapper<T> mapper) {
        super.setMapper(mapper);
        this.bzMapper = (BnCommonMapper<T>) mapper;
    }

}
