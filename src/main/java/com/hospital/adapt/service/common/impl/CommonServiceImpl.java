
package com.hospital.adapt.service.common.impl;


import com.alibaba.fastjson.JSONObject;
import com.hospital.adapt.mapper.common.CommonMapper;
import com.hospital.adapt.model.common.CommonBean;
import com.hospital.adapt.service.common.CommonService;
import com.hospital.adapt.utils.Str2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class CommonServiceImpl<T> extends BaseServiceImpl implements CommonService<T> {

    private CommonMapper<T> mapper = null;
    Logger log = LoggerFactory.getLogger(CommonServiceImpl.class);

    @Override
    public JSONObject edit(T t) {
        resetMsg();
        JSONObject result = jsonFailed;
        try {
            if (null != t) {
                CommonBean cb = (CommonBean) t;
                if (Str2.notNull(cb.getId())) {
                    result = update(t);
                } else {
                    result = add(t);
                }
            }
        } catch (Exception e) {
            log.error("CommonServiceImpl edit", e);
            result = jsonFailed;
        }

        return result;
    }

    @Override
    @Transactional
    public JSONObject add(T t) throws Exception {
        resetMsg();
        JSONObject result = jsonFailed;
        if (null != t) {
            mapper.add(t);
            result = jsonSucc;
        }
        return result;
    }

    @Override
    @Transactional
    public JSONObject update(T t) throws Exception {
        resetMsg();
        JSONObject result = jsonFailed;
        if (null != t) {
            mapper.update(t);
            result = jsonSucc;
        }
        return result;
    }

    @Override
    public String queryAll() {
        String result = "[]";

        try {
            List<T> objs = mapper.queryAll();
            if (null != objs && objs.size() > 0) {
                result = toJSON(objs);
            }
        } catch (Exception e) {
            log.error("CommonServiceImpl queryAll", e);
        }

        return result;
    }

    @Override
    public void setMapper(CommonMapper<T> mapper) {
        this.mapper = mapper;
    }

}
