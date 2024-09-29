
package com.hospital.adapt.model.wrapper;

import com.hospital.adapt.model.remote.RbnPayType;
import com.hospital.adapt.utils.Str2;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("Body")
public class PayTypesWrapper {
    @XStreamAlias("ResultCode")
    private String resultCode = null;

    @XStreamAlias("ResultContent")
    private String resultContent = null;

    @XStreamAlias("dataList")
    private List<RbnPayType> wsTypes = null;


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

    public List<RbnPayType> getWsTypes() {
        return wsTypes;
    }

    public void setWsTypes(List<RbnPayType> wsTypes) {
        this.wsTypes = wsTypes;
    }

    public List<String> getTypeCodes() {
        List<String> result = null;

        if (null != wsTypes && wsTypes.size() > 0) {
            result = new ArrayList<String>();
            for (RbnPayType type : wsTypes) {
                if (null != type) {
                    if (Str2.notNull(type.getroom_code())) {
                        result.add(Str2.chkNull(type.getroom_code()));
                    }
                }
            }
        }

        return result;
    }

}
