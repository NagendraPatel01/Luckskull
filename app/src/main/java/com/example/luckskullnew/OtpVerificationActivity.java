package com.example.luckskullnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class OtpVerificationActivity extends AppCompatActivity {

    ImageView img;
    EditText Edit;
    CardView cardview;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        img=findViewById(R.id.img);
        Edit=findViewById(R.id.Edit);
        cardview=findViewById(R.id.cardview);
        progress=findViewById(R.id.progress);

        String otp;
        otp=getIntent().getStringExtra("otp1");

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OtpVerificationActivity.this.finish();
            }
        });

        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progress.setVisibility(View.VISIBLE);
                if (TextUtils.isEmpty(Edit.getText().toString())){
                    Toast.makeText(OtpVerificationActivity.this, "Enter otp", Toast.LENGTH_SHORT).show();
                }

                else if (Edit.getText().toString().equals(otp)){
                    Intent intent=new Intent(OtpVerificationActivity.this,ChangePasswordActivity.class);
                    startActivity(intent);
                    finish();
                }

                else {

                    progress.setVisibility(View.GONE);
                    Toast.makeText(OtpVerificationActivity.this, "Wrong Otp", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}