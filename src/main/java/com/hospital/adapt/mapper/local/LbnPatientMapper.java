
package com.hospital.adapt.mapper.local;


import com.hospital.adapt.mapper.common.BnCommonMapper;
import com.hospital.adapt.model.local.LbnNursLvl;
import com.hospital.adapt.model.local.LbnPatient;
import com.hospital.adapt.model.local.LocPatientStatisticMap;
import com.hospital.adapt.model.local.StatisticModel;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;


public interface LbnPatientMapper extends BnCommonMapper<LbnPatient> {

    LbnPatient queryByadm_num(String adm_num);

    void deleteNotInadm_nums(Map<String, Object> map);

    void deleteByZyhm(String adm_num);

    @MapKey("adm_num")
    Map<String, LbnPatient> queryAllToMap();

    Integer getTotal(String localWardId);

    Integer getScTotal(String localWardId);

    List<LbnNursLvl> countLevels(String localWardId);

    Integer countNoLevels(String localWardId);

    List<LocPatientStatisticMap> queryStatisticByLocalBedIdList(String localBedIdList);

    String queryBedDevicesnByAdn(String adm_num);

    String queryRoomDevicesnByAdn(String adm_num);

    List<LocPatientStatisticMap> getChaperonage(String localWardId);

    String queryFingerPrintByZyhm(String adm_num);

    List<StatisticModel> getSafeIsolate(Map<String, Object> qparams);

    List<StatisticModel> getLevelBed(Map<String, Object> qparams);
}
