
package com.hospital.adapt.service.local.impl;


import com.alibaba.fastjson.JSONObject;
import com.hospital.adapt.service.common.impl.CommonServiceImpl;
import com.hospital.adapt.mapper.local.LbnDeptMapper;
import com.hospital.adapt.model.remote.RbnDept;
import com.hospital.adapt.model.local.LbnDept;
import com.hospital.adapt.service.local.LoDeptService;
import com.hospital.adapt.utils.LDataBufferUtil;
import com.hospital.adapt.utils.Str2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoDeptServiceImpl extends CommonServiceImpl<LbnDept> implements LoDeptService {

    private LbnDeptMapper lbnDeptMapper = null;
    Logger log = LoggerFactory.getLogger(LoDeptServiceImpl.class);

    @Resource
    public void setLoBzDeptMapper(LbnDeptMapper lbnDeptMapper) {
        this.lbnDeptMapper = lbnDeptMapper;
        this.setMapper(lbnDeptMapper);
    }

    @Override
    public void synData(List<RbnDept> depts) {
        if (null != depts && depts.size() > 0) {
            int count = 0;
            for (RbnDept rbnDept : depts) {
                if (null != rbnDept
                        && Str2.notNull(rbnDept.getdept_name())
                        && Str2.notNull(rbnDept.getdept_code())
                        && !(LDataBufferUtil.deptCodesBuff.contains(rbnDept.getdept_code()))) {

                    try {
                        LbnDept lbnDept = new LbnDept();
                        BeanUtils.copyProperties(rbnDept, lbnDept);

                        JSONObject result = edit(lbnDept);
                        if (result.getIntValue("status") == 0) {
                            LDataBufferUtil.deptCodesBuff.add(rbnDept.getdept_code());
                            count++;
                        }
                    } catch (Exception e) {
                        log.error("LoDeptServiceImpl synData exception:", e);
                    }
                }
            }
            log.info("Dept count:" + count);
        }
    }

}
