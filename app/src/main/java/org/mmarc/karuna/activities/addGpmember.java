package org.mmarc.karuna.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.mmarc.karuna.R;

public class addGpmember extends AppCompatActivity {
    EditText edi1,edi2,edi3,edi4,edi5,edi6;
    Button btn_save,btn_finish,btn_next;
    RadioGroup grdo;
    RadioButton rdo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_gp_member);

        TextView tv=findViewById(R.id.add_mtv);
        edi1=findViewById(R.id.gpm_name);
        edi2=findViewById(R.id.gpm_blood);
        edi3=findViewById(R.id.gpm_amt);
        edi4=findViewById(R.id.gpm_phone);
        edi5=findViewById(R.id.gpm_address);
        edi6=findViewById(R.id.gpm_nrc);
        grdo=findViewById(R.id.m_rdo);

        btn_save=findViewById(R.id.gpm_save);
        btn_next=findViewById(R.id.gpm_next);
        btn_finish=findViewById(R.id.gpm_finish);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String it=getIntent().getStringExtra("name");
        tv.setText(it);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId=grdo.getCheckedRadioButtonId();
                rdo=findViewById(selectedId);
                Toast.makeText(getApplicationContext(),rdo.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            addGpmember.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
