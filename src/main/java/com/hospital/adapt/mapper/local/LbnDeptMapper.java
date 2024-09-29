
package com.hospital.adapt.mapper.local;


import com.hospital.adapt.mapper.common.BnCommonMapper;
import com.hospital.adapt.model.local.LbnDept;

import java.util.List;


public interface LbnDeptMapper extends BnCommonMapper<LbnDept> {
    List<LbnDept> queryForBuff();

    List<String> queryDeptNames();

    List<String> queryDeptCodes();

    String queryIdBySn(String dept_code);
}

		
