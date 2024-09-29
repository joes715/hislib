
package com.hospital.adapt.utils;

import com.hospital.adapt.model.local.LbnPatient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LDataBufferUtil {
    public static List<String> levelCodeBuff = new ArrayList();
    public static List<String> payTypeNamesBuff = new ArrayList();
    public static List<String> hisWardCodesBuff = new ArrayList();
    public static List<String> deptCodesBuff = new ArrayList();
    public static Map<String, String> pat_safe_idBuff = new ConcurrentHashMap();
    public static Map<String, String> saLvlIdBuff = new ConcurrentHashMap();
    public static Map<String, LbnPatient> patientBuff = new ConcurrentHashMap();
    public static Map<String, String> adaptWardIdBuff = new ConcurrentHashMap();
    public static Map<String, String> adaptBedIdBuff = new ConcurrentHashMap();
    public static Map<String, String> adaptRoomIdBuff = new ConcurrentHashMap();
    public static Map<String, String> adaptEmpIdBuff = new ConcurrentHashMap();
    public static Map<String, String> adaptDeptIdBuff = new ConcurrentHashMap();

}
