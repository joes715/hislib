
package com.hospital.adapt.model.wrapper;

import com.hospital.adapt.model.remote.RbnEmp;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

@XStreamAlias("Body")
public class EmpsWrapper {
    @XStreamAlias("ResultCode")
    private String resultCode = null;

    @XStreamAlias("ResultContent")
    private String resultContent = null;

    @XStreamAlias("dataList")
    private List<RbnEmp> wsEmps = null;


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

    public List<RbnEmp> getWsEmps() {
        return wsEmps;
    }

    public void setWsEmps(List<RbnEmp> wsEmps) {
        this.wsEmps = wsEmps;
    }

}
