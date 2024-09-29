package com.hospital.adapt.model.remote;

import com.hospital.adapt.utils.Str2;

public class RbnDept {
    private String dept_name = null;
    private String dept_code = null;
    private String dept_master = null;
    private String nurse_master = null;

    public String getdept_name() {
        return dept_name;
    }

    public void setdept_name(String dept_name) {
        this.dept_name = Str2.chkNull(dept_name);
    }

    public String getdept_code() {
        return dept_code;
    }

    public void setdept_code(String dept_code) {
        this.dept_code = Str2.chkNull(dept_code);
    }

    public String getdept_master() {
        return dept_master;
    }

    public void setdept_master(String dept_master) {
        this.dept_master = Str2.chkNull(dept_master);
    }

    public String getnurse_master() {
        return nurse_master;
    }

    public void setnurse_master(String nurse_master) {
        this.nurse_master = Str2.chkNull(nurse_master);
    }

}
