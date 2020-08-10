package org.mmarc.karuna.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class testmodle1 {
    @SerializedName("donated_date")
    @Expose
    String donated_date;
    @SerializedName("donated_amount")
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
}
