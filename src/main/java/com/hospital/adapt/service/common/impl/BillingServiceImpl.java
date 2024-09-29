
package com.hospital.adapt.service.common.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hospital.adapt.constant.Statics;
import com.hospital.adapt.mapper.remote.RbnBillingMapper;
import com.hospital.adapt.model.common.ClientRequestParamModel;
import com.hospital.adapt.model.remote.RbnBilling;
import com.hospital.adapt.service.common.BillingService;
import com.hospital.adapt.utils.Str2;
import com.hospital.adapt.utils.Utl2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Service
public class BillingServiceImpl extends CommonServiceImpl<RbnBilling> implements BillingService {
    @Autowired
    private RbnBillingMapper rbnBillingMapper = null;

    private static Logger log = LoggerFactory.getLogger(BillingServiceImpl.class);

    @Override
    public String queryBilling(ClientRequestParamModel param) {
        String result = null;

        switch (Statics.adaptType) {
            case "view":
                result = queryBillingFromWS(param);
                break;
            case "ws":
                result = queryBillingFromView(param);
                break;
        }

        return result;
    }

    private String queryBillingFromView(ClientRequestParamModel param) {
        String result = "{}";

        if ((null == param.getStartDate() || param.getStartDate().trim().length() <= 0)
                || (null == param.getEndDate() || param.getEndDate().trim().length() <= 0)) {

            if ((null == param.getStartDate() || param.getStartDate().trim().length() <= 0)
                    && (null == param.getEndDate() || param.getEndDate().trim().length() <= 0)) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar c = Calendar.getInstance();
                String date = sdf.format(c.getTime());
                param.setStartDate(date + " 00:00:00");
                param.setEndDate(date + " 23:59:59");
            } else if (null == param.getStartDate() || param.getStartDate().trim().length() <= 0) {
                param.setStartDate(param.getEndDate() + " 00:00:00");
            } else {
                param.setEndDate(param.getStartDate() + " 23:59:59");
            }
        } else {
            param.setStartDate(param.getStartDate() + " 00:00:00");
            param.setEndDate(param.getEndDate() + " 23:59:59");
        }

        List<RbnBilling> billings = null;
        try {
            billings = rbnBillingMapper.queryBilling(param);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        if (null != billings && billings.size() > 0) {
            JSONObject data = new JSONObject();
            data.put("rows", billings);

            JSONObject foo = new JSONObject();
            foo.put("item_price", getTotalFee(billings));
            List<JSONObject> foos = new ArrayList();
            foos.add(foo);
            data.put("footer", foos);

            result = JSON.toJSONString(data);
        }

        return result;
    }

    private double getTotalFee(List<RbnBilling> billings) {
        double result = 0.00;
        if (null != billings && billings.size() > 0) {
            for (RbnBilling bill : billings) {
                if (Str2.notNull(bill.getItem_total_amt())) {
                    try {
                        double amt = Double.parseDouble(bill.getItem_total_amt());
                        result += amt;
                    } catch (Exception e) {
                        Utl2.getExceptionMsg(e);
                    }
                }
            }
        }
        return result;
    }

    private String queryBillingFromWS(ClientRequestParamModel param) {
        String result = null;

        return result;
    }
}
