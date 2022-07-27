package com.example.sliderapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimpleFragmentPageAdapter extends FragmentPagerAdapter {
    public SimpleFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
       if(position==0)
       {
           return new Fragment1();
       }
       else if(position==2)
       {
           return new Fragment2();
       }
       else
       {
           return new Fragment3();
       }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
