
package com.hospital.adapt.mapper.remote;


import com.hospital.adapt.mapper.common.CommonMapper;
import com.hospital.adapt.model.common.MyPage;
import com.hospital.adapt.model.remote.RbnPatient;

import java.util.List;

public interface RbnPatientMapper extends CommonMapper<RbnPatient> {
    List<String> queryAllZyhm();

    List<RbnPatient> queryByParam(MyPage mPage);
}
