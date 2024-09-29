
package com.hospital.adapt.model.local;


import com.hospital.adapt.utils.Str2;

public class LocPatientStatisticMap {
    private String bed_name = null;
    private Integer ill_info = null;
    private Integer level_code = null;

    public String getbed_name() {
        return bed_name;
    }

    public void setbed_name(String bed_name) {
        this.bed_name = Str2.chkNull(bed_name);
    }

    public Integer getill_info() {
        return ill_info;
    }

    public void setill_info(Integer ill_info) {
        this.ill_info = ill_info;
    }

    public Integer getlevel_code() {
        return level_code;
    }

    public void setlevel_code(Integer level_code) {
        this.level_code = level_code;
    }
}
