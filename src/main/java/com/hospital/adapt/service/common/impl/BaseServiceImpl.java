package com.hospital.adapt.service.common.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hospital.adapt.utils.Str2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class BaseServiceImpl {
    private static Logger log = LoggerFactory.getLogger(BaseServiceImpl.class);
    protected static SerializerFeature feature = SerializerFeature.DisableCircularReferenceDetect;
    protected static JSONObject jsonFailed = JSON.parseObject("{'status':1}");
    protected static JSONObject jsonSucc = JSON.parseObject("{'status':0}");

    @Autowired
    protected HttpSession httpSession;

    @Autowired
    protected HttpServletRequest request;

    public static String toJSON(Object obj) {
        return JSON.toJSONStringWithDateFormat(obj, "yyyy-MM-dd HH:mm:ss", feature);
    }

    protected void resetMsg() {
        jsonFailed.remove("msg");
        jsonSucc.remove("msg");
        jsonSucc.remove("residualDays");
    }

    protected int parseInt(String str) {
        int result = 0;

        try {
            if (Str2.notNull(str)) {
                result = Integer.parseInt(str);
            }
        } catch (Exception e) {
            log.error("BaseServiceImpl exception:", e);
        }

        return result;
    }

    protected boolean notNull(String str) {
        return (null != str && str.trim().length() > 0);
    }
}
