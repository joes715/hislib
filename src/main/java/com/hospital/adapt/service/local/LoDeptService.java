
package com.hospital.adapt.service.local;

import com.hospital.adapt.service.common.CommonService;
import com.hospital.adapt.model.local.LbnDept;
import com.hospital.adapt.model.remote.RbnDept;

import java.util.List;


public interface LoDeptService extends CommonService<LbnDept> {

    public void synData(List<RbnDept> depts);
}
