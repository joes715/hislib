
package com.hospital.adapt.service.remote.view;

import com.hospital.adapt.model.remote.RbnPatient;
import com.hospital.adapt.service.common.CommonService;

import java.util.Map;

public interface RviPatientService extends CommonService<RbnPatient> {
    String queryByParam(Map<String, String[]> param);

    void deleteNotExist();

    void synAll();

}
