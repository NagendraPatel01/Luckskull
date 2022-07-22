package com.example.luckskullnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TermsActivity extends AppCompatActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        img=findViewById(R.id.img);

       img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TermsActivity.this.finish();
            }
        });
    }
}