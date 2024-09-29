
package com.hospital.adapt.mapper.local;


import com.hospital.adapt.mapper.common.BnCommonMapper;
import com.hospital.adapt.model.local.LbnPatientSaIs;

import java.util.Map;


public interface LbnPatientSaIsMapper extends BnCommonMapper<LbnPatientSaIs> {

    void deleteForPatient(Map<String, Object> param);

}
