
package com.hospital.adapt.service.remote.view;

import com.hospital.adapt.model.remote.RbnEmp;
import com.hospital.adapt.service.common.CommonService;

import java.util.Map;

public interface RviEmpService extends CommonService<RbnEmp> {
    void synAll();

    String queryByParam(Map<String, String[]> param);
}
