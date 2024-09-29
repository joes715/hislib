package com.hospital.adapt.model.local;

import com.hospital.adapt.utils.Str2;
import com.hospital.adapt.model.common.CommonBean;

public class LbnPatient extends CommonBean {
    private String pat_id = null;

    private String pat_name = null;
    private String pat_sex = null;
    private String pat_age = null;
    private String pat_birth = null;
    private String adm_num = null;
    private String pat_qrcode = null;
    private String in_time = null;
    private String ill_info = null;
    private String level_code = null;
    private String out_time = null;
    private String opr_time = null;
    private String mv_in_time = null;
    private String mv_out_time = null;
    private String pay_name = null;
    private String med_gm = null;
    private String pat_foods = null;
    private String pat_exam = null;
    private String pat_with = null;
    private String pat_safe = null;
    private String pat_isolate = null;
    private String doctor_advice = null;

    private String doctor_id = null;
    private String nurse_id = null;
    private String bed_id = null;
    private String ward_id = null;
    private String dept_id = null;
    private String update_fingerpring = null;

    public String getpat_id() {
        return pat_id;
    }

    public void setpat_id(String pat_id) {
        this.pat_id = Str2.chkNull(pat_id);
        this.id = Str2.chkNull(pat_id);
    }

    public String getpat_name() {
        return pat_name;
    }

    public void setpat_name(String pat_name) {
        this.pat_name = Str2.chkNull(pat_name);
    }

    public String getpat_sex() {
        return pat_sex;
    }

    public void setpat_sex(String pat_sex) {
        this.pat_sex = Str2.chkNull(pat_sex);
    }

    public String getpat_age() {
        return pat_age;
    }

    public void setpat_age(String pat_age) {
        this.pat_age = Str2.chkNull(pat_age);
    }

    public String getadm_num() {
        return adm_num;
    }

    public void setadm_num(String adm_num) {
        this.adm_num = Str2.chkNull(adm_num);
    }

    public String getpat_qrcode() {
        return pat_qrcode;
    }

    public void setpat_qrcode(String pat_qrcode) {
        this.pat_qrcode = Str2.chkNull(pat_qrcode);
    }

    public String getlevel_code() {
        return level_code;
    }

    public void setlevel_code(String level_code) {
        this.level_code = Str2.chkNull(level_code);
    }

    public String getpay_name() {
        return pay_name;
    }

    public void setpay_name(String pay_name) {
        this.pay_name = Str2.chkNull(pay_name);
    }

    public String getmed_gm() {
        return med_gm;
    }

    public void setmed_gm(String med_gm) {
        this.med_gm = Str2.chkNull(med_gm);
    }

    public String getpat_foods() {
        return pat_foods;
    }

    public void setpat_foods(String pat_foods) {
        this.pat_foods = Str2.chkNull(pat_foods);
    }

    public String getpat_exam() {
        return pat_exam;
    }

    public void setpat_exam(String pat_exam) {
        this.pat_exam = Str2.chkNull(pat_exam);
    }

    public String getpat_safe() {
        return pat_safe;
    }

    public void setpat_safe(String pat_safe) {
        this.pat_safe = Str2.chkNull(pat_safe);
    }

    public String getpat_isolate() {
        return pat_isolate;
    }

    public void setpat_isolate(String pat_isolate) {
        this.pat_isolate = Str2.chkNull(pat_isolate);
    }

    public String getdoctor_advice() {
        return doctor_advice;
    }

    public void setdoctor_advice(String doctor_advice) {
        this.doctor_advice = Str2.chkNull(doctor_advice);
    }

    public String getdoctor_id() {
        return doctor_id;
    }

    public void setdoctor_id(String doctor_id) {
        this.doctor_id = Str2.chkNull(doctor_id);
    }

    public String getnurse_id() {
        return nurse_id;
    }

    public void setnurse_id(String nurse_id) {
        this.nurse_id = Str2.chkNull(nurse_id);
    }

    public String getbed_id() {
        return bed_id;
    }

    public void setbed_id(String bed_id) {
        this.bed_id = Str2.chkNull(bed_id);
    }

    public String getdept_id() {
        return dept_id;
    }

    public void setdept_id(String dept_id) {
        this.dept_id = Str2.chkNull(dept_id);
    }

    public String getward_id() {
        return ward_id;
    }

    public void setward_id(String ward_id) {
        this.ward_id = Str2.chkNull(ward_id);
    }

    public String getpat_birth() {
        return pat_birth;
    }

    public void setpat_birth(String pat_birth) {
        this.pat_birth = Str2.chkNull(pat_birth);
    }

    public String getin_time() {
        return in_time;
    }

    public void setin_time(String in_time) {
        this.in_time = Str2.chkNull(in_time);
    }

    public String getill_info() {
        return ill_info;
    }

    public void setill_info(String ill_info) {
        this.ill_info = Str2.chkNull(ill_info);
    }

    public String getout_time() {
        return out_time;
    }

    public void setout_time(String out_time) {
        this.out_time = Str2.chkNull(out_time);
    }

    public String getopr_time() {
        return opr_time;
    }

    public void setopr_time(String opr_time) {
        this.opr_time = Str2.chkNull(opr_time);
    }

    public String getmv_in_time() {
        return mv_in_time;
    }

    public void setmv_in_time(String mv_in_time) {
        this.mv_in_time = Str2.chkNull(mv_in_time);
    }

    public String getmv_out_time() {
        return mv_out_time;
    }

    public void setmv_out_time(String mv_out_time) {
        this.mv_out_time = Str2.chkNull(mv_out_time);
    }

    public String getpat_with() {
        return pat_with;
    }

    public void setpat_with(String pat_with) {
        this.pat_with = Str2.chkNull(pat_with);
    }

    public String getupdate_fingerpring() {
        return update_fingerpring;
    }

    public void setupdate_fingerpring(String update_fingerpring) {
        this.update_fingerpring = Str2.chkNull(update_fingerpring);
    }
}
