
package com.hospital.adapt.model.wrapper;

import com.hospital.adapt.model.remote.RbnRoom;
import com.hospital.adapt.utils.Str2;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("Body")
public class RoomsWrapper {
    @XStreamAlias("ResultCode")
    private String resultCode = null;

    @XStreamAlias("ResultContent")
    private String resultContent = null;

    @XStreamAlias("dataList")
    private List<RbnRoom> wsRooms = null;

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

    public List<RbnRoom> getWsRooms() {
        return wsRooms;
    }

    public void setWsRooms(List<RbnRoom> wsRooms) {
        this.wsRooms = wsRooms;
    }

    public List<String> getRoomCodes() {
        List<String> result = null;

        if (null != wsRooms && wsRooms.size() > 0) {
            result = new ArrayList<String>();
            for (RbnRoom room : wsRooms) {
                if (null != room) {
                    if (Str2.notNull(room.getroom_name())) {
                        result.add(Str2.chkNull(room.getroom_name()));
                    }
                }
            }
        }

        return result;
    }
}
