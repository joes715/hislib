package com.hospital.adapt.service.remote.ws;

import com.alibaba.fastjson.JSONObject;

public interface RwsAdaptService {

    JSONObject startAdapt();

    JSONObject stopAdapt();
}
