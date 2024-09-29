package com.hospital.adapt.controller;

import com.hospital.adapt.service.remote.view.RviPatientService;
import com.hospital.adapt.utils.Str2;
import com.hospital.adapt.utils.U2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RmPatientController extends BaseController {
    @Resource
    private RviPatientService rviPatientService = null;


    @GetMapping(value = {"/hospital/rePatient"})
    public void queryAll(HttpServletRequest req, HttpServletResponse res) {
        String result = "[]";

        String act = U2.get("act", req.getParameterMap());
        if (Str2.notNull(act)) {
            if (act.contentEquals("queryByParam")) {
                result = rviPatientService.queryByParam(req.getParameterMap());
            }
        }

        response(res, result);
    }

}
