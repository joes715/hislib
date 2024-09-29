package com.hospital.adapt.model.local;


import com.hospital.adapt.model.common.CommonBean;
import com.hospital.adapt.utils.Str2;

public class LbnBoard extends CommonBean {
    private String patient_board_id = null;
    private String ward_code = null;
    private String patient_field1 = null;
    private String patient_field2 = null;
    private String patient_field3 = null;
    private String patient_field4 = null;
    private String patient_field5 = null;
    private String patient_field6 = null;
    private String patient_field7 = null;
    private String patient_field8 = null;
    private String patient_field9 = null;

    public String getPatient_board_id() {
        return patient_board_id;
    }

    public void setPatient_board_id(String patient_board_id) {
        this.patient_board_id = patient_board_id;
        this.id = patient_board_id;
    }

    public String getward_code() {
        return ward_code;
    }

    public void setward_code(String ward_code) {
        this.ward_code = Str2.chkNull(ward_code);
    }

    public String getPatient_field1() {
        return patient_field1;
    }

    public void setPatient_field1(String patient_field1) {
        this.patient_field1 = Str2.chkNull(patient_field1);
    }

    public String getPatient_field2() {
        return patient_field2;
    }

    public void setPatient_field2(String patient_field2) {
        this.patient_field2 = Str2.chkNull(patient_field2);
    }

    public String getPatient_field3() {
        return patient_field3;
    }

    public void setPatient_field3(String patient_field3) {
        this.patient_field3 = Str2.chkNull(patient_field3);
    }

    public String getPatient_field4() {
        return patient_field4;
    }

    public void setPatient_field4(String patient_field4) {
        this.patient_field4 = Str2.chkNull(patient_field4);
    }

    public String getPatient_field5() {
        return patient_field5;
    }

    public void setPatient_field5(String patient_field5) {
        this.patient_field5 = Str2.chkNull(patient_field5);
    }

    public String getPatient_field6() {
        return patient_field6;
    }

    public void setPatient_field6(String patient_field6) {
        this.patient_field6 = Str2.chkNull(patient_field6);
    }

    public String getPatient_field7() {
        return patient_field7;
    }

    public void setPatient_field7(String patient_field7) {
        this.patient_field7 = Str2.chkNull(patient_field7);
    }

    public String getPatient_field8() {
        return patient_field8;
    }

    public void setPatient_field8(String patient_field8) {
        this.patient_field8 = Str2.chkNull(patient_field8);
    }

    public String getPatient_field9() {
        return patient_field9;
    }

    public void setPatient_field9(String patient_field9) {
        this.patient_field9 = Str2.chkNull(patient_field9);
    }

}
