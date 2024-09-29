package com.hospital.adapt.model.local;

import com.hospital.adapt.model.common.CommonBean;
import com.hospital.adapt.utils.Str2;

public class LbnDept extends CommonBean {
    private String dept_id = null;

    private String dept_name = null;
    private String dept_code = null;
    private String his_dept_code = null;
    private String dept_master = null;
    private String nurse_master = null;

    public String getdept_id() {
        return dept_id;
    }

    public void setdept_id(String dept_id) {
        this.dept_id = Str2.chkNull(dept_id);
        this.id = Str2.chkNull(dept_id);
    }

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

    public String gethis_dept_code() {
        return his_dept_code;
    }

    public void sethis_dept_code(String his_dept_code) {
        this.his_dept_code = Str2.chkNull(his_dept_code);
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
