
package com.hospital.adapt.model.wrapper;

import com.hospital.adapt.utils.Str2;
import com.hospital.adapt.model.remote.RbnPatient;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@XStreamAlias("Body")
public class PatsWrapper {
    @XStreamAlias("ResultCode")
    private String resultCode = null;

    @XStreamAlias("ResultContent")
    private String resultContent = null;

    @XStreamAlias("dataList")
    private List<RbnPatient> wsPats = null;

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

    public List<RbnPatient> getWsPats() {
        return wsPats;
    }

    public void setWsPats(List<RbnPatient> wsPats) {
        this.wsPats = wsPats;
    }

    public String getZyhms() {
        String result = null;
        if (null != wsPats && wsPats.size() > 0) {
            List<String> sns = new ArrayList<>();
            for (RbnPatient pjPatient : wsPats) {
                if (null != pjPatient) {
                    String adm_num = pjPatient.getadm_num();
                    if (Str2.notNull(adm_num) && Str2.notNull(adm_num.trim())) {
                        sns.add(adm_num.trim());
                    }
                }
            }

            result = sns.stream().map(String::valueOf).collect(Collectors.joining(","));
        }

        return result;
    }

}
