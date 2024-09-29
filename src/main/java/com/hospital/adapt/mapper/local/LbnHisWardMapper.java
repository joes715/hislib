package com.hospital.adapt.mapper.local;

import com.hospital.adapt.mapper.common.BnCommonMapper;
import com.hospital.adapt.model.local.LbnHisWard;

import java.util.List;


public interface LbnHisWardMapper extends BnCommonMapper<LbnHisWard> {

    LbnHisWard queryBySn(String ward_code);

    String queryIdBySn(String ward_code);

    List<LbnHisWard> queryAllSimply();

    String queryLocalWardIdByHisWardSn(String his_ward_sn);

    String querySnByHisSn(String hisWardSn);

    List<LbnHisWard> queryByLocalWardSn();

    List<String> queryLocalWardsns();

    public String queryLocalWardIdByLocalWardsn(String localWardsn);

    List<String> queryHisWardsnByLocalWardsn(String localWardsn);

    List<String> queryHisWardNames();

    List<String> queryHisWardCodes();

}
