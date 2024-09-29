
package com.hospital.adapt.service.common;


import com.alibaba.fastjson.JSONObject;
import com.hospital.adapt.mapper.common.CommonMapper;

public interface CommonService<T> {
    public JSONObject edit(T t);

    public JSONObject add(T t) throws Exception;

    public JSONObject update(T t) throws Exception;

    public String queryAll();

    public void setMapper(CommonMapper<T> mapper);
}
