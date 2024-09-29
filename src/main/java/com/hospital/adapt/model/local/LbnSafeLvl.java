package com.hospital.adapt.model.local;

import com.hospital.adapt.model.common.CommonBean;
import com.hospital.adapt.utils.Str2;


public class LbnSafeLvl extends CommonBean {
    private String safe_level_id = null;
    private String safe_level_name = null;
    private String safe_level_code = null;
    private String safe_level_color = null;
    private Integer safe_low_score = null;
    private Integer safe_high_score = null;
    private Integer sort_code = null;
    private Integer status = null;
    private String note_txt = null;

    public String getsafe_level_id() {
        return safe_level_id;
    }

    public void setsafe_level_id(String safe_level_id) {
        this.safe_level_id = Str2.chkNull(safe_level_id);
        this.id = Str2.chkNull(safe_level_id);
    }

    public String getsafe_level_name() {
        return safe_level_name;
    }

    public void setsafe_level_name(String safe_level_name) {
        this.safe_level_name = Str2.chkNull(safe_level_name);
    }

    public String getsafe_level_code() {
        return safe_level_code;
    }

    public void setsafe_level_code(String safe_level_code) {
        this.safe_level_code = Str2.chkNull(safe_level_code);
    }

    public String getsafe_level_color() {
        return safe_level_color;
    }

    public void setsafe_level_color(String safe_level_color) {
        this.safe_level_color = Str2.chkNull(safe_level_color);
    }

    public Integer getsafe_low_score() {
        return safe_low_score;
    }

    public void setsafe_low_score(Integer safe_low_score) {
        this.safe_low_score = safe_low_score;
    }

    public Integer getsafe_high_score() {
        return safe_high_score;
    }

    public void setsafe_high_score(Integer safe_high_score) {
        this.safe_high_score = safe_high_score;
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
}
