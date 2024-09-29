
package com.hospital.adapt.model.wrapper;

import com.hospital.adapt.model.remote.RbnWard;
import com.hospital.adapt.utils.Str2;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("Response")
public class WardsWrapper {
    @XStreamAlias("ResultCode")
    private Boolean success = null;

    @XStreamAlias("ResultContent")
    private String message = null;

    @XStreamAlias("Code")
    private Integer code = null;

    @XStreamAlias("datalist")
    private List<RbnWard> wsWards = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<RbnWard> getWsWards() {
        return wsWards;
    }

    public void setWsWards(List<RbnWard> result) {
        this.wsWards = result;
    }

    public List<String> getWardCodes() {
        List<String> result2 = null;

        if (null != wsWards && wsWards.size() > 0) {
            result2 = new ArrayList<String>();
            for (RbnWard ward : wsWards) {
                if (null != ward) {
                    if (Str2.notNull(ward.getward_code())) {
                        result2.add(Str2.chkNull(ward.getward_code()));
                    }
                }
            }
        }

        return result2;
    }

}
