package org.mmarc.karuna.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.mmarc.karuna.R;

public class addGroup extends AppCompatActivity {

    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_group);

        final EditText edi1=findViewById(R.id.gdname);
        EditText edi2=findViewById(R.id.gdphone);
        EditText edi3=findViewById(R.id.gdaddress);
        final EditText edi_count=findViewById(R.id.gdm_count);
        Button addmember=findViewById(R.id.add_member);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addmember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(getApplicationContext(), addGpmember.class);
                it.putExtra("name",edi1.getText().toString());
                startActivity(it);
            }
        });

    }

    //back key on action bar

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            addGroup.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
