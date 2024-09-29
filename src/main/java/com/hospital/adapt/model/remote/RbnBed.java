package com.hospital.adapt.model.remote;

import com.hospital.adapt.utils.Str2;

public class RbnBed {
    private String bed_name = null;
    private String ward_code = null;
    private String room_name = null;

    public String getbed_name() {
        return bed_name;
    }

    public void setbed_name(String bed_name) {
        this.bed_name = Str2.chkNull(bed_name);
    }

    public String getward_code() {
        return ward_code;
    }

    public void setward_code(String ward_code) {
        this.ward_code = Str2.chkNull(ward_code);
    }

    public String getroom_name() {
        return room_name;
    }

    public void setroom_name(String room_name) {
        this.room_name = Str2.chkNull(room_name);
    }
}
