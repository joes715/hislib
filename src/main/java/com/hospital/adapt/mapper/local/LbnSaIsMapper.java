
package com.hospital.adapt.mapper.local;


import com.hospital.adapt.mapper.common.CommonMapper;
import com.hospital.adapt.model.local.LbnSaIs;

import java.util.List;

public interface LbnSaIsMapper extends CommonMapper<LbnSaIs> {
    List<LbnSaIs> queryForBuff();
}
