package com.hospital.adapt.model.local;

import com.hospital.adapt.model.common.CommonBean;
import com.hospital.adapt.utils.Str2;

public class LbnHisWard extends CommonBean {
    private String ward_id = null;
    private String ward_name = null;
    private String ward_code = null;
    private String local_ward_id = null;
    private Integer sort_code = null;

    public String getward_id() {
        return ward_id;
    }

    public void setward_id(String ward_id) {
        this.ward_id = Str2.chkNull(ward_id);
        this.id = Str2.chkNull(ward_id);
    }

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

    public String getlocal_ward_id() {
        return local_ward_id;
    }

    public void setlocal_ward_id(String local_ward_id) {
        this.local_ward_id = Str2.chkNull(local_ward_id);
    }

    public Integer getsort_code() {
        return sort_code;
    }

    public void setsort_code(Integer sort_code) {
        this.sort_code = sort_code;
    }
}
