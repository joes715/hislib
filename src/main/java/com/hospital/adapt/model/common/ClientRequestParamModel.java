package com.hospital.adapt.model.common;

public class ClientRequestParamModel {
    private String patNo = null;
    private String startDate = null;
    private String endDate = null;

    public String getPatNo() {
        return patNo;
    }

    public void setPatNo(String patNo) {
        this.patNo = patNo;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "PatNo:" + patNo + " StartDate:" + startDate + " EndDate:" + endDate;
    }
}
