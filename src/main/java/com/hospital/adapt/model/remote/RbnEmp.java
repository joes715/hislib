package com.hospital.adapt.model.remote;

import com.hospital.adapt.utils.Str2;

public class RbnEmp {
    private String emp_name = null;
    private String emp_sex = null;
    private String emp_job = null;
    private String emp_type = null;

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
