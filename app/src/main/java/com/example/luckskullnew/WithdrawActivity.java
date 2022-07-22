package com.example.luckskullnew;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class WithdrawActivity extends AppCompatActivity {

    ImageView img;
    CardView card;
    ProgressBar progress;
    EditText editcoin;

    String url = "https://luckskull.com/api/withdraw-request";
    RequestQueue queue;
    StringRequest request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);

        img=findViewById(R.id.img);
        progress = findViewById(R.id.progress);
        card = findViewById(R.id.card);
        editcoin = findViewById(R.id.editcoin);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WithdrawActivity.this.finish();
            }
        });

        progress.setVisibility(View.GONE);
            AlertDialog.Builder alert=new AlertDialog.Builder(WithdrawActivity.this);
            final View dialogView= LayoutInflater.from(WithdrawActivity.this).inflate(R.layout.addbankaccoutdilog,null,false);
            alert.setView(dialogView);
            final AlertDialog alertDialog=alert.create();
            alertDialog.show();

        CardView cardview=dialogView.findViewById(R.id.cardview);
        EditText edit=dialogView.findViewById(R.id.edit);
        EditText edit1=dialogView.findViewById(R.id.edit1);
        EditText edit2=dialogView.findViewById(R.id.edit2);
        EditText edit3=dialogView.findViewById(R.id.edit3);

        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(edit.getText().toString())){
                    Toast.makeText(WithdrawActivity.this, "enter Bank Name", Toast.LENGTH_SHORT).show();
                }

               else if (TextUtils.isEmpty(edit1.getText().toString())){
                    Toast.makeText(WithdrawActivity.this, "enter Account no", Toast.LENGTH_SHORT).show();
                }

               else if (TextUtils.isEmpty(edit2.getText().toString())){
                    Toast.makeText(WithdrawActivity.this, "enter IFSC", Toast.LENGTH_SHORT).show();
                }

              else if (TextUtils.isEmpty(edit3.getText().toString())){
                    Toast.makeText(WithdrawActivity.this, "enter Account Holder Name", Toast.LENGTH_SHORT).show();
                }

              else {

                    queue= Volley.newRequestQueue(WithdrawActivity.this);
                    request=new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("sdufghiudghiu", "ghudghiudgh"+response);

                            alertDialog.cancel();

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("ehgieurhgieur", "seighiuerhgeirhjgu"+error.getMessage());



                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String,String> params = new HashMap<String, String>();

                            SharedPreferences sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
                            String number=sharedPreferences.getString("numberte","");

                            Log.d("hguhiugefu", "fjhgiuhi"+number);

                            params.put("phone",number);
                            params.put("withdraw_method","bank");
                            params.put("bank_name",edit.getText().toString());
                            params.put("ifsc",edit2.getText().toString());
                            params.put("account_no",edit1.getText().toString());
                            params.put("account_holder_name",edit3.getText().toString());
                            params.put("amount","3000");
                            return params;
                        }
                    };
                    queue.add(request);


                }


            }
        });

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(editcoin.getText().toString())){
                    Toast.makeText(WithdrawActivity.this, "enter Coins", Toast.LENGTH_SHORT).show();
                }


                else {

                    queue= Volley.newRequestQueue(WithdrawActivity.this);
                    request=new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("sdufghiudghiu", "sughiughiudghu"+response);

                            alertDialog.cancel();

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("ehgieurhgieur", "iueytiueghiueghiu"+error.getMessage());



                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String,String> params = new HashMap<String, String>();

                            SharedPreferences sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
                            String number=sharedPreferences.getString("numberte","");

                            Log.d("hguhiugefu", "fjhgiuhi"+number);

                            params.put("phone",number);
                            params.put("withdraw_method","UPI");
                            params.put("upi_number","subhankar0810@oksbi");
                            params.put("amount", editcoin.getText().toString());
                            return params;
                        }
                    };
                    queue.add(request);


                }
            }
        });
    }
}