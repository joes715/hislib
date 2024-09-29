package com.hospital.adapt.model.remote;


import com.hospital.adapt.utils.Str2;

public class RbnBoard {
    private String ward_code = null;
    private String patient_beds = null;
    private String patient_date = null;
    private Integer patient_type = null;
    private Integer patient_status = null;

    public String getward_code() {
        return ward_code;
    }

    public void setward_code(String ward_code) {
        this.ward_code = Str2.chkNull(ward_code);
    }

    public String getPatient_beds() {
        return patient_beds;
    }

    public void setPatient_beds(String patient_beds) {
        this.patient_beds = Str2.chkNull(patient_beds);
    }

    public String getPatient_date() {
        return patient_date;
    }

    public void setPatient_date(String patient_date) {
        this.patient_date = patient_date;
    }

    public Integer getPatient_type() {
        return patient_type;
    }

    public void setPatient_type(Integer patient_type) {
        this.patient_type = patient_type;
    }

    public Integer getPatient_status() {
        return patient_status;
    }

    public void setPatient_status(Integer patient_status) {
        this.patient_status = patient_status;
    }


}
