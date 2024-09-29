
package com.hospital.adapt.mapper.local;

import java.util.List;

public interface LbnNursLvlMapper {
    List<String> queryAllNursingLevelSn();

    String querySnBysn(String level_code);
}
