package com.hospital.adapt.model.third;

import com.hospital.adapt.utils.Str2;
import com.hospital.adapt.model.common.CommonBean;

public class TbnUser extends CommonBean {
    private String user_id = null;
    private String user_name = null;
    private String user_pswd = null;
    private String user_alias = null;
    private Integer user_role = null;
    private String ward_id = null;
    private String dept_id = null;
    private Integer user_sort_id = null;
    private Integer user_enable = null;
    private String user_note = null;

    private String ward_sn = null;
    private String ward_name = null;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
        this.id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = Str2.chkNull(user_name);
    }

    public String getUser_pswd() {
        return user_pswd;
    }

    public void setUser_pswd(String user_pswd) {
        this.user_pswd = Str2.chkNull(user_pswd);
    }

    public String getUser_alias() {
        return user_alias;
    }

    public void setUser_alias(String user_alias) {
        this.user_alias = Str2.chkNull(user_alias);
    }

    public Integer getUser_role() {
        return user_role;
    }

    public void setUser_role(Integer user_role) {
        this.user_role = user_role;
    }

    public String getWard_id() {
        return ward_id;
    }

    public void setWard_id(String ward_id) {
        this.ward_id = ward_id;
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public Integer getUser_sort_id() {
        return user_sort_id;
    }

    public void setUser_sort_id(Integer user_sort_id) {
        this.user_sort_id = user_sort_id;
    }

    public Integer getUser_enable() {
        return user_enable;
    }

    public void setUser_enable(Integer user_enable) {
        this.user_enable = user_enable;
    }

    public String getUser_note() {
        return user_note;
    }

    public void setUser_note(String user_note) {
        this.user_note = Str2.chkNull(user_note);
    }

    public String getWard_sn() {
        return ward_sn;
    }

    public void setWard_sn(String ward_sn) {
        this.ward_sn = ward_sn;
    }

    public String getWard_name() {
        return ward_name;
    }

    public void setWard_name(String ward_name) {
        this.ward_name = ward_name;
    }

}
