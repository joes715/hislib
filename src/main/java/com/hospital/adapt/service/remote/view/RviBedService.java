
package com.hospital.adapt.service.remote.view;

import com.hospital.adapt.model.remote.RbnBed;
import com.hospital.adapt.service.common.CommonService;

import java.util.Map;

public interface RviBedService extends CommonService<RbnBed> {
    void synAll();

    String queryByParam(Map<String, String[]> param);

}
