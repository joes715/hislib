package com.hospital.adapt.model.local;

import com.hospital.adapt.model.common.CommonBean;
import com.hospital.adapt.utils.Str2;

public class LbnRoom extends CommonBean {
    private String room_id = null;
    private String room_name = null;
    private String room_code = null;
    private String ward_id = null;
    private Integer sort_code = null;

    public String getroom_name() {
        return room_name;
    }

    public void setroom_name(String room_name) {
        this.room_name = Str2.chkNull(room_name);
    }

    public String getroom_id() {
        return room_id;
    }

    public void setroom_id(String room_id) {
        this.room_id = Str2.chkNull(room_id);
        this.id = Str2.chkNull(room_id);
    }

    public String getroom_code() {
        return room_code;
    }

    public void setroom_code(String room_code) {
        this.room_code = Str2.chkNull(room_code);
    }

    public String getward_id() {
        return ward_id;
    }

    public void setward_id(String ward_id) {
        this.ward_id = Str2.chkNull(ward_id);
    }

    public Integer getsort_code() {
        return sort_code;
    }

    public void setsort_code(Integer sort_code) {
        this.sort_code = sort_code;
    }
}
