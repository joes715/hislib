package com.hospital.adapt.controller.client;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.adapt.controller.BaseController;
import com.hospital.adapt.service.local.LoBoardService;
import com.hospital.adapt.utils.Str2;
import com.hospital.adapt.utils.U2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController extends BaseController {
    @Resource
    private LoBoardService loBoardService = null;

    @GetMapping(value = {"/client/patient", "/hospitaldock/client/patient"})
    public void queryAll(HttpServletRequest req, HttpServletResponse res) {
        String result = "[]";

        String act = U2.get("act", req.getParameterMap());
        if (Str2.notNull(act)) {
            if (act.contentEquals("patientStatistic")) {
                result = loBoardService.queryStatistic(req.getParameterMap());
            }
        }

        response(res, result);
    }

}
