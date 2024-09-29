
package com.hospital.adapt.model.local;


import com.hospital.adapt.model.common.CommonBean;

public class LbnNursLvl extends CommonBean {
    private String level_id = null;
    private String level_name = null;
    private String level_code = null;
    private String level_color = null;
    private String level_led_code = null;
    private String level_led_color = null;
    private Integer sort_code = 0;
    private Integer status = 1;
    private String note_txt = null;

    private Integer nursing_count = 0;

    public String getlevel_id() {
        return level_id;
    }

    public void setlevel_id(String level_id) {
        this.level_id = level_id;
        this.id = level_id;
    }

    public Integer getNursing_count() {
        return nursing_count;
    }

    public void setNursing_count(Integer nursing_count) {
        this.nursing_count = nursing_count;
    }

    public String getlevel_name() {
        return level_name;
    }

    public void setlevel_name(String level_name) {
        this.level_name = level_name;
    }

    public String getlevel_code() {
        return level_code;
    }

    public void setlevel_code(String level_code) {
        this.level_code = level_code;
    }

    public String getlevel_color() {
        return level_color;
    }

    public void setlevel_color(String level_color) {
        this.level_color = level_color;
    }

    public String getlevel_led_code() {
        return level_led_code;
    }

    public void setlevel_led_code(String level_led_code) {
        this.level_led_code = level_led_code;
    }

    public String getlevel_led_color() {
        return level_led_color;
    }

    public void setlevel_led_color(String level_led_color) {
        this.level_led_color = level_led_color;
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
        this.note_txt = note_txt;
    }
}
