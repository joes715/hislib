
package com.hospital.adapt.service.remote.ws.impl;


import com.hospital.adapt.model.remote.RbnRoom;
import com.hospital.adapt.model.wrapper.RoomsWrapper;
import com.hospital.adapt.service.local.LoRoomService;
import com.hospital.adapt.service.remote.ws.RwsRoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class RwsRoomServiceImpl implements RwsRoomService {
    @Autowired
    private LoRoomService loRoomService = null;
    private static Logger logger = LoggerFactory.getLogger(RwsRoomServiceImpl.class);

    @Override
    public void synData(RoomsWrapper sr) {
        if (null != sr) {
            List<RbnRoom> rRooms = sr.getWsRooms();
            if (null != rRooms && rRooms.size() > 0) {
                logger.info("room count: " + rRooms.size());
                loRoomService.synData(rRooms);
            } else {
                logger.error("");
            }
        }
    }

}
