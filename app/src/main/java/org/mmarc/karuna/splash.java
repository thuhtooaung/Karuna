package org.mmarc.karuna;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.mmarc.karuna.activities.MainActivity;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        Intent it=new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(it);
                        splash.this.finish();
                    }
                },3000
        );
    }
}
