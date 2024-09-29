package com.hospital.adapt.utils;

import com.hospital.adapt.constant.Statics;
import com.hospital.adapt.model.remote.*;
import com.hospital.adapt.model.wrapper.*;
import com.hospital.adapt.service.local.LoLogService;
import com.hospital.adapt.utils.xstream.*;
import com.hospital.adapt.model.local.LbnLog;
import com.hospital.adapt.model.remote.*;
import com.hospital.adapt.model.wrapper.*;
import com.hospital.adapt.utils.xstream.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

public class Utl2 {

    private static Logger log = LoggerFactory.getLogger(Utl2.class);

    private static XStream deptXs = null;
    private static XStream wardXs = null;
    private static XStream roomXs = null;
    private static XStream bedXs = null;
    private static XStream empXs = null;
    private static XStream patXs = null;
    private static XStream paymtXs = null;

    public static XStream getXSInstanceByType(int type, boolean is_json) {
        switch (type) {
            case Statics.DEPT_SYN: {
                if (null == deptXs) {
                    deptXs = buildXStream(is_json);
                    deptXs.alias("Response", DeptsWrapper.class);
                    deptXs.alias("data", RbnDept.class);
                    deptXs.alias("datalist", List.class);
                }
                return deptXs;
            }
            case Statics.WARD_SYN: {
                if (null == wardXs) {
                    wardXs = buildXStream(is_json);
                    wardXs.alias("Response", WardsWrapper.class);
                    wardXs.alias("data", RbnWard.class);
                    wardXs.alias("datalist", List.class);
                }
                return wardXs;
            }
            case Statics.ROOM_SYN: {
                if (null == roomXs) {
                    roomXs = buildXStream(is_json);
                    roomXs.alias("Response", RoomsWrapper.class);
                    roomXs.alias("data", RbnRoom.class);
                    roomXs.alias("datalist", List.class);
                }
                return roomXs;
            }
            case Statics.BED_SYN: {
                if (null == bedXs) {
                    bedXs = buildXStream(is_json);
                    bedXs.alias("Response", BedsWrapper.class);
                    bedXs.alias("data", RbnBed.class);
                    bedXs.alias("datalist", List.class);
                }
                return bedXs;
            }
            case Statics.EMPLOYEE_SYN: {
                if (null == empXs) {
                    empXs = buildXStream(is_json);
                    empXs.alias("Response", EmpsWrapper.class);
                    empXs.alias("data", RbnEmp.class);
                    empXs.alias("datalist", List.class);
                }
                return empXs;
            }
            case Statics.PATIENT_SYN: {
                if (null == patXs) {
                    patXs = buildXStream(is_json);
                    patXs.alias("Response", PatsWrapper.class);
                    patXs.alias("data", RbnPatient.class);
                    patXs.alias("datalist", List.class);
                }
                return patXs;
            }
            case Statics.PAYMENT_TYPE_SYN: {
                if (null == paymtXs) {
                    paymtXs = buildXStream(is_json);
                    paymtXs.alias("Response", PayTypesWrapper.class);
                    paymtXs.alias("data", RbnPayType.class);
                    paymtXs.alias("datalist", List.class);
                }
                return paymtXs;
            }
        }

        return null;
    }

    private static XStream buildXStream(boolean is_json) {
        XStream xsm = null;

        if (is_json) {
            xsm = new XStream(new JettisonMappedXmlDriver());
            //xsm = new XStream(new JsonHierachicalStreamDriver);
        } else {
            xsm = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
        }

        if (null != xsm) {
            XStream.setupDefaultSecurity(xsm);
            xsm.allowTypesByRegExp(new String[]{".*"});

            xsm.registerConverter(new MyIntConverter());
            xsm.registerConverter(new MyLongConverter());
            xsm.registerConverter(new MyDoubleConverter());
            xsm.registerConverter(new MyFloatConverter());
            xsm.registerConverter(new MyDateConverter());

            xsm.ignoreUnknownElements();
            xsm.autodetectAnnotations(true);
        }

        return xsm;
    }

    public static String getExceptionMsg(Exception e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        StringBuffer sb = new StringBuffer();
        sb.append(e.toString()).append("\r\n");
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append("\tat ").append(stackTraceElement.getClassName()).append(".")
                    .append(stackTraceElement.getMethodName())
                    .append("(").append(stackTraceElement.getFileName()).append(":").append(stackTraceElement.getLineNumber())
                    .append(")\r\n");
        }
        return sb.toString();
    }

    public static void insertLogMsg(LoLogService loLogService, String log_txt, String log_creator, String log_type, Exception e) {
        try {
            String detail = e.getMessage();
            LbnLog bnlog = new LbnLog(log_txt, log_creator, log_type, detail);
            loLogService.add(bnlog);
        } catch (Exception e1) {
            log.error("Insert log：", e1);
        }
    }

    private static void main(String args[]) {

    }
}
