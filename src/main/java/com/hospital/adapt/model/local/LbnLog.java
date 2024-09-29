package com.hospital.adapt.model.local;

import com.hospital.adapt.model.common.CommonBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;

public class LbnLog extends CommonBean {
    private String log_id = null;
    private String log_txt = null;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date log_time = null;
    private String log_creator = null;
    private String log_type = null;
    private String log_detail = null;

    public LbnLog(String log_txt, String log_creator, String log_type, String log_detail) {
        this.log_time = Calendar.getInstance().getTime();
        this.log_txt = log_txt;
        this.log_creator = log_creator;
        this.log_type = log_type;
        this.log_detail = log_detail;
    }

    public String getlog_id() {
        return log_id;
    }

    public void setlog_id(String log_id) {
        this.log_id = log_id;
        this.id = log_id;
    }

    public String getlog_txt() {
        return log_txt;
    }

    public void setlog_txt(String log_txt) {
        this.log_txt = log_txt;
    }

    public Date getlog_time() {
        return log_time;
    }

    public void setlog_time(Date log_time) {
        this.log_time = log_time;
    }

    public String getlog_creator() {
        return log_creator;
    }

    public void setlog_creator(String log_creator) {
        this.log_creator = log_creator;
    }

    public String getlog_type() {
        return log_type;
    }

    public void setlog_type(String log_type) {
        this.log_type = log_type;
    }

    public String getlog_detail() {
        return log_detail;
    }

    public void setlog_detail(String log_detail) {
        this.log_detail = log_detail;
    }
}
