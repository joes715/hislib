
package com.hospital.adapt.service.local.impl;


import com.alibaba.fastjson.JSONObject;
import com.hospital.adapt.service.common.impl.CommonServiceImpl;
import com.hospital.adapt.mapper.local.LbnHisWardMapper;
import com.hospital.adapt.mapper.local.LbnRoomMapper;
import com.hospital.adapt.model.local.LbnRoom;
import com.hospital.adapt.model.remote.RbnRoom;
import com.hospital.adapt.service.local.LoRoomService;
import com.hospital.adapt.utils.LDataBufferUtil;
import com.hospital.adapt.utils.Str2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoRoomServiceImpl extends CommonServiceImpl<LbnRoom> implements LoRoomService {

    private LbnRoomMapper lbnRoomMapper = null;

    @Resource
    private LbnHisWardMapper lbnHisWardMapper = null;

    @Resource
    public void setLoBzRoomMapper(LbnRoomMapper lbnRoomMapper) {
        this.lbnRoomMapper = lbnRoomMapper;
        this.setMapper(lbnRoomMapper);
    }

    Logger log = LoggerFactory.getLogger(LoRoomServiceImpl.class);

    @Override
    public void synData(List<RbnRoom> rRooms) {
        if (null != rRooms && rRooms.size() > 0) {
            int count = 0;
            for (RbnRoom rRoom : rRooms) {
                if (null != rRoom) {
                    try {
                        String wardId = LDataBufferUtil.adaptWardIdBuff.get(rRoom.getward_code());
                        if (Str2.notNull(wardId) && Str2.notNull(rRoom.getroom_name())) {
                            String key = wardId + "_" + rRoom.getroom_name();
                            if (!(LDataBufferUtil.adaptRoomIdBuff.containsKey(key))) {
                                LbnRoom lbnRoom = new LbnRoom();
                                lbnRoom.setward_id(wardId);
                                lbnRoom.setroom_name(rRoom.getroom_name());
                                lbnRoom.setroom_code(rRoom.getroom_name());
                                try {
                                    Integer sort_code = Integer.parseInt(rRoom.getroom_name());
                                    lbnRoom.setsort_code(sort_code);
                                } catch (Exception e) {
                                    lbnRoom.setsort_code(100);
                                }
                                JSONObject result = edit(lbnRoom);
                                if (result.getIntValue("status") == 0) {
                                    LDataBufferUtil.adaptRoomIdBuff.put(key, lbnRoom.getroom_id());
                                    count++;
                                }
                            }
                        } else {
                            log.info("Not found ward: roomsn:" + rRoom.getroom_name() + " ward sn:" + rRoom.getward_code());
                        }
                    } catch (Exception e) {
                        log.error("Sync exception...", e);
                    }
                }
            }
            log.info("Room count:" + count);
        }
    }
}
