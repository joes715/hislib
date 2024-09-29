
package com.hospital.adapt.service.local;


import com.hospital.adapt.service.common.CommonService;
import com.hospital.adapt.model.local.LbnEmp;
import com.hospital.adapt.model.remote.RbnEmp;

import java.util.List;


public interface LoEmpService extends CommonService<LbnEmp> {
    void synData(List<RbnEmp> rbnEmps);
}
