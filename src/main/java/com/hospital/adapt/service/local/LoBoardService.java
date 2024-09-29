
package com.hospital.adapt.service.local;


import com.hospital.adapt.service.common.CommonService;
import com.hospital.adapt.model.local.LbnBoard;

import java.util.Map;

public interface LoBoardService extends CommonService<LbnBoard> {
    String queryStatistic(Map<String, String[]> param);
}
