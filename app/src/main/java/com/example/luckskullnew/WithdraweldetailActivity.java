package com.example.luckskullnew;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luckskullnew.Adapter.AddnewAdapter;

public class WithdraweldetailActivity extends AppCompatActivity {

    ImageView img,leftimg,leftimg1,leftimg2,leftimg3;
    TextView text,text1,googlepay,phonepay,paytmupi,upi;
    CardView card1,card2,card3,card4,googlecard1,phonepecard1,paytmcard1,upicard1;
    LinearLayout linear,linear1,linear2,linear3;
    RecyclerView recycle,recycle1,recycle2,recycle3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraweldetail);

        img=findViewById(R.id.img);
        text=findViewById(R.id.text);
        text1=findViewById(R.id.text1);
        googlepay=findViewById(R.id.googlepay);
        phonepay=findViewById(R.id.phonepay);
        paytmupi=findViewById(R.id.paytmupi);
        upi=findViewById(R.id.upi);
        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        card3=findViewById(R.id.card3);
        card4=findViewById(R.id.card4);
        googlecard1=findViewById(R.id.googlecard1);
        phonepecard1=findViewById(R.id.phonepecard1);
        paytmcard1=findViewById(R.id.paytmcard1);
        upicard1=findViewById(R.id.upicard1);
        leftimg=findViewById(R.id.leftimg);
        leftimg1=findViewById(R.id.leftimg1);
        leftimg2=findViewById(R.id.leftimg2);
        leftimg3=findViewById(R.id.leftimg3);
        linear=findViewById(R.id.linear);
        linear1=findViewById(R.id.linear1);
        linear2=findViewById(R.id.linear2);
        linear3=findViewById(R.id.linear3);
        recycle=findViewById(R.id.recycle);
        recycle1=findViewById(R.id.recycle1);
        recycle2=findViewById(R.id.recycle2);
        recycle3=findViewById(R.id.recycle3);



        SharedPreferences sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
        String name=sharedPreferences.getString("namete","");
        String number=sharedPreferences.getString("numberte","");
        String password=sharedPreferences.getString("password","");

        text.setText(name);
        text1.setText(number);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WithdraweldetailActivity.this.finish();
            }
        });

        googlepay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert=new AlertDialog.Builder(WithdraweldetailActivity.this);

                final View dialogView= LayoutInflater.from(WithdraweldetailActivity.this).inflate(R.layout.googlepaydilog,null,false);
                alert.setView(dialogView);

                final AlertDialog alertDialog=alert.create();
                alertDialog.show();

                ImageView googlepayimg=dialogView.findViewById(R.id.googlepayimg);

                googlepayimg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        alertDialog.cancel();
                    }
                });

                CardView cardview=dialogView.findViewById(R.id.cardview);
                EditText edit=dialogView.findViewById(R.id.edit);
                EditText edit1=dialogView.findViewById(R.id.edit1);
                cardview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (TextUtils.isEmpty(edit.getText().toString())){

                            Toast.makeText(WithdraweldetailActivity.this, "enter name", Toast.LENGTH_SHORT).show();
                        }
                        else if(TextUtils.isEmpty(edit1.getText().toString())){
                            Toast.makeText(WithdraweldetailActivity.this, "enter no", Toast.LENGTH_SHORT).show();
                        }

                        else {
                            SharedPreferences sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.putString("name",edit.getText().toString());
                            editor.putString("number",edit1.getText().toString());
                            editor.commit();
                            alertDialog.cancel();
                            card1.setVisibility(View.GONE);
                            googlecard1.setVisibility(View.VISIBLE);

                            leftimg.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    if (linear.getVisibility() == View.VISIBLE){
                                        linear.setVisibility(View.GONE);
                                    }
                                    else if (linear.getVisibility() == View.GONE){
                                        linear.setVisibility(View.VISIBLE);
                                    }

                                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(WithdraweldetailActivity.this, RecyclerView.VERTICAL, false);
                                    recycle.setLayoutManager(linearLayoutManager);
                                    AddnewAdapter adapter = new AddnewAdapter(WithdraweldetailActivity.this);
                                    recycle.setAdapter(adapter);

                                }
                            });
                        }
                    }
                });

            }
        });

        phonepay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert=new AlertDialog.Builder(WithdraweldetailActivity.this);

                final View dialogView= LayoutInflater.from(WithdraweldetailActivity.this).inflate(R.layout.phonepaydilog,null,false);
                alert.setView(dialogView);

                final AlertDialog alertDialog=alert.create();
                alertDialog.show();

               /* ImageView googlepayimg=dialogView.findViewById(R.id.googlepayimg);
                googlepayimg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        alertDialog.cancel();
                    }
                });*/
                CardView cardview=dialogView.findViewById(R.id.cardview);
                EditText edit=dialogView.findViewById(R.id.edit);
                EditText edit1=dialogView.findViewById(R.id.edit1);

                cardview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (TextUtils.isEmpty(edit.getText().toString())){

                            Toast.makeText(WithdraweldetailActivity.this, "enter name", Toast.LENGTH_SHORT).show();
                        }
                        else if(TextUtils.isEmpty(edit1.getText().toString())){
                            Toast.makeText(WithdraweldetailActivity.this, "enter no", Toast.LENGTH_SHORT).show();
                        }

                        else {
                            SharedPreferences sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.putString("name",edit.getText().toString());
                            editor.putString("number",edit1.getText().toString());
                            editor.commit();
                            alertDialog.cancel();
                            card2.setVisibility(View.GONE);
                                phonepecard1.setVisibility(View.VISIBLE);

                            leftimg1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    if (linear1.getVisibility() == View.VISIBLE){
                                    linear1.setVisibility(View.GONE);
                                    }
                                    else if (linear1.getVisibility() == View.GONE){
                                        linear1.setVisibility(View.VISIBLE);
                                    }

                                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(WithdraweldetailActivity.this, RecyclerView.VERTICAL, false);
                                    recycle1.setLayoutManager(linearLayoutManager);
                                    AddnewAdapter adapter = new AddnewAdapter(WithdraweldetailActivity.this);
                                    recycle1.setAdapter(adapter);

                                }
                            });
                        }
                    }
                });
            }
        });

       paytmupi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert=new AlertDialog.Builder(WithdraweldetailActivity.this);

                final View dialogView= LayoutInflater.from(WithdraweldetailActivity.this).inflate(R.layout.paumentupidilog,null,false);
                alert.setView(dialogView);

                final AlertDialog alertDialog=alert.create();
                alertDialog.show();


               /* ImageView googlepayimg=dialogView.findViewById(R.id.googlepayimg);
                googlepayimg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        alertDialog.cancel();
                    }
                });*/
                CardView cardview=dialogView.findViewById(R.id.cardview);
                EditText edit=dialogView.findViewById(R.id.edit);
                EditText edit1=dialogView.findViewById(R.id.edit1);

                cardview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (TextUtils.isEmpty(edit.getText().toString())){

                            Toast.makeText(WithdraweldetailActivity.this, "enter name", Toast.LENGTH_SHORT).show();
                        }
                        else if(TextUtils.isEmpty(edit1.getText().toString())){
                            Toast.makeText(WithdraweldetailActivity.this, "enter no", Toast.LENGTH_SHORT).show();
                        }

                        else {
                            SharedPreferences sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.putString("name",edit.getText().toString());
                            editor.putString("number",edit1.getText().toString());
                            editor.commit();
                            alertDialog.cancel();
                            card3.setVisibility(View.GONE);
                            paytmcard1.setVisibility(View.VISIBLE);

                            leftimg2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    if (linear2.getVisibility() == View.VISIBLE){
                                        linear2.setVisibility(View.GONE);
                                    }
                                    else if (linear2.getVisibility() == View.GONE){
                                        linear2.setVisibility(View.VISIBLE);
                                    }

                                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(WithdraweldetailActivity.this, RecyclerView.VERTICAL, false);
                                    recycle2.setLayoutManager(linearLayoutManager);
                                    AddnewAdapter adapter = new AddnewAdapter(WithdraweldetailActivity.this);
                                    recycle2.setAdapter(adapter);

                                }
                            });
                        }
                    }
                });
            }
        });

        upi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert=new AlertDialog.Builder(WithdraweldetailActivity.this);

                final View dialogView= LayoutInflater.from(WithdraweldetailActivity.this).inflate(R.layout.upidilog,null,false);
                alert.setView(dialogView);

                final AlertDialog alertDialog=alert.create();
                alertDialog.show();

                CardView cardview=dialogView.findViewById(R.id.cardview);
                EditText edit=dialogView.findViewById(R.id.edit);
                EditText edit1=dialogView.findViewById(R.id.edit1);

                cardview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (TextUtils.isEmpty(edit.getText().toString())){

                            Toast.makeText(WithdraweldetailActivity.this, "enter name", Toast.LENGTH_SHORT).show();
                        }
                        else if(TextUtils.isEmpty(edit1.getText().toString())){
                            Toast.makeText(WithdraweldetailActivity.this, "enter no", Toast.LENGTH_SHORT).show();
                        }

                        else {
                            SharedPreferences sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.putString("name",edit.getText().toString());
                            editor.putString("number",edit1.getText().toString());
                            editor.commit();
                            alertDialog.cancel();
                            card4.setVisibility(View.GONE);
                            upicard1.setVisibility(View.VISIBLE);

                            leftimg3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    if (linear3.getVisibility() == View.VISIBLE){
                                        linear3.setVisibility(View.GONE);
                                    }
                                    else if (linear3.getVisibility() == View.GONE){
                                        linear3.setVisibility(View.VISIBLE);
                                    }

                                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(WithdraweldetailActivity.this, RecyclerView.VERTICAL, false);
                                    recycle3.setLayoutManager(linearLayoutManager);
                                    AddnewAdapter adapter = new AddnewAdapter(WithdraweldetailActivity.this);
                                    recycle3.setAdapter(adapter);

                                }
                            });
                        }
                    }
                });

            }
        });
    }
}