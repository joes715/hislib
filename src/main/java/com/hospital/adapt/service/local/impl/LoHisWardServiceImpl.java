
package com.hospital.adapt.service.local.impl;


import com.alibaba.fastjson.JSONObject;
import com.hospital.adapt.service.common.impl.CommonServiceImpl;
import com.hospital.adapt.mapper.local.LbnHisWardMapper;
import com.hospital.adapt.model.remote.RbnWard;
import com.hospital.adapt.model.local.LbnHisWard;
import com.hospital.adapt.service.local.LoHisWardService;
import com.hospital.adapt.utils.LDataBufferUtil;
import com.hospital.adapt.utils.Str2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoHisWardServiceImpl extends CommonServiceImpl<LbnHisWard> implements LoHisWardService {

    private LbnHisWardMapper lbnHisWardMapper = null;
    Logger log = LoggerFactory.getLogger(LoHisWardServiceImpl.class);

    @Resource
    public void setLoBzHisWardMapper(LbnHisWardMapper lbnHisWardMapper) {
        this.lbnHisWardMapper = lbnHisWardMapper;
        this.setMapper(lbnHisWardMapper);
    }

    @Override
    public void synData(List<RbnWard> hisWards) {
        if (null != hisWards && hisWards.size() > 0) {
            int count = 0;
            for (RbnWard rbnWard : hisWards) {
                if (null != rbnWard
                        && Str2.notNull(rbnWard.getward_name())
                        && Str2.notNull(rbnWard.getward_code())
                        && !(LDataBufferUtil.hisWardCodesBuff.contains(rbnWard.getward_code()))) {

                    try {
                        LbnHisWard mWard = new LbnHisWard();
                        BeanUtils.copyProperties(rbnWard, mWard);

                        JSONObject result = edit(mWard);
                        if (result.getIntValue("status") == 0) {
                            LDataBufferUtil.hisWardCodesBuff.add(rbnWard.getward_code());
                            count++;
                        }
                    } catch (Exception e) {
                        log.error("LoHisWardServiceImpl synData exception:", e);
                    }
                }
            }
        }
    }
}
