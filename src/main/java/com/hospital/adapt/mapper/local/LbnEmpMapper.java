
package com.hospital.adapt.mapper.local;

import com.hospital.adapt.mapper.common.BnCommonMapper;
import com.hospital.adapt.model.local.LbnEmp;

import java.util.List;
import java.util.Map;


public interface LbnEmpMapper extends BnCommonMapper<LbnEmp> {
    LbnEmp queryById(String emp_id);

    LbnEmp queryByNameJn(Map<String, Object> params);

    String queryIdByNameJn(Map<String, String> params);

    LbnEmp queryByJn(String emp_job);

    String queryIdByJn(String emp_job);

    List<LbnEmp> queryForBuff();
}
