package org.mmarc.karuna.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.mmarc.karuna.models.GetDonorDetail;
import org.mmarc.karuna.R;
import org.mmarc.karuna.jsonPlaceHolderApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class detail extends AppCompatActivity {
    private String detail_data;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        //final TextView tv=findViewById(R.id.detail);
        /*Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.43.43/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();*/
        tv1=findViewById(R.id.pd_name);
        tv2=findViewById(R.id.pd_blood);
        tv3=findViewById(R.id.pd_ph);
        tv4=findViewById(R.id.pd_addr);
        //tv5=findViewById(R.id.detail);
        tv6=findViewById(R.id.pd_lastd);
        tv7=findViewById(R.id.pd_nrc);
        tv8=findViewById(R.id.pd_detail);
        tv9=findViewById(R.id.pd_amt);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.43.43/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi jsonapi=retrofit.create(jsonPlaceHolderApi.class);
        Call<List<GetDonorDetail>> call=jsonapi.getDetail(1);
        call.enqueue(new Callback<List<GetDonorDetail>>() {
            @Override
            public void onResponse(Call<List<GetDonorDetail>> call, Response<List<GetDonorDetail>> response) {
                List<GetDonorDetail> posts=response.body();
                //String s = "";
                for (GetDonorDetail model:
                     posts) {
                    tv1.setText("- "+model.getD_name());
                    tv2.setText("- "+model.getB_name());
                    tv3.setText("- "+model.getD_phone());
                    tv4.setText("- "+model.getD_address());
                    /*s="အမည် : "+model.getName()+"\n\n";
                    s+="သွေးအမျိုးအစား : "+model.getBlood()+"\n\n";
                    s+="ဖုန်း : "+model.getPhone()+"\n\n";
                    s+="နေရပ်လိပ်စာ : "+model.getAddress()+"\n\n";*/
                    /*List<testmodle1> ls=model.getDonation();
                    for (testmodle1 testmod : ls){
                        s+="\n"+"ရက်စွဲ - "+testmod.getDonated_date()+"\n";
                        s+="သွေးပုလင်း - "+testmod.getDonated_amount()+"\n";
                    }*/
                    //tv5.setText(s);
                    tv6.setText("- "+model.getDo_date());
                    tv7.setText("- "+model.getD_nrc());
                    tv8.setText("- "+model.getDo_amount());
                    tv9.setText("- "+model.getD_gender());
                    /*s+="နောက်ဆုံးသွေးလှူခဲ့သောရက် : "+model.getLast_donation()+"\n";
                    s+="မှတ်ပုံတင်နံပါတ် : "+model.getNrc_no()+"\n";
                    s+="အသေးစိတ် : "+model.getDetail()+"\n";
                    s+="စုစုပေါင်းသွေး : "+model.getTotal_amount();*/
                }
                //tv.setText(s);
                Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<GetDonorDetail>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"fail:"+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            detail.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}