
package com.hospital.adapt.mapper.remote;

import com.hospital.adapt.model.remote.RbnBoard;

import java.util.List;
import java.util.Map;


public interface RbnBoardMapper {
    List<RbnBoard> queryPatientIn(Map<String, Object> params);

    List<RbnBoard> queryPatientOut(Map<String, Object> params);

    List<RbnBoard> queryPatientOpr(Map<String, Object> params);

    List<RbnBoard> queryPatientMv(Map<String, Object> params);

    List<RbnBoard> queryPatientIllness(Map<String, Object> params);
}
