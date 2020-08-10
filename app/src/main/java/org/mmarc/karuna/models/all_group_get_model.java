package org.mmarc.karuna.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class all_group_get_model {
    @SerializedName("id")
    @Expose
    String g_id;
    @SerializedName("g_name")
    @Expose
    String g_name;
    @SerializedName("g_description")
    @Expose
    String g_description;
    @SerializedName("g_location")
    @Expose
    String g_location;
    @SerializedName("g_phone")
    @Expose
    String g_phone;
    @SerializedName("status")
    @Expose
    String status;
    @SerializedName("created_at")
    @Expose
    String a_created_at;
    @SerializedName("updated_at")
    @Expose
    String a_updated_at;

    public String getG_id() {
        return g_id;
    }

    public void setG_id(String g_id) {
        this.g_id = g_id;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public String getG_description() {
        return g_description;
    }

    public void setG_description(String g_description) {
        this.g_description = g_description;
    }

    public String getG_location() {
        return g_location;
    }

    public void setG_location(String g_location) {
        this.g_location = g_location;
    }

    public String getG_phone() {
        return g_phone;
    }

    public void setG_phone(String g_phone) {
        this.g_phone = g_phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getA_created_at() {
        return a_created_at;
    }

    public void setA_created_at(String a_created_at) {
        this.a_created_at = a_created_at;
    }

    public String getA_updated_at() {
        return a_updated_at;
    }

    public void setA_updated_at(String a_updated_at) {
        this.a_updated_at = a_updated_at;
    }
}
