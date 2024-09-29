
package com.hospital.adapt.mapper.local;

import com.hospital.adapt.mapper.common.BnCommonMapper;
import com.hospital.adapt.model.local.LbnRoom;

import java.util.List;
import java.util.Map;


public interface LbnRoomMapper extends BnCommonMapper<LbnRoom> {

    LbnRoom queryByWardIdAndBfbm(Map<String, String> params);

    String queryIdByWardIdAndBfbm(Map<String, String> params);

    List<LbnRoom> queryForBuff();
}
