package org.mmarc.karuna;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class restapi {

    private static Retrofit retrofit;

    private restapi(){

    }

    public static Retrofit getService(){
        if(retrofit == null)
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.43.163/api/donor/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit;
    }

}
