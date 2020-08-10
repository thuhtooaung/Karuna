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
import android.widget.Toast;

import org.mmarc.karuna.adapters.MtaballRcAdapter;
import org.mmarc.karuna.R;
import org.mmarc.karuna.jsonPlaceHolderApi;
import org.mmarc.karuna.models.GetAllDonor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class taball extends Fragment{
    private RecyclerView rcv;
    private ProgressBar progressBar;
    MtaballRcAdapter adapter;
    int currentItem,totalItem,scrollOutItem;
    LinearLayoutManager manager;
    boolean isScrolling;
    ArrayList<String> databody;

    public static Fragment newInstance() {
        Bundle args=new Bundle();
        taball fragment=new taball();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.activity_taball,null);
        rcv=v.findViewById(R.id.taball_rv);
        progressBar=v.findViewById(R.id.taball_pb);
        //start of Recycler
        manager=new LinearLayoutManager(getContext());
        rcv.setLayoutManager(manager);
        //rcv.setLayoutManager(manager);

        //Retrofit
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.43.163/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi jsonapi=retrofit.create(jsonPlaceHolderApi.class);
        Call<List<GetAllDonor>> call=jsonapi.getRes();
        call.enqueue(new Callback<List<GetAllDonor>>() {
            @Override
            public void onResponse(Call<List<GetAllDonor>> call, Response<List<GetAllDonor>> response) {
                List<GetAllDonor> posts=response.body();
                databody=new ArrayList<>();
                databody.clear();
                for (GetAllDonor post : posts) {
                    databody.add(post.getName());
                    databody.add(post.getBlood());
                    databody.add(post.getAmount());
                    databody.add(post.getDate());
                }
                progressBar.setVisibility(View.INVISIBLE);
                adapter = new MtaballRcAdapter(databody,getContext());
                rcv.setAdapter(adapter);
                //rcv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                //rcv.setHasFixedSize(true);
                /*rcv.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);
                        if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                            isScrolling=true;
                        }
                    }

                    @Override
                    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);
                        currentItem=manager.getChildCount();
                        totalItem=manager.getItemCount();
                        scrollOutItem=manager.findFirstVisibleItemPosition();
                        if (isScrolling && (currentItem+scrollOutItem==totalItem)){
                            isScrolling=false;
                            Toast.makeText(getContext(),"No more item !",Toast.LENGTH_LONG).show();
                        }
                    }
                });*/

            }

            @Override
            public void onFailure(Call<List<GetAllDonor>> call, Throwable t) {
                Toast.makeText(getContext(),"Fail:"+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        //end of Retrofit
        //end of Recycler

        //rcv.setHasFixedSize(true);

        return v;

    }

}
