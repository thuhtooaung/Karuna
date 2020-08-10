package org.mmarc.karuna.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class addDonor_model {
    @SerializedName("d_name")
    @Expose
    String name;
    @SerializedName("d_nrc")
    @Expose
    String nrc;
    @SerializedName("d_fathername")
    @Expose
    String fatherName;
    @SerializedName("d_birthdate")
    @Expose
    String birthDate;
    @SerializedName("d_address")
    @Expose
    String address;
    @SerializedName("d_phone")
    @Expose
    String phone;
    @SerializedName("g_id")
    @Expose
    String add_gid;
    @SerializedName("b_id")
    @Expose
    String add_bid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdd_gid() {
        return add_gid;
    }

    public void setAdd_gid(String add_gid) {
        this.add_gid = add_gid;
    }

    public String getAdd_bid() {
        return add_bid;
    }

    public void setAdd_bid(String add_bid) {
        this.add_bid = add_bid;
    }
}
