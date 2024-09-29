
package com.hospital.adapt.model.wrapper;

import com.hospital.adapt.utils.Str2;
import com.hospital.adapt.model.remote.RbnBed;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("Body")
public class BedsWrapper {
    @XStreamAlias("ResultCode")
    private String resultCode = null;

    @XStreamAlias("ResultContent")
    private String resultContent = null;

    @XStreamAlias("datalist")
    private List<RbnBed> wsBeds = null;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultContent() {
        return resultContent;
    }

    public void setResultContent(String resultContent) {
        this.resultContent = resultContent;
    }

    public List<RbnBed> getWsBeds() {
        return wsBeds;
    }

    public void setWsBeds(List<RbnBed> wsBeds) {
        this.wsBeds = wsBeds;
    }

    public List<String> getBedCodes() {
        List<String> result = null;

        if (null != wsBeds && wsBeds.size() > 0) {
            result = new ArrayList<String>();
            for (RbnBed bed : wsBeds) {
                if (null != bed) {
                    if (Str2.notNull(bed.getbed_name())) {
                        result.add(Str2.chkNull(bed.getbed_name()));
                    }
                }
            }
        }

        return result;
    }
}
