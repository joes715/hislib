
package com.hospital.adapt.service.local;


import com.hospital.adapt.service.common.CommonService;
import com.hospital.adapt.model.local.LbnBed;
import com.hospital.adapt.model.remote.RbnBed;

import java.util.List;


public interface LoBedService extends CommonService<LbnBed> {
    void synData(List<RbnBed> rbnBeds);
}
