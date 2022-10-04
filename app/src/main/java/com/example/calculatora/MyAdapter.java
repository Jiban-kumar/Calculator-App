package com.example.calculatora;

import android.content.Context;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {
    Context context;
    int tabcount;

    public MyAdapter(@NonNull FragmentManager fm, Context context, int tabcount) {
        super(fm);
        this.context = context;
        this.tabcount = tabcount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                DistanceFragment fragment=new DistanceFragment();
                return fragment;
            case 1:
                AreaFragment fragment1=new AreaFragment();
                return  fragment1;
            case 2:
                VolumeFragment volumeFragment=new VolumeFragment();
                return volumeFragment;
            case 3:
                MassFragment massFragment=new MassFragment();
                return massFragment;
            case 4:
                SpeedFragment speedFragment=new SpeedFragment();
                return speedFragment;
            case 5:
                TempretureFragment tempretureFragment=new TempretureFragment();
                return tempretureFragment;
            case 6:
                PressureFragment pressureFragment=new PressureFragment();
                return pressureFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
