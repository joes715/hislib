
package com.hospital.adapt.service.local;

import com.hospital.adapt.service.common.BnCommonService;
import com.hospital.adapt.model.local.LbnPayType;
import com.hospital.adapt.model.remote.RbnPayType;

import java.util.List;

public interface LoPayTypeService extends BnCommonService<LbnPayType> {
    void synData(List<RbnPayType> types);
}
