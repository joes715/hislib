
package com.hospital.adapt.mapper.remote;


import com.hospital.adapt.mapper.common.CommonMapper;
import com.hospital.adapt.model.common.MyPage;
import com.hospital.adapt.model.remote.RbnEmp;

import java.util.List;

public interface RbnEmpMapper extends CommonMapper<RbnEmp> {

    List<RbnEmp> queryByParam(MyPage mPage);
}
