package com.example.luckskullnew.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luckskullnew.Adapter.IDSAdapter;
import com.example.luckskullnew.R;
import com.google.android.material.tabs.TabLayout;


public class IDsFragment extends Fragment {

TabLayout tabLayout;
ViewPager pager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_i_ds, container, false);

         pager=view.findViewById(R.id.pager);
        tabLayout=view.findViewById(R.id.tab);


        pager.setAdapter(new IDSAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(pager);

        pager.setCurrentItem(1);


        return view;
    }
}