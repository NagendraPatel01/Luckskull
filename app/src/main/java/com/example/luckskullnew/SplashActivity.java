package com.example.luckskullnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
                boolean status =sharedPreferences.getBoolean("status",false);
                boolean done =sharedPreferences.getBoolean("done",false);

                if (status){
                    startActivity(new Intent(SplashActivity.this, DashboaedActivity.class));
                    finish();
                }
                else if (done){
                    startActivity(new Intent(SplashActivity.this, DashboaedActivity.class));
                    finish();
                }
                else {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }

            }
        },2000);
    }
}