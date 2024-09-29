
package com.hospital.adapt.service.local;


import com.hospital.adapt.service.common.CommonService;
import com.hospital.adapt.model.local.LbnRoom;
import com.hospital.adapt.model.remote.RbnRoom;

import java.util.List;


public interface LoRoomService extends CommonService<LbnRoom> {
    void synData(List<RbnRoom> rbnRooms);
}
