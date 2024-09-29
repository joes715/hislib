
package com.hospital.adapt.service.local;


import com.hospital.adapt.service.common.CommonService;
import com.hospital.adapt.model.local.LbnPatient;
import com.hospital.adapt.model.remote.RbnPatient;

import java.util.List;


public interface LoPatientService extends CommonService<LbnPatient> {
    void synData(List<RbnPatient> reBzBeds);

    void synDelete(String staynos);
}
