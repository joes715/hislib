
package com.hospital.adapt.service.local.impl;


import com.alibaba.fastjson.JSONObject;
import com.hospital.adapt.service.common.impl.CommonServiceImpl;
import com.hospital.adapt.mapper.local.LbnBedMapper;
import com.hospital.adapt.mapper.local.LbnHisWardMapper;
import com.hospital.adapt.mapper.local.LbnRoomMapper;
import com.hospital.adapt.model.local.LbnBed;
import com.hospital.adapt.model.remote.RbnBed;
import com.hospital.adapt.service.local.LoBedService;
import com.hospital.adapt.utils.LDataBufferUtil;
import com.hospital.adapt.utils.Str2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoBedServiceImpl extends CommonServiceImpl<LbnBed> implements LoBedService {
    @Resource
    private LbnHisWardMapper lbnHisWardMapper = null;
    @Resource
    private LbnRoomMapper lbnRoomMapper = null;

    private LbnBedMapper lbnBedMapper = null;
    Logger log = LoggerFactory.getLogger(LoBedServiceImpl.class);

    @Resource
    public void setLoBzBedMapper(LbnBedMapper lbnBedMapper) {
        this.lbnBedMapper = lbnBedMapper;
        this.setMapper(lbnBedMapper);
    }

    @Override
    public void synData(List<RbnBed> rBeds) {
        if (null != rBeds && rBeds.size() > 0) {
            int count = 0;
            for (RbnBed rBed : rBeds) {
                if (null != rBed) {
                    try {
                        String wardId = LDataBufferUtil.adaptWardIdBuff.get(rBed.getward_code());
                        if (Str2.notNull(wardId)) {
                            String key = wardId + "_" + rBed.getbed_name();
                            if (!(LDataBufferUtil.adaptBedIdBuff.containsKey(key))) {
                                LbnBed lbnBed = new LbnBed();
                                lbnBed.setward_id(wardId);

                                lbnBed.setbed_code(rBed.getbed_name());
                                lbnBed.setbed_name(rBed.getbed_name());

                                if (Str2.notNull(rBed.getroom_name())) {
                                    String roomId = LDataBufferUtil.adaptRoomIdBuff.get(wardId + "_" + rBed.getroom_name());
                                    lbnBed.setroom_id(roomId);
                                }

                                try {
                                    Integer sort_code = Integer.parseInt(rBed.getbed_name());
                                    lbnBed.setsort_code(sort_code);
                                } catch (Exception e) {
                                    lbnBed.setsort_code(100);
                                }

                                JSONObject result = edit(lbnBed);
                                if (result.getIntValue("status") == 0) {
                                    LDataBufferUtil.adaptBedIdBuff.put(key, lbnBed.getbed_id());
                                    count++;
                                }
                            }
                        } else {
                            log.info("Syn bed but can not found Ward: ward sn:" + rBed.getward_code() + " bedsn:" + rBed.getbed_name());
                        }
                    } catch (Exception e) {
                        log.error("LoBedServiceImpl synData exception:", e);
                    }
                }
            }
            log.info("Sync bed count:" + count);
        }
    }
}
