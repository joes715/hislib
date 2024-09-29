
package com.hospital.adapt.model.local;

import com.hospital.adapt.model.common.CommonBean;
import com.hospital.adapt.utils.Str2;

public class LbnPayType extends CommonBean {
    private String room_id = null;
    private String pay_name = null;
    private String room_code = null;
    private Integer sort_code = null;

    public String getroom_id() {
        return room_id;
    }

    public void setroom_id(String room_id) {
        this.room_id = Str2.chkNull(room_id);
        this.id = Str2.chkNull(room_id);
    }

    public String getpay_name() {
        return pay_name;
    }

    public void setpay_name(String pay_name) {
        this.pay_name = Str2.chkNull(pay_name);
    }

    public String getroom_code() {
        return room_code;
    }

    public void setroom_code(String room_code) {
        this.room_code = Str2.chkNull(room_code);
    }

    public Integer getsort_code() {
        return sort_code;
    }

    public void setsort_code(Integer sort_code) {
        this.sort_code = sort_code;
    }
}
