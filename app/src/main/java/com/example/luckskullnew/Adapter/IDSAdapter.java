package com.example.luckskullnew.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.luckskullnew.fragment.CreateidFragment;
import com.example.luckskullnew.fragment.MyIdFragment;

public class IDSAdapter extends FragmentStatePagerAdapter {


    public IDSAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                return new MyIdFragment();

            case 1:
                return new CreateidFragment();


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {

            case 0:
                return "My IDs";

            case 1:
                return "Create ID";

            default:
                return null;
        }
    }
}
