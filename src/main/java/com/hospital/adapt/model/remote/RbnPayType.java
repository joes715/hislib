
package com.hospital.adapt.model.remote;

import com.hospital.adapt.utils.Str2;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("payment_type_info")
public class RbnPayType {

    @XStreamAlias("pay_name")
    private String pay_name = null;

    @XStreamAlias("room_code")
    private String room_code = null;

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
}
