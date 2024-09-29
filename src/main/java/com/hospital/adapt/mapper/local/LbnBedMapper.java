
package com.hospital.adapt.mapper.local;


import com.hospital.adapt.mapper.common.BnCommonMapper;
import com.hospital.adapt.model.local.LbnBed;

import java.util.List;
import java.util.Map;


public interface LbnBedMapper extends BnCommonMapper<LbnBed> {
    String queryLocalBedIdsByHisBeds(Map<String, Object> params);

    List<LbnBed> queryForBuff();

    String queryBedIdByParam(Map<String, String> param);
}

		
