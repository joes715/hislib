
package com.hospital.adapt.mapper.local;

import com.hospital.adapt.mapper.common.BnCommonMapper;
import com.hospital.adapt.model.local.LbnPayType;

import java.util.List;

public interface LbnPayTypeMapper extends BnCommonMapper<LbnPayType> {
    LbnPayType queryBySn(String paymentTypeSn);

    String queryNameByName(String pay_name);

    LbnPayType queryByName(String pay_name);

    Long queryIdBySn(String paymentTypeSn);

    List<String> queryAllPaymentTypeName();
}
