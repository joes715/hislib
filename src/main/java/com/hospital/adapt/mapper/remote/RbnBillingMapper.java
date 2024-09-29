
package com.hospital.adapt.mapper.remote;

import com.hospital.adapt.model.common.ClientRequestParamModel;
import com.hospital.adapt.model.remote.RbnBilling;

import java.util.List;


public interface RbnBillingMapper {
    List<RbnBilling> queryBilling(ClientRequestParamModel param);
}
