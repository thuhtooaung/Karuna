package org.mmarc.karuna.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetAllDonor {
    @SerializedName("d_name")
    @Expose
    String name;
    @SerializedName("b_name")
    @Expose
    String blood;
    @SerializedName("do_date")
    @Expose
    String date;
    @SerializedName("do_amount")
    @Expose
    String amount;
    @SerializedName("d_gender")
    @Expose
    String gender;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

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

}
