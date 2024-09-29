package com.hospital.adapt.service.common;

import com.alibaba.fastjson.JSONObject;

public interface AdaptService {
    public JSONObject startAdapt(String dock_type);

    public JSONObject stopAdapt(String dock_type);

    public void setCfg(JSONObject cfg);
}
