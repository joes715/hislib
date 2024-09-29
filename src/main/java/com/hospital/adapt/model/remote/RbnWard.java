package com.hospital.adapt.model.remote;

import com.hospital.adapt.utils.Str2;

public class RbnWard {
    private String ward_name = null;
    private String ward_code = null;

    public String getward_name() {
        return ward_name;
    }

    public void setward_name(String ward_name) {
        this.ward_name = Str2.chkNull(ward_name);
    }

    public String getward_code() {
        return ward_code;
    }

    public void setward_code(String ward_code) {
        this.ward_code = Str2.chkNull(ward_code);
    }

}
