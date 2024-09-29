
package com.hospital.adapt.mapper.remote;


import com.hospital.adapt.mapper.common.CommonMapper;
import com.hospital.adapt.model.common.MyPage;
import com.hospital.adapt.model.remote.RbnRoom;

import java.util.List;

public interface RbnRoomMapper extends CommonMapper<RbnRoom> {

    List<RbnRoom> queryByParam(MyPage mPage);
}
