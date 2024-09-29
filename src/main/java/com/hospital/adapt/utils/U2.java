package com.hospital.adapt.utils;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class U2 {
    private static String CHARSET = "UTF-8";
    private static final Logger log = LoggerFactory.getLogger(U2.class);

    public static String get(String key, Map<String, String[]> param) {
        return get(key, param, null);
    }

    public static String get(String key, Map<String, String[]> param, String dft) {
        String result = null;

        if (Str2.notNull(key) && null != param && param.size() > 0) {
            String[] vs = param.get(key);
            if (null != vs && vs.length > 0) {
                result = vs[0];
            }
        }

        if (Str2.isNull(result)) result = dft;

        return result;
    }
}
