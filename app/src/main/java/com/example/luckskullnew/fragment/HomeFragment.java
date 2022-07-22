package com.example.luckskullnew.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.luckskullnew.Adapter.SliderAdapter;
import com.example.luckskullnew.DepositActivity;
import com.example.luckskullnew.R;
import com.example.luckskullnew.WithdrawActivity;
import com.smarteist.autoimageslider.SliderView;


public class HomeFragment extends Fragment {

    SliderView slider;
    LinearLayout linear1,Deposit,withdraw;
    CardView card;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        slider=view.findViewById(R.id.slider);
        linear1=view.findViewById(R.id.linear1);
        Deposit=view.findViewById(R.id.Deposit);
        withdraw=view.findViewById(R.id.withdraw);
        card=view.findViewById(R.id.card);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CreateidFragment fragment2 = new CreateidFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.linear1, fragment2);
                fragmentTransaction.commit();
            }
        });

        linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://instagram.com/ankit.6614")));


            }
        });

        withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getContext(), WithdrawActivity.class));
            }
        });

        slider.setSliderAdapter(new SliderAdapter(getContext()));

        Deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getContext(), DepositActivity.class));
            }
        });



        return view;
    }

}