package org.mmarc.karuna.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;

import org.mmarc.karuna.R;
import org.mmarc.karuna.fragments.tab1;
import org.mmarc.karuna.fragments.tab2;
import org.mmarc.karuna.fragments.tab3;

public class MainActivity extends AppCompatActivity{

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment=null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment=new tab1();
                    break;
                case R.id.navigation_dashboard:
                    fragment=new tab2();
                    break;
                case R.id.navigation_notifications:
                    fragment=new tab3();
                    break;
            }
            return loadFragment(fragment);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportActionBar().setElevation(0);//to remove action bar shadow
        //for initial fragment loading
        loadFragment(new tab1());
    }


    //start--load fragment is for tabview to framelayout
    private boolean loadFragment(Fragment fragmentpage){
        if (fragmentpage!=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainframe,fragmentpage)
                    .commit();
            return true;
        }
        return false;
    }
    //end--load fragment

    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.search){
            Intent it=new Intent(this, search.class);
            startActivity(it);
        }
        return super.onOptionsItemSelected(item);
    }
    //end menu
}
