package com.example.luckskullnew;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class CreateidOneActivity extends AppCompatActivity {

    CardView cardview;
    ImageView img,circleimg;
    EditText edit,edit1;
    TextView text1,text2;

    //ok ok ok
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createid_one);

        cardview=findViewById(R.id.cardview);
        img=findViewById(R.id.img);
        edit=findViewById(R.id.edit);
        edit1=findViewById(R.id.edit1);
        circleimg=findViewById(R.id.circleimg);
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);

        String name=getIntent().getStringExtra("nam");
        String weburl=getIntent().getStringExtra("weburl");
        String imgurl=getIntent().getStringExtra("imgurl");

        text1.setText(name);
        text2.setText(weburl);

        Glide.with(this).load(imgurl).into(circleimg);


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CreateidOneActivity.this.finish();
            }
        });

        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(edit.getText().toString())){

                    Toast.makeText(CreateidOneActivity.this, "Enter name", Toast.LENGTH_SHORT).show();
                }

               else if (TextUtils.isEmpty(edit1.getText().toString())){

                    Toast.makeText(CreateidOneActivity.this, "Enter coins", Toast.LENGTH_SHORT).show();

                }

               else {

                    Intent intent=new Intent(CreateidOneActivity.this, PaymentMethodActivity.class);
                    intent.putExtra("editcoin",edit1.getText().toString());
                    intent.putExtra("username",edit.getText().toString());
                    intent.putExtra("createidone","");
                    intent.putExtra("weburl",weburl);
                    intent.putExtra("type","create");
                    startActivity(intent);

                }
            }
        });
    }
}