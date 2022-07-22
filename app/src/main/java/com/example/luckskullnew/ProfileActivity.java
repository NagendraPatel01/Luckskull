package com.example.luckskullnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    ImageView img;
    TextView textname,textnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        img=findViewById(R.id.img);
        textname=findViewById(R.id.textname);
        textnumber=findViewById(R.id.textnumber);

        SharedPreferences sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
        String name=sharedPreferences.getString("namete","");
        String number=sharedPreferences.getString("numberte","");
        String password=sharedPreferences.getString("password","");

        textname.setText(name);
        textnumber.setText(number);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProfileActivity.this.finish();
            }
        });
    }
}