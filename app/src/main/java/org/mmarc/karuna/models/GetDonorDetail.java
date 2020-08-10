package org.mmarc.karuna.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetDonorDetail {
    @SerializedName("d_name")
    @Expose
    String d_name;
    @SerializedName("b_name")
    @Expose
    String b_name;
    @SerializedName("do_date")
    @Expose
    String do_date;
    @SerializedName("do_amount")
    @Expose
    String do_amount;
    @SerializedName("d_gender")
    @Expose
    String d_gender;
    @SerializedName("d_address")
    @Expose
    String d_address;
    @SerializedName("d_nrc")
    @Expose
    String d_nrc;
    @SerializedName("d_phone")
    @Expose
    String d_phone;

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public String getDo_date() {
        return do_date;
    }

    public void setDo_date(String do_date) {
        this.do_date = do_date;
    }

    public String getDo_amount() {
        return do_amount;
    }

    public void setDo_amount(String do_amount) {
        this.do_amount = do_amount;
    }

    public String getD_gender() {
        return d_gender;
    }

    public void setD_gender(String d_gender) {
        this.d_gender = d_gender;
    }

    public String getD_address() {
        return d_address;
    }

    public void setD_address(String d_address) {
        this.d_address = d_address;
    }

    public String getD_nrc() {
        return d_nrc;
    }

    public void setD_nrc(String d_nrc) {
        this.d_nrc = d_nrc;
    }

    public String getD_phone() {
        return d_phone;
    }

    public void setD_phone(String d_phone) {
        this.d_phone = d_phone;
    }
}
