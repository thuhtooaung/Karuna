package org.mmarc.karuna.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.mmarc.karuna.R;

import java.util.ArrayList;

public class RecordRcAdapter extends RecyclerView.Adapter<RecordRcAdapter.ViewHolder> {
    private int c;
    private ArrayList<String> rec;

    public RecordRcAdapter(ArrayList<String> record, Context context) {
        rec=record;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.record_row,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tv1.setText(rec.get(c));
        viewHolder.tv2.setText(rec.get(c+1));
        viewHolder.tv3.setText(rec.get(c+2));
        c=c+3;
    }

    @Override
    public int getItemCount() {
        return rec.size()/3;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv1,tv2,tv3;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.name_value);
            tv2=itemView.findViewById(R.id.btype_value);
            tv3=itemView.findViewById(R.id.date_value);
        }
    }
}
