package org.mmarc.karuna.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.mmarc.karuna.adapters.MtabGroupRcAdapter;
import org.mmarc.karuna.R;
import org.mmarc.karuna.jsonPlaceHolderApi;
import org.mmarc.karuna.models.GetAllGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class tabgroup extends Fragment {
    private ProgressBar progressBar;
    MtabGroupRcAdapter mtabGroupRcAdapter;
    public static Fragment newInstance() {
        Bundle args=new Bundle();
        tabgroup fragment=new tabgroup();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.activity_tabgroup,null);
        final RecyclerView recyclerView = v.findViewById(R.id.tabgroup_rv);
        progressBar=v.findViewById(R.id.tabgp_pb);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi japi=retrofit.create(jsonPlaceHolderApi.class);
        Call<List<GetAllGroup>> call=japi.getGroup();
        call.enqueue(new Callback<List<GetAllGroup>>() {
            @Override
            public void onResponse(Call<List<GetAllGroup>> call, Response<List<GetAllGroup>> response) {
                List<GetAllGroup> groupPosts=response.body();
                ArrayList<String> databody=new ArrayList<>();
                for (GetAllGroup post : groupPosts) {
                    databody.add(post.getGname());
                    databody.add(post.getBlood());
                    databody.add(post.getLocation());
                }

                progressBar.setVisibility(View.GONE);

                Toast.makeText(getContext(),"OK",Toast.LENGTH_LONG).show();
                mtabGroupRcAdapter=new MtabGroupRcAdapter(databody,getContext());
                recyclerView.setAdapter(mtabGroupRcAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            }

            @Override
            public void onFailure(Call<List<GetAllGroup>> call, Throwable t) {

            }
        });
        //End of ArrayList for recycler adapter

        //start of recycler
        /*recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        MtabGroupRcAdapter mtabGroupRcAdapter=new MtabGroupRcAdapter(groupdata,getContext());
        recyclerView.setAdapter(mtabGroupRcAdapter);*/
        //end of recycler
        return v;
    }
}
