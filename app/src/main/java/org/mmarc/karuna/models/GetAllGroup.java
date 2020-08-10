package org.mmarc.karuna.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetAllGroup {
    @SerializedName("b_name")
    @Expose
    String gname;
    @SerializedName("g_name")
    @Expose
    String blood;
    @SerializedName("g_location")
    @Expose
    String location;

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
