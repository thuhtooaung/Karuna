package org.mmarc.karuna.fragments;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import org.mmarc.karuna.R;
import org.mmarc.karuna.adapters.RecordRcAdapter;

import java.util.ArrayList;

public class tab2 extends Fragment {

    private ProgressBar progressBar;
    RecyclerView.LayoutManager layoutManager;
    RecordRcAdapter recordRcAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.tab2,null);
        final RecyclerView rc = v.findViewById(R.id.record_rv);
        //start recycler
        layoutManager=new LinearLayoutManager(getContext());
        rc.setHasFixedSize(true);
        rc.setLayoutManager(layoutManager);

        /*Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.43.43/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi jsonapi=retrofit.create(jsonPlaceHolderApi.class);*/
        /*Call<List<GetRecords>> call=jsonapi.getRecord();
        call.enqueue(new Callback<List<GetRecords>>() {
            @Override
            public void onResponse(Call<List<GetRecords>> call, Response<List<GetRecords>> response) {
                List<GetRecords> postRecords=response.body();
                ArrayList<String> record=new ArrayList<>();
                for (GetRecords post : postRecords) {
                    record.add(post.getName());
                    record.add(post.getBlood());
                    record.add(post.getDate());
                }
                recordRcAdapter=new RecordRcAdapter(record,getContext());
                rc.setAdapter(recordRcAdapter);
            }

            @Override
            public void onFailure(Call<List<GetRecords>> call, Throwable t) {

            }
        });*/
        ArrayList<String> record=new ArrayList<>();
        record.add("Mg Mg");
        record.add("A");
        record.add("12.1.12");
        record.add("Mudita");
        record.add("B,O");
        record.add("13.3.15");
        record.add("Mg Mg");
        record.add("A");
        record.add("15.1.12");
        record.add("Ag Ag");
        record.add("O");
        record.add("30.4.11");
        record.add("UCS");
        record.add("A,B");
        record.add("14.3.15");
        recordRcAdapter=new RecordRcAdapter(record,getContext());
        rc.setAdapter(recordRcAdapter);
        return v;
    }
}
