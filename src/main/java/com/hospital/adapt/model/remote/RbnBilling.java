
package com.hospital.adapt.model.remote;

import com.hospital.adapt.utils.Str2;

public class RbnBilling {
    private String patient_name = null;
    private String patient_no = null;
    private String item_name = null;
    private String item_qty = null;
    private String item_uom = null;
    private String item_price = null;
    private String item_total_amt = null;
    private String bill_date = null;
    private String insu_ratio = null;

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = Str2.chkNull(patient_name);
    }

    public String getPatient_no() {
        return patient_no;
    }

    public void setPatient_no(String patient_no) {
        this.patient_no = Str2.chkNull(patient_no);
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = Str2.chkNull(item_name);
    }

    public String getItem_qty() {
        return item_qty;
    }

    public void setItem_qty(String item_qty) {
        this.item_qty = Str2.chkNull(item_qty);
    }

    public String getItem_uom() {
        return item_uom;
    }

    public void setItem_uom(String item_uom) {
        this.item_uom = Str2.chkNull(item_uom);
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = Str2.chkNull(item_price);
    }

    public String getItem_total_amt() {
        return item_total_amt;
    }

    public void setItem_total_amt(String item_total_amt) {
        this.item_total_amt = Str2.chkNull(item_total_amt);
    }

    public String getBill_date() {
        return bill_date;
    }

    public void setBill_date(String bill_date) {
        this.bill_date = Str2.chkNull(bill_date);
    }

    public String getInsu_ratio() {
        return insu_ratio;
    }

    public void setInsu_ratio(String insu_ratio) {
        this.insu_ratio = Str2.chkNull(insu_ratio);
    }

}
