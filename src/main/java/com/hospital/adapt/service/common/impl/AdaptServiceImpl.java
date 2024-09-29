package com.hospital.adapt.service.common.impl;

import com.alibaba.fastjson.JSONObject;
import com.hospital.adapt.constant.Statics;
import com.hospital.adapt.service.remote.view.RviAdaptService;
import com.hospital.adapt.service.remote.ws.RwsAdaptService;
import com.hospital.adapt.service.common.AdaptService;
import com.hospital.adapt.utils.Str2;
import com.hospital.adapt.utils.Ut2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdaptServiceImpl implements AdaptService {
    @Resource
    private RviAdaptService rviAdaptService = null;
    @Resource
    private RwsAdaptService rwsAdaptService = null;


    Logger log = LoggerFactory.getLogger(AdaptServiceImpl.class);

    @Override
    public JSONObject startAdapt(String adapt_type) {
        JSONObject result = Ut2.getFail("startDocking");

        if (Str2.notNull(adapt_type)) {
            if (adapt_type.contentEquals(Statics.ADAPT_VIEW)) {
                result = rviAdaptService.startAdapt();
            } else if (adapt_type.contentEquals(Statics.ADAPT_WS)) {
                result = rwsAdaptService.startAdapt();
            } else {
                log.warn("---------Sync type error---------");
                result.replace("msg", "Sync type error...");
            }
        } else {
            log.warn("---------Sync type error---------");
            result.replace("msg", "Sync type error...");
        }

        return result;
    }

    @Override
    public JSONObject stopAdapt(String dock_type) {
        JSONObject result = Ut2.getSucc("stopDocking");

        log.info("--------- Closing sync thread ---------");
        rviAdaptService.stopAdapt();
        rwsAdaptService.stopAdapt();

        return result;
    }

    @Override
    public void setCfg(JSONObject cfg) {
        if (null != cfg) {
            Statics.synPatSchedule = cfg.getIntValue("syn_patient_schedule");
            Statics.synAllSchedule = cfg.getIntValue("syn_all_schedule");
            Statics.enableAdapt = cfg.getString("enable_docking");
            Statics.adaptType = cfg.getString("dock_type");
            Statics.wsUrl = cfg.getString("ws_url");
            Statics.wsOpt1 = cfg.getString("ws_opt1");
            Statics.wsOpt2 = cfg.getString("ws_opt2");
        }
    }
}
