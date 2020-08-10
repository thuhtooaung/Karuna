package org.mmarc.karuna.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.mmarc.karuna.R;

public class GmRcAdapter extends RecyclerView.Adapter<GmRcAdapter.ViewHolder>{
    int size;
    Context context;
    public GmRcAdapter(Context applicationContext, int count) {
        context=applicationContext;
        size=count;
    }

    @NonNull
    @Override
    public GmRcAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.row_for_gdrv,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GmRcAdapter.ViewHolder viewHolder, int i) {
        if (i==size-1){
            viewHolder.btn.setVisibility(View.VISIBLE);
            viewHolder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"OK",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return size;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        Button btn;
        EditText edi1,edi2,edi3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btn=itemView.findViewById(R.id.g_finish);
            edi1=itemView.findViewById(R.id.m_name);
            edi2=itemView.findViewById(R.id.m_blood);
            edi3=itemView.findViewById(R.id.m_amt);
        }
    }
}
