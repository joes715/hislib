package com.hospital.adapt.service.remote.ws.impl;

import com.alibaba.fastjson.JSONObject;
import com.hospital.adapt.constant.Statics;
import com.hospital.adapt.model.remote.RbnWard;
import com.hospital.adapt.model.wrapper.*;
import com.hospital.adapt.service.remote.ws.*;
import com.hospital.adapt.model.wrapper.*;
import com.hospital.adapt.service.local.LoLogService;
import com.hospital.adapt.service.remote.ws.*;
import com.hospital.adapt.utils.Str2;
import com.hospital.adapt.utils.Ut2;
import com.hospital.adapt.utils.Utl2;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class RwsAdaptServiceImpl implements RwsAdaptService {
    @Resource
    private RwsWardService rwsWardService = null;
    @Resource
    private RwsDeptService rwsDeptService = null;
    @Resource
    private RwsRoomService rwsRoomService = null;
    @Resource
    private RwsBedService rwsBedService = null;
    @Resource
    private RwsEmpService rwsEmpService = null;
    @Resource
    private RwsPatientService rwsPatientService = null;
    @Resource
    private RwsPayTypeService rwsPayTypeService = null;
    @Resource
    private LoLogService loLogService = null;

    private boolean isSyningAll = false;
    private boolean isSyningPatient = false;
    private boolean isJson = false;


    private Logger log = LoggerFactory.getLogger(RwsAdaptServiceImpl.class);
    private List<Timer> timers = new ArrayList<Timer>();

    private static final String SYN_CODE_WARD = "S001";
    private static final String SYN_CODE_ROOM = "S002";
    private static final String SYN_CODE_BED = "S003";
    private static final String SYN_CODE_EMPLOYEE = "S004";
    private static final String SYN_CODE_PATIENT = "S005";
    private static final String SYN_CODE_PAYMENT_TYPE = "S006";
    private static final String SYN_CODE_BILLING = "S007";
    private static final String SYN_CODE_DEPT = "S008";

    private static XStream xs = null;

    private String getRemoteData(String msgCode, String requestParam) throws Exception {
        String data = null;
        return data;
    }

    @Override
    public JSONObject startAdapt() {
        JSONObject result = Ut2.getSucc("startDocking");
        Statics.resetDockMsg();
        stopAdapt();

        if (isCanSynAll()) {
            timers.clear();
            Timer timer1 = new Timer();
            timer1.schedule(new SyncAllTask(), 5000, (1000 * 60 * Statics.synAllSchedule));
            timers.add(timer1);

            Timer timer2 = new Timer();
            timer2.schedule(new SyncPatientTask(), 600000, (1000 * 60 * Statics.synPatSchedule));
            timers.add(timer2);

            result.replace("msg", "WS Start success");
        } else {
            result.replace("msg", "WS can not start sync");
        }

        return result;
    }

    @Override
    public JSONObject stopAdapt() {
        if (timers.size() > 0) {
            for (Timer timer : timers) {
                if (null != timer) {
                    timer.cancel();
                    timer.purge();
                    timer = null;
                }
            }

            timers.clear();
        }

        isSyningAll = false;
        isSyningPatient = false;

        return Ut2.getSucc("stopDocking");
    }

    private void synData() {

        if (isCanSynAll()) {
            isSyningAll = true;

            try {
                synWard();
                synDept();
                synRoom();
                synBed();
                synEmployee();
                synPaymentType();
                synPatient();
            } catch (Exception e) {
                log.error("WSDockingServiceImpl synData exception:", e);
            }

            isSyningAll = false;
        } else {
            log.warn("");
        }
    }

    private void synWard() {
        String msgXml = null;
        try {
            msgXml = getRemoteData(SYN_CODE_WARD, null);
        } catch (Exception e) {
            log.error("WSDockingServiceImpl synArea exception:", e);
            Utl2.insertLogMsg(loLogService, "WSDockingServiceImpl synArea exception", "adapter", "adapter", e);
        }

        if (Str2.notNull(msgXml)) {
            Object dataContainer = dataHandler(msgXml, Statics.WARD_SYN, isJson);
            WardsWrapper wardsWrapper = null;
            if (null != dataContainer) {
                wardsWrapper = (WardsWrapper) dataContainer;
                rwsWardService.synData(wardsWrapper);
            } else {
                log.info("");
            }
        }

    }

    private void synDept() {
        String msgXml = null;
        try {
            msgXml = getRemoteData(SYN_CODE_DEPT, null);
        } catch (Exception e) {
            log.error("WSDockingServiceImpl synDept exception:", e);
            Utl2.insertLogMsg(loLogService, "WSDockingServiceImpl synDept exception", "adapter", "adapter", e);
        }

        if (Str2.notNull(msgXml)) {
            Object dataContainer = dataHandler(msgXml, Statics.DEPT_SYN, isJson);
            DeptsWrapper deptsWrapper = null;
            if (null != dataContainer) {
                deptsWrapper = (DeptsWrapper) dataContainer;
                rwsDeptService.synData(deptsWrapper);
            } else {
                log.info("");
            }
        }
    }

    private void synRoom() {
        String msgXml = null;
        try {
            msgXml = getRemoteData(SYN_CODE_ROOM, null);
        } catch (Exception e) {
            log.error("WSDockingServiceImpl synRoom exception:", e);
            Utl2.insertLogMsg(loLogService, "WSDockingServiceImpl synRoom exception", "adapter", "adapter", e);
        }

        if (Str2.notNull(msgXml)) {
            Object dataContainer = dataHandler(msgXml, Statics.ROOM_SYN, isJson);
            RoomsWrapper synRooms = null;
            if (null != dataContainer) {
                synRooms = (RoomsWrapper) dataContainer;
                rwsRoomService.synData(synRooms);
            } else {
                log.info("");
            }
        }
    }
    private void synBed() {
        String msgXml = null;
        try {
            msgXml = getRemoteData(SYN_CODE_BED, null);
        } catch (Exception e) {
            log.error("WSDockingServiceImpl synBed exception:", e);
            Utl2.insertLogMsg(loLogService, "WSDockingServiceImpl synBed exception", "adapter", "adapter", e);
        }

        if (Str2.notNull(msgXml)) {
            Object dataContainer = dataHandler(msgXml, Statics.BED_SYN, isJson);
            BedsWrapper synBeds = null;
            if (null != dataContainer) {
                synBeds = (BedsWrapper) dataContainer;
                rwsBedService.synData(synBeds);
            } else {
                log.info("");
            }
        }
    }

    private void synEmployee() {

        String msgXml = null;
        try {
            msgXml = getRemoteData(SYN_CODE_EMPLOYEE, null);
        } catch (Exception e) {
            log.error("WSDockingServiceImpl synEmployee exception:", e);
            Utl2.insertLogMsg(loLogService, "WSDockingServiceImpl synEmployee exception", "adapter", "adapter", e);
        }

        if (Str2.notNull(msgXml)) {
            Object dataContainer = dataHandler(msgXml, Statics.EMPLOYEE_SYN, isJson);
            EmpsWrapper synEmployees = null;
            if (null != dataContainer) {
                synEmployees = (EmpsWrapper) dataContainer;
                rwsEmpService.synData(synEmployees);
            } else {
                log.info("");
            }
        }

    }

    private void synPatient() {

        if (isCanSynPatient()) {
            isSyningPatient = true;

            try {
                String msgXml = null;
                try {
                    msgXml = getRemoteData(SYN_CODE_PATIENT, null);
                    Statics.setDockSucc();
                } catch (Exception e) {
                    Statics.setDockFail();
                    log.error("WSDockingServiceImpl synPatient exception:", e);
                    Utl2.insertLogMsg(loLogService, "WSDockingServiceImpl synPatient exception", "adapter", "adapter", e);
                }

                if (Str2.notNull(msgXml)) {
                    Object dataContainer = dataHandler(msgXml, Statics.PATIENT_SYN, isJson);
                    PatsWrapper synPatients = null;
                    if (null != dataContainer) {
                        synPatients = (PatsWrapper) dataContainer;
                        rwsPatientService.synDelete(synPatients.getZyhms());
                        rwsPatientService.synData(synPatients);
                    } else {
                        log.info("");
                    }
                }
            } catch (Exception e) {
                log.error("WSDockingServiceImpl synPatient exception:", e);
            }

            isSyningPatient = false;
        } else {
            log.warn("------------------");
        }
    }

    private void synPaymentType() {

        String msgXml = null;
        try {
            msgXml = getRemoteData(SYN_CODE_PAYMENT_TYPE, null);
        } catch (Exception e) {
            log.error("WSDockingServiceImpl synPaymentType exception:", e);
            Utl2.insertLogMsg(loLogService, "WSDockingServiceImpl synPaymentType exception", "adapter", "adapter", e);
        }

        if (Str2.notNull(msgXml)) {
            Object dataContainer = dataHandler(msgXml, Statics.PAYMENT_TYPE_SYN, isJson);
            PayTypesWrapper synPaymentTypes = null;
            if (null != dataContainer) {
                synPaymentTypes = (PayTypesWrapper) dataContainer;
                rwsPayTypeService.synData(synPaymentTypes);
            } else {
                log.info("");
            }
        }
    }

    synchronized private Object dataHandler(String content, int dataType, boolean is_json) {
        Object obj = null;

        if (Str2.notNull(content)) {
            if (is_json) {
                try {
                    obj = dataParser(content, dataType, is_json);
                } catch (Exception e) {
                    log.error("WSDockingServiceImpl dataHandler exception:", e);
                }
            } else {
                try {
                    Document doc = DocumentHelper.parseText(content);
                    Node statusNode = doc.selectSingleNode("Response/Code");
                    String statusCode = statusNode.getStringValue();
                    if (Str2.notNull(statusCode)) {
                        Integer code = Integer.parseInt(statusCode);
                        if (code == 200) {
                            obj = dataParser(content, dataType, is_json);
                        } else {
                            log.error("ERRCode: " + statusCode);
                        }
                    } else {
                        log.error("Get response code exception...");
                    }
                } catch (Exception e) {
                    log.error("WSDockingServiceImpl dataHandler exception:", e);
                }
            }
        }

        return obj;
    }

    private Object dataParser(String content, int dataType, boolean is_json) throws Exception {
        Object obj = null;

        if (Str2.notNull(content)) {
            xs = Utl2.getXSInstanceByType(dataType, is_json);
            obj = xs.fromXML(content);
        }

        return obj;
    }

    private class SyncPatientTask extends TimerTask {
        @Override
        public void run() {
            synPatient();
        }
    }

    private class SyncAllTask extends TimerTask {
        @Override
        public void run() {
            synData();
        }
    }

    private boolean isCanSynAll() {
        return (Statics.enableAdapt.contentEquals(Statics.ADAPT_ON)
                && Statics.adaptType.contentEquals(Statics.ADAPT_WS)
                && !isSyningAll);
    }

    private boolean isCanSynPatient() {
        return (Statics.enableAdapt.contentEquals(Statics.ADAPT_ON)
                && Statics.adaptType.contentEquals(Statics.ADAPT_WS)
                && !isSyningPatient);
    }

    public static void main(String args[]) {

    }
}
