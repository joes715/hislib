package com.hospital.adapt.service.local.impl;

import com.alibaba.fastjson.JSONObject;
import com.hospital.adapt.service.common.impl.CommonServiceImpl;
import com.hospital.adapt.mapper.local.LbnEmpMapper;
import com.hospital.adapt.model.local.LbnEmp;
import com.hospital.adapt.model.remote.RbnEmp;
import com.hospital.adapt.service.local.LoEmpService;
import com.hospital.adapt.utils.LDataBufferUtil;
import com.hospital.adapt.utils.Str2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoEmpServiceImpl extends CommonServiceImpl<LbnEmp> implements LoEmpService {
    private LbnEmpMapper lbnEmpMapper = null;
    Logger log = LoggerFactory.getLogger(LoEmpServiceImpl.class);

    @Resource
    public void setLoBzEmployeeMapper(LbnEmpMapper lbnEmpMapper) {
        this.lbnEmpMapper = lbnEmpMapper;
        this.setMapper(lbnEmpMapper);
    }

    @Override
    public void synData(List<RbnEmp> rEmployees) {
        if (null != rEmployees && rEmployees.size() > 0) {
            int count = 0;
            for (RbnEmp rEmployee : rEmployees) {
                if (null != rEmployee) {
                    try {
                        if (Str2.notNull(rEmployee.getemp_name()) && Str2.notNull(rEmployee.getemp_job())) {
                            String key = rEmployee.getemp_name() + "_" + rEmployee.getemp_job();
                            if (!(LDataBufferUtil.adaptEmpIdBuff.containsKey(key))) {
                                LbnEmp lbnEmp = new LbnEmp();
                                BeanUtils.copyProperties(rEmployee, lbnEmp);
                                JSONObject result = edit(lbnEmp);
                                if (result.getIntValue("status") == 0) {
                                    LDataBufferUtil.adaptEmpIdBuff.put(key, lbnEmp.getemp_id());
                                    count++;
                                }
                            }
                        }
                    } catch (Exception e) {
                        log.error("LoEmployeeServiceImpl synData exception:", e);
                    }
                }
            }
        }
    }
}
