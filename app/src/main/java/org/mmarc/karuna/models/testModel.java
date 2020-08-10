package org.mmarc.karuna.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class testModel {
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("blood")
    @Expose
    String blood;
    @SerializedName("phone")
    @Expose
    String phone;
    @SerializedName("address")
    @Expose
    String address;

    @SerializedName("donation")
    @Expose
    List<testmodle1> donation;

    @SerializedName("last_donation")
    @Expose
    String last_donation;
    @SerializedName("nrc_no")
    @Expose
    String nrc_no;
    @SerializedName("detail")
    @Expose
    String detail;
    @SerializedName("total_amount")
    @Expose
    String total_amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<testmodle1> getDonation() {
        return donation;
    }

    public void setDonation(List<testmodle1> donation) {
        this.donation = donation;
    }

    public String getLast_donation() {
        return last_donation;
    }

    public void setLast_donation(String last_donation) {
        this.last_donation = last_donation;
    }

    public String getNrc_no() {
        return nrc_no;
    }

    public void setNrc_no(String nrc_no) {
        this.nrc_no = nrc_no;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    /*public class donationbody{
        @SerializedName("name")
        @Expose
        String donated_date;
        @SerializedName("name")
        @Expose
        String donated_amount;

        public String getDonated_date() {
            return donated_date;
        }

        public void setDonated_date(String donated_date) {
            this.donated_date = donated_date;
        }

        public String getDonated_amount() {
            return donated_amount;
        }

        public void setDonated_amount(String donated_amount) {
            this.donated_amount = donated_amount;
        }
    }*/
}


