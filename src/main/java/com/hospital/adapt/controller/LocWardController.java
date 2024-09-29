package com.hospital.adapt.controller;

import com.hospital.adapt.service.local.LoHisWardService;
import com.hospital.adapt.utils.Str2;
import com.hospital.adapt.utils.U2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LocWardController extends BaseController {
    @Resource
    private LoHisWardService loHisWardService = null;

    @GetMapping(value = "/hospital/ward")
    public void queryAll(HttpServletRequest req, HttpServletResponse res) {
        String result = "[]";

        String act = U2.get("act", req.getParameterMap());
        if (Str2.notNull(act)) {
            if (act.contentEquals("queryAll")) {
                result = loHisWardService.queryAll();
            }
        }

        response(res, result);
    }

}
