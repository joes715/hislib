
package com.hospital.adapt.model.wrapper;

import com.hospital.adapt.utils.Str2;
import com.hospital.adapt.model.remote.RbnDept;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("Response")
public class DeptsWrapper {
    @XStreamAlias("ResultCode")
    private String resultCode = null;

    @XStreamAlias("ResultContent")
    private String resultContent = null;

    @XStreamAlias("datalist")
    private List<RbnDept> wsDepts = null;

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

    public List<RbnDept> getWsDepts() {
        return wsDepts;
    }

    public void setWsDepts(List<RbnDept> wsDepts) {
        this.wsDepts = wsDepts;
    }

    public List<String> getDeptCodes() {
        List<String> result = null;

        if (null != wsDepts && wsDepts.size() > 0) {
            result = new ArrayList<String>();
            for (RbnDept dept : wsDepts) {
                if (null != dept) {
                    String dept_code = dept.getdept_code();
                    if (Str2.notNull(Str2.chkNull(dept_code))) {
                        result.add(dept_code);
                    }
                }
            }
        }

        return result;
    }
}
