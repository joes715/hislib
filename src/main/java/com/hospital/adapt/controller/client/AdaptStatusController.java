package com.hospital.adapt.controller.client;

import com.hospital.adapt.controller.BaseController;
import com.hospital.adapt.constant.Statics;
import com.hospital.adapt.utils.Str2;
import com.hospital.adapt.utils.U2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdaptStatusController extends BaseController {
    @GetMapping(value = {"/client/dock", "/hospitaldock/client/dock"})
    public void queryDockStatus(HttpServletRequest req, HttpServletResponse res) {
        String result = "{}";
        String act = U2.get("act", req.getParameterMap());

        if (Str2.notNull(act)) {
            if (act.contentEquals("queryDockStatus")) {
                result = Statics.adaptExceptionMsg.toJSONString();
            }
        }

        response(res, result);
    }

}
