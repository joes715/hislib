package com.hospital.adapt.model.local;

import com.hospital.adapt.model.common.CommonBean;
import com.hospital.adapt.utils.Str2;

public class LbnBed extends CommonBean {
    private String bed_id = null;
    private String bed_name = null;
    private String bed_code = null;
    private String ward_id = null;
    private String room_id = null;
    private Integer sort_code = null;

    public String getbed_id() {
        return bed_id;
    }

    public void setbed_id(String bed_id) {
        this.bed_id = Str2.chkNull(bed_id);
        this.id = Str2.chkNull(bed_id);
    }

    public String getbed_name() {
        return bed_name;
    }

    public void setbed_name(String bed_name) {
        this.bed_name = Str2.chkNull(bed_name);
    }

    public String getbed_code() {
        return bed_code;
    }

    public void setbed_code(String bed_code) {
        this.bed_code = Str2.chkNull(bed_code);
    }

    public String getward_id() {
        return ward_id;
    }

    public void setward_id(String ward_id) {
        this.ward_id = Str2.chkNull(ward_id);
    }

    public String getroom_id() {
        return room_id;
    }

    public void setroom_id(String room_id) {
        this.room_id = Str2.chkNull(room_id);
    }

    public Integer getsort_code() {
        return sort_code;
    }

    public void setsort_code(Integer sort_code) {
        this.sort_code = sort_code;
    }
}
