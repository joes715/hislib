package com.hospital.adapt.model.local;

import com.hospital.adapt.model.common.CommonBean;
import com.hospital.adapt.utils.Str2;

public class LbnEmp extends CommonBean {
    private String emp_id = null;
    private String emp_name = null;
    private String emp_sex = null;
    private String emp_job = null;
    private String emp_type = null;

    public String getemp_id() {
        return emp_id;
    }

    public void setemp_id(String emp_id) {
        this.emp_id = Str2.chkNull(emp_id);
        this.id = Str2.chkNull(emp_id);
    }

    public String getemp_name() {
        return emp_name;
    }

    public void setemp_name(String emp_name) {
        this.emp_name = Str2.chkNull(emp_name);
    }

    public String getemp_sex() {
        return emp_sex;
    }

    public void setemp_sex(String emp_sex) {
        this.emp_sex = Str2.chkNull(emp_sex);
    }

    public String getemp_job() {
        return emp_job;
    }

    public void setemp_job(String emp_job) {
        this.emp_job = Str2.chkNull(emp_job);
    }

    public String getemp_type() {
        return emp_type;
    }

    public void setemp_type(String emp_type) {
        this.emp_type = Str2.chkNull(emp_type);
    }

}
