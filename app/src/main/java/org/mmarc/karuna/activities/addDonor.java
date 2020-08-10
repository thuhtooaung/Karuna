package org.mmarc.karuna.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import org.mmarc.karuna.R;
import org.mmarc.karuna.models.addDonor_model;
import org.mmarc.karuna.models.all_blood_type_model;
import org.mmarc.karuna.models.all_group_get_model;
import org.mmarc.karuna.jsonPlaceHolderApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class addDonor extends AppCompatActivity {
    String n,am,p,adr,nr;
    String blood="";
    String group="";
    RadioGroup grdo;
    RadioButton rdo;
    ArrayList<String> b_list;
    ArrayList<String> g_list;
    ArrayList<String> bIndex;
    ArrayList<String> gIndex;
    ArrayAdapter<String> adapter1;
    ArrayAdapter<String> adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_donor);

        final EditText name=findViewById(R.id.add_donor_name);
        //final EditText edi2=findViewById(R.id.pdblood);
        final Spinner spinner1=findViewById(R.id.spinner1);
        final Spinner spinner2=findViewById(R.id.spinner2);
        final EditText amt=findViewById(R.id.add_donor_amt);
        final EditText phone=findViewById(R.id.add_donor_phone);
        final EditText address=findViewById(R.id.add_donor_addr);
        final EditText nrc=findViewById(R.id.add_donor_nrc);
        grdo=findViewById(R.id.d_radio);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btn=findViewById(R.id.pdsave);

        //ArrayList
        b_list=new ArrayList<>();
        g_list=new ArrayList<>();
        bIndex=new ArrayList<>();
        gIndex=new ArrayList<>();
        b_list.add("Blood Types");
        g_list.add("Not in group");
        bIndex.add("invalid");
        gIndex.add("invalid");

        Retrofit retrofit_b=new Retrofit.Builder()
                .baseUrl("http://192.168.43.163/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Retrofit retrofit_g=new Retrofit.Builder()
                .baseUrl("http://192.168.43.163/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.43.163/api/donor/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Spinner Adapter
        //ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,b_list);
        //ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,b_list);

        jsonPlaceHolderApi bapi=retrofit_b.create(jsonPlaceHolderApi.class);
        Call<List<all_blood_type_model>> call=bapi.getAllBloodType();
        call.enqueue(new Callback<List<all_blood_type_model>>() {
            @Override
            public void onResponse(Call<List<all_blood_type_model>> call, Response<List<all_blood_type_model>> response) {
                List<all_blood_type_model> ls=response.body();
                /*for (all_blood_type_model allb : ls) {
                    bid.add(allb.getB_id());
                    list.add(allb.getB_name());
                }*/
                for (all_blood_type_model abtm: ls) {
                    bIndex.add(abtm.getB_id());
                    b_list.add(abtm.getB_name());
                }
                Toast.makeText(getApplicationContext(),"Success", Toast.LENGTH_LONG).show();
                //adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                //spinner1.setAdapter(adapter1);
                adapter1=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,b_list);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(adapter1);
            }

            @Override
            public void onFailure(Call<List<all_blood_type_model>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Fail"+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        jsonPlaceHolderApi gapi=retrofit_g.create(jsonPlaceHolderApi.class);
        Call<List<all_group_get_model>> g_call=gapi.getGroupType();
        g_call.enqueue(new Callback<List<all_group_get_model>>() {
            @Override
            public void onResponse(Call<List<all_group_get_model>> call, Response<List<all_group_get_model>> response) {
                List<all_group_get_model> ls=response.body();
                for (all_group_get_model aggm : ls) {
                    gIndex.add(aggm.getG_id());
                    g_list.add(aggm.getG_name());
                }
                adapter2=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,g_list);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(adapter2);
            }

            @Override
            public void onFailure(Call<List<all_group_get_model>> call, Throwable t) {

            }
        });

        /*list=new ArrayList<>();
        bid=new ArrayList<>();
        listIndex=new ArrayList<>();
        bidIndex=new ArrayList<>();
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        list.add("A");
        list.add("B");
        list.add("C");
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        //Spinner 2
        ArrayList<String> list2=new ArrayList<>();
        list2.add("Karuna");
        list2.add("Mudita");
        list2.add("Ouupyitkhar");
        ArrayAdapter<String> adapter2=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,list2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);*/


        //Retrofit retrofit= restapi.getService();
        final jsonPlaceHolderApi jsonapi=retrofit.create(jsonPlaceHolderApi.class);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //int selectedId=grdo.getCheckedRadioButtonId();
                //rdo=findViewById(selectedId);
                n=name.getText().toString().trim();
                am=amt.getText().toString().trim();
                p=phone.getText().toString().trim();
                adr=address.getText().toString().trim();
                nr=nrc.getText().toString().trim();
                //Toast.makeText(getApplicationContext(),rdo.getText(), Toast.LENGTH_LONG).show();
                Call<addDonor_model> call=jsonapi.addUser(n,nr,"Optimal","Optimal",adr,p,blood,group);
                call.enqueue(new Callback<addDonor_model>() {
                    @Override
                    public void onResponse(Call<addDonor_model> call, Response<addDonor_model> response) {
                        Toast.makeText(getApplicationContext(),"Success"+n+blood+am+p+adr+nr+group, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<addDonor_model> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Fail:"+t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        //end of retrofit

        //Spinner Seleted
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(),"Position:"+i+"and"+bIndex.get(i),Toast.LENGTH_SHORT).show();
                blood=bIndex.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                group=gIndex.get(i);
                //Toast.makeText(getApplicationContext(),"Position:"+i+"and"+gIndex.get(i),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    //set back key on action bar

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            addDonor.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
