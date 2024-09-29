package com.hospital.adapt.model.local;


import com.hospital.adapt.model.common.CommonBean;
import com.hospital.adapt.utils.Str2;

public class LbnPatientSaIs extends CommonBean {
    private String pat_safe_id = null;
    private String pat_id = null;
    private String safe_id = null;
    private String safe_level_id = null;
    private Integer safe_type = null;

    public Integer getsafe_type() {
        return safe_type;
    }

    public void setsafe_type(Integer safe_type) {
        this.safe_type = safe_type;
    }

    public String getpat_safe_id() {
        return pat_safe_id;
    }

    public void setpat_safe_id(String pat_safe_id) {
        this.pat_safe_id = Str2.chkNull(pat_safe_id);
        this.id = Str2.chkNull(pat_safe_id);
    }

    public String getpat_id() {
        return pat_id;
    }

    public void setpat_id(String pat_id) {
        this.pat_id = Str2.chkNull(pat_id);
    }

    public String getsafe_id() {
        return safe_id;
    }

    public void setsafe_id(String safe_id) {
        this.safe_id = Str2.chkNull(safe_id);
    }

    public String getsafe_level_id() {
        return safe_level_id;
    }

    public void setsafe_level_id(String safe_level_id) {
        this.safe_level_id = Str2.chkNull(safe_level_id);
    }
}
