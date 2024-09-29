
package com.hospital.adapt.service.local;


import com.hospital.adapt.service.common.CommonService;
import com.hospital.adapt.model.local.LbnHisWard;
import com.hospital.adapt.model.remote.RbnWard;

import java.util.List;


public interface LoHisWardService extends CommonService<LbnHisWard> {
    void synData(List<RbnWard> hisWards);
}
