package org.mmarc.karuna.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.mmarc.karuna.fragments.taball;
import org.mmarc.karuna.fragments.tabgroup;

public class MViewPagerAdapter extends FragmentStatePagerAdapter {
    public MViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (i==0){
            return taball.newInstance();
        }
        if (i==1){
            return tabgroup.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
