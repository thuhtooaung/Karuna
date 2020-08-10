package org.mmarc.karuna;

import org.mmarc.karuna.models.GetAllDonor;
import org.mmarc.karuna.models.GetAllGroup;
import org.mmarc.karuna.models.GetDonorDetail;
import org.mmarc.karuna.models.GetRecords;
import org.mmarc.karuna.models.addDonor_model;
import org.mmarc.karuna.models.all_blood_type_model;
import org.mmarc.karuna.models.all_group_get_model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface jsonPlaceHolderApi{

    /*@GET("all_donor")
    Call<List<GetAllDonor>> getRes();*/
    @GET("personal_overview")
    Call<List<GetAllDonor>> getRes();

    /*@GET("donor_group")
    Call<List<GetAllGroup>> getGroup();*/
    @GET("yzzwh")
    Call<List<GetAllGroup>> getGroup();

    @GET("blood_type/show/{id}")
    Call<List<GetDonorDetail>> getDetail(@Query("id") int gid);

    /*@GET("1468dl")
    Call<List<testModel>> getTest();*/

    @GET("record")
    Call<List<GetRecords>> getRecord();

    //All blood types and all group for add donor
    @GET("all_blood_types")
    Call<List<all_blood_type_model>> getAllBloodType();
    @GET("all_donor_groups")
    Call<List<all_group_get_model>> getGroupType();

    @FormUrlEncoded
    @POST("add")
    Call<addDonor_model> addUser(@Field("d_name") String name,
                                 @Field("d_nrc") String nrc,
                                 @Field("d_fathername") String fatherName,
                                 @Field("d_birthdate") String birthDate,
                                 @Field("d_address") String address,
                                 @Field("d_phone") String phone,
                                 @Field("g_id") String gid,
                                 @Field("b_id") String bid);
}
