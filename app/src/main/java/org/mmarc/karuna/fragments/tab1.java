package org.mmarc.karuna.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import org.mmarc.karuna.adapters.MViewPagerAdapter;
import org.mmarc.karuna.R;

public class tab1 extends Fragment {

    private RelativeLayout[] rl=new RelativeLayout[2];
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.tab1,null);

        //start setting tab
        rl[0]=v.findViewById(R.id.tabrl1);//array use for loop
        rl[1]=v.findViewById(R.id.tabrl2);

        //start of viewpager
        final ViewPager viewPager=v.findViewById(R.id.viewpager);
        MViewPagerAdapter adapter=new MViewPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                selected(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        //end of viewpager

        //start clicking tab
        //clicking the tab
        rl[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected(0);
                viewPager.setCurrentItem(0);
            }
        });
        rl[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected(1);
                viewPager.setCurrentItem(1);
            }
        });
        //end clicking tab

        //Tab selection
        selected(0);
        //end of tab selection

        return v;
    }

    private void selected(int position) {
        if (position==0){
            rl[0].setBackgroundResource(R.drawable.selected_tab_bg);
            rl[1].setBackgroundResource(R.drawable.primary_tab_bg);
        }
        if (position==1){
            rl[0].setBackgroundResource(R.drawable.primary_tab_bg);
            rl[1].setBackgroundResource(R.drawable.selected_tab_bg);
        }
    }
}
