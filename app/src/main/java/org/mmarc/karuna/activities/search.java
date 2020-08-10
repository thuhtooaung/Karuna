package org.mmarc.karuna.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import org.mmarc.karuna.R;

public class search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //start suggestion
        final AutoCompleteTextView autotv=findViewById(R.id.auto_com_tv);
        String[] str=new String[]{"A","B","AB","O"};
        final ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.search_suggest,R.id.suggest_tv,str);
        autotv.setAdapter(adapter);
        //end suggestion

        //start enter key capture
        autotv.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getKeyCode()==KeyEvent.KEYCODE_ENTER){

                }
                return false;
            }
        });
        //end enter key capture

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            search.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
