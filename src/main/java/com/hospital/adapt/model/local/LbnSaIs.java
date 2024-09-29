package com.hospital.adapt.model.local;

import com.hospital.adapt.model.common.CommonBean;
import com.hospital.adapt.utils.Str2;

public class LbnSaIs extends CommonBean {
    private String safe_id = null;
    private String safe_name = null;
    private String safe_code = null;
    private String safe_color = null;
    private Integer safe_type = null;
    private Integer sort_code = null;
    private Integer status = null;
    private String safe_icon = null;
    private String note_txt = null;

    private String icon_url = null;

    public String getsafe_id() {
        return safe_id;
    }

    public void setsafe_id(String safe_id) {
        this.safe_id = Str2.chkNull(safe_id);
        this.id = Str2.chkNull(safe_id);
    }

    public String getsafe_name() {
        return safe_name;
    }

    public void setsafe_name(String safe_name) {
        this.safe_name = Str2.chkNull(safe_name);
    }

    public String getsafe_code() {
        return safe_code;
    }

    public void setsafe_code(String safe_code) {
        this.safe_code = Str2.chkNull(safe_code);
    }

    public String getsafe_color() {
        return safe_color;
    }

    public void setsafe_color(String safe_color) {
        this.safe_color = Str2.chkNull(safe_color);
    }

    public Integer getsafe_type() {
        return safe_type;
    }

    public void setsafe_type(Integer safe_type) {
        this.safe_type = safe_type;
    }

    public Integer getsort_code() {
        return sort_code;
    }

    public void setsort_code(Integer sort_code) {
        this.sort_code = sort_code;
    }

    public Integer getstatus() {
        return status;
    }

    public void setstatus(Integer status) {
        this.status = status;
    }

    public String getnote_txt() {
        return note_txt;
    }

    public void setnote_txt(String note_txt) {
        this.note_txt = Str2.chkNull(note_txt);
    }

    public String getsafe_icon() {
        return safe_icon;
    }

    public void setsafe_icon(String safe_icon) {
        this.safe_icon = Str2.chkNull(safe_icon);
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = Str2.chkNull(icon_url);
    }
}
