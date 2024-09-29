
package com.hospital.adapt.service.remote.view;

import com.hospital.adapt.model.remote.RbnRoom;
import com.hospital.adapt.service.common.CommonService;

import java.util.Map;

public interface RviRoomService extends CommonService<RbnRoom> {
    void synAll();

    String queryByParam(Map<String, String[]> param);
}
