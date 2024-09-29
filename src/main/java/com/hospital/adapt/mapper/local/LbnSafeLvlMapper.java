
package com.hospital.adapt.mapper.local;


import com.hospital.adapt.mapper.common.CommonMapper;
import com.hospital.adapt.model.local.LbnSafeLvl;

import java.util.List;

public interface LbnSafeLvlMapper extends CommonMapper<LbnSafeLvl> {
    public List<LbnSafeLvl> queryForBuff();
}
