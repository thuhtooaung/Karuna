package org.mmarc.karuna.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.mmarc.karuna.R;
import org.mmarc.karuna.activities.detail;

import java.util.ArrayList;

public class MtaballRcAdapter extends RecyclerView.Adapter<MtaballRcAdapter.ViewHolder>{
    private Context contx;
    private ArrayList<String> str;

    public MtaballRcAdapter(ArrayList<String> data, Context context) {
        contx=context;
        str=data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.taball_rv_row,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        /*if (c<=str.size()){
            viewHolder.tv1.setText(str.get(a));
            viewHolder.tv2.setText(str.get(a));
            viewHolder.tv3.setText(str.get(a));
        }
        a=a+3;*/
        int c=i*4;
        viewHolder.tv1.setText(str.get(c));
        viewHolder.tv2.setText(str.get(c+1));
        viewHolder.tv3.setText(str.get(c+2));
        viewHolder.tv4.setText(str.get(c+3));

        //cardview click
        viewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contx.startActivity(new Intent(contx, detail.class));
            }
        });
        //end cardview click
    }

    @Override
    public int getItemCount() {
        return str.size()/4;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv1,tv2,tv3,tv4;
        CardView cv;
        RecyclerView recyclerView;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.tatv1_value);
            tv2=itemView.findViewById(R.id.tatv2_value);
            tv3=itemView.findViewById(R.id.tatv3_value);
            tv4=itemView.findViewById(R.id.tatv4_value);
            cv=itemView.findViewById(R.id.ta_row_cv);
            recyclerView=itemView.findViewById(R.id.taball_rv);
        }
    }
}
