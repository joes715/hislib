
package com.hospital.adapt.constant;


import com.alibaba.fastjson.JSONObject;

final public class Statics {

    public final static String CHARSET = "UTF-8";

    public static String enableAdapt = "off";
    public static String adaptType = "view";
    public static int synPatSchedule = 10;
    public static int synAllSchedule = 60;
    public static String wsUrl = "";
    public static String wsOpt1 = "";
    public static String wsOpt2 = "";

    public static long DATACENTER_ID = 1L;
    public static long MACHINE_ID = 2L;
    public static final String ADAPT_OFF = "off";
    public static final String ADAPT_ON = "on";
    public static final String ADAPT_VIEW = "view";
    public static final String ADAPT_WS = "ws";

    public static final int WARD_SYN = 0;
    public static final int ROOM_SYN = 1;
    public static final int BED_SYN = 2;
    public static final int EMPLOYEE_SYN = 3;
    public static final int PATIENT_SYN = 4;
    public static final int PAYMENT_TYPE_SYN = 5;
    public static final int DEPT_SYN = 6;

    public static String MQ_MSG_EXPIRATION = "3000";

    public static JSONObject adaptExceptionMsg = new JSONObject();

    public static void resetDockMsg() {
        Statics.adaptExceptionMsg.put("statusCode", 0);
        Statics.adaptExceptionMsg.put("msg", "Success");
    }

    public static void setDockFail() {
        Statics.adaptExceptionMsg.replace("statusCode", -1);
        Statics.adaptExceptionMsg.replace("msg", "Sync exception");
    }

    public static void setDockSucc() {
        Statics.adaptExceptionMsg.replace("statusCode", 0);
        Statics.adaptExceptionMsg.replace("msg", "Success");
    }

}
