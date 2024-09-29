
package com.hospital.adapt.mapper.remote;


import com.hospital.adapt.mapper.common.CommonMapper;
import com.hospital.adapt.model.common.MyPage;
import com.hospital.adapt.model.remote.RbnBed;

import java.util.List;

public interface RbnBedMapper extends CommonMapper<RbnBed> {

    List<RbnBed> queryByParam(MyPage mPage);
}
