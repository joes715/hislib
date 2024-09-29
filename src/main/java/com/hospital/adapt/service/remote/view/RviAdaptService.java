package com.hospital.adapt.service.remote.view;

import com.alibaba.fastjson.JSONObject;

public interface RviAdaptService {

    JSONObject startAdapt();

    JSONObject stopAdapt();
}
