package com.hospital.adapt.service.local.impl;


import com.alibaba.fastjson.JSONObject;
import com.hospital.adapt.service.common.impl.CommonServiceImpl;
import com.hospital.adapt.mapper.local.LbnPayTypeMapper;
import com.hospital.adapt.model.local.LbnPayType;
import com.hospital.adapt.model.remote.RbnPayType;
import com.hospital.adapt.service.local.LoPayTypeService;
import com.hospital.adapt.utils.LDataBufferUtil;
import com.hospital.adapt.utils.Str2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class LoPayTypeServiceImpl extends CommonServiceImpl<LbnPayType> implements LoPayTypeService {

    private LbnPayTypeMapper lbnPayTypeMapper = null;

    private static Logger log = LoggerFactory.getLogger(LoPayTypeServiceImpl.class);

    @Resource
    public void setBizPaymentTypeMapper(LbnPayTypeMapper lbnPayTypeMapper) {
        this.lbnPayTypeMapper = lbnPayTypeMapper;
        this.setMapper(lbnPayTypeMapper);
    }

    @Override
    public void synData(List<RbnPayType> rPaymentTypes) {
        if (null != rPaymentTypes && rPaymentTypes.size() > 0) {
            int count = 0;
            for (RbnPayType mType : rPaymentTypes) {
                try {
                    if (null != mType
                            && Str2.notNull(mType.getpay_name())
                            && Str2.notNull(mType.getroom_code())
                            && !(LDataBufferUtil.payTypeNamesBuff.contains(mType.getpay_name()))) {

                        LbnPayType lbnPayType = new LbnPayType();
                        BeanUtils.copyProperties(mType, lbnPayType);

                        try {
                            Integer sort_code = Integer.parseInt(mType.getroom_code());
                            lbnPayType.setsort_code(sort_code);
                        } catch (Exception e) {
                            lbnPayType.setsort_code(100);
                        }

                        JSONObject result = edit(lbnPayType);
                        if (result.getIntValue("status") == 0) {
                            LDataBufferUtil.payTypeNamesBuff.add(mType.getpay_name());
                            count++;
                        }
                    }
                } catch (Exception e) {

                }
            }
        }
    }
}

