package com.hospital.adapt.service.remote.view.impl;

import com.alibaba.fastjson.JSONObject;
import com.hospital.adapt.constant.Statics;
import com.hospital.adapt.service.common.LocEnvInitService;
import com.hospital.adapt.service.remote.view.*;
import com.hospital.adapt.service.remote.view.*;
import com.hospital.adapt.utils.Ut2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class RviAdaptServiceImpl implements RviAdaptService {
    @Resource
    private RviWardService rviWardService = null;
    @Resource
    private RviBedService rviBedService = null;
    @Resource
    private RviRoomService rviRoomService = null;
    @Resource
    private RviEmpService rviEmpService = null;
    @Resource
    private RviPatientService rviPatientService = null;
    @Resource
    private RviPayTypeService rviPayTypeService = null;
    @Resource
    private LocEnvInitService locEnvInitService = null;

    Logger log = LoggerFactory.getLogger(RviAdaptServiceImpl.class);

    private boolean isSyningAll = false;
    private boolean isSyningPatient = false;

    private List<Timer> timers = new ArrayList<Timer>();


    @Override
    public JSONObject startAdapt() {
        JSONObject result = Ut2.getSucc("startDocking");
        Statics.resetDockMsg();
        stopAdapt();

        if (isCanSynAll()) {
            Timer synAllTimer = new Timer();
            synAllTimer.schedule(new SynAllTask(), 5000, (1000 * 60 * Statics.synAllSchedule));
            timers.add(synAllTimer);

            Timer synPatientTimer = new Timer();
            synPatientTimer.schedule(new SynPatientTask(), 600000, (1000 * 60 * Statics.synPatSchedule));
            timers.add(synPatientTimer);

            result.replace("msg", "Start sync success");
        } else {
            result.replace("msg", "Can not start sync task");
        }

        return result;
    }

    @Override
    public JSONObject stopAdapt() {

        try {
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
        } catch (Exception e) {
            log.error("ViewDockingServiceImpl stopDocking exception:", e);
        }

        isSyningAll = false;
        isSyningPatient = false;

        return Ut2.getSucc("stopDocking");
    }

    private void synData() {

        if (isCanSynAll()) {
            isSyningAll = true;

            try {
                deleteNotExist();
                locEnvInitService.initAllBuff();
                rviPayTypeService.synAll();
                //    rviWardService.synAll();
                //    rviRoomService.synAll();
                //    rviBedService.synAll();
                //    rviEmployeeService.synAll();
                synPatient();
            } catch (Exception e) {
                log.error("ViewDockingServiceImpl synData exception:", e);
            }

            isSyningAll = false;
        } else {

        }

    }

    private void deleteNotExist() {
        rviPatientService.deleteNotExist();
    }

    private class SynAllTask extends TimerTask {
        @Override
        public void run() {
            synData();
        }
    }

    private class SynPatientTask extends TimerTask {
        @Override
        public void run() {
            synPatient();
        }
    }

    private void synPatient() {
        if (isCanSynPatient()) {
            isSyningPatient = true;

            try {
                rviPatientService.deleteNotExist();
                locEnvInitService.initPatientBuff();
                rviPatientService.synAll();
            } catch (Exception e) {
                log.error("ViewDockingServiceImpl SynPatientTask exception:", e);
            }

            isSyningPatient = false;
        } else {
        }
    }

    private boolean isCanSynAll() {
        return (Statics.enableAdapt.contentEquals(Statics.ADAPT_ON)
                && Statics.adaptType.contentEquals(Statics.ADAPT_VIEW)
                && !isSyningAll);
    }

    private boolean isCanSynPatient() {
        return (Statics.enableAdapt.contentEquals(Statics.ADAPT_ON)
                && Statics.adaptType.contentEquals(Statics.ADAPT_VIEW)
                && !isSyningPatient);
    }
}
