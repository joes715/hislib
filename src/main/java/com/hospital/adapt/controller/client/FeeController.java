package com.hospital.adapt.controller.client;

import com.hospital.adapt.controller.BaseController;
import com.hospital.adapt.model.common.ClientRequestParamModel;
import com.hospital.adapt.service.common.BillingService;
import com.hospital.adapt.utils.Str2;
import com.hospital.adapt.utils.U2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FeeController extends BaseController {
    @Resource
    private BillingService billingService = null;

    @GetMapping(value = {"/client/fee", "/hospitaldock/client/fee"})
    public void queryFee(HttpServletRequest req, HttpServletResponse res, ClientRequestParamModel param) {
        String result = "{}";

        String act = U2.get("act", req.getParameterMap());
        if (Str2.notNull(act)) {
            if (act.contentEquals("queryBilling")) {
                result = billingService.queryBilling(param);
            }
        }

        response(res, result);
    }

}
