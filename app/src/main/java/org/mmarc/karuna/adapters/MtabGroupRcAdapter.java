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

public class MtabGroupRcAdapter extends RecyclerView.Adapter<MtabGroupRcAdapter.ViewHolder> {
    private ArrayList<String> data;
    private Context ctx;
    public MtabGroupRcAdapter(ArrayList<String> groupdata, Context context) {
        data=groupdata;
        ctx=context;
    }

    @NonNull
    @Override
    public MtabGroupRcAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.taball_rv_row,viewGroup,false);
        return new MtabGroupRcAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        int c=i*3;
        viewHolder.tv1.setText(data.get(c));
        viewHolder.tv2.setText(data.get(c+1));
        viewHolder.tv3.setText(data.get(c+2));

        //cardview click
        viewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctx.startActivity(new Intent(ctx, detail.class));
            }
        });
        //end cardview click
    }


    @Override
    public int getItemCount() {
        return data.size()/3;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv1,tv2,tv3;
        CardView cv;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.tatv1_value);
            tv2=itemView.findViewById(R.id.tatv2_value);
            tv3=itemView.findViewById(R.id.tatv3_value);
            cv=itemView.findViewById(R.id.ta_row_cv);
        }
    }
}
