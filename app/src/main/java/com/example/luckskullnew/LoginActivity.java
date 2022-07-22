package com.example.luckskullnew;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    CardView cardview;
    ImageView img;
    TextInputEditText password;
    EditText phone_number;
    TextView otp,forgetpassword;
    ProgressBar progress;
    String url = "https://luckskull.com/api/user-login";
    String url1 = "https://luckskull.com/api/forget-password";
    RequestQueue queue;
    StringRequest request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        img=findViewById(R.id.img);
        cardview=findViewById(R.id.cardview);
        forgetpassword=findViewById(R.id.forgetpassword);
        phone_number=findViewById(R.id.phone_number);
        password=findViewById(R.id.password);
        otp=findViewById(R.id.otp);
        progress=findViewById(R.id.progress);

        String number;
        number=getIntent().getStringExtra("textvire");
        phone_number.setText(number);


        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               queue = Volley.newRequestQueue(LoginActivity.this);
                request=new StringRequest(Request.Method.POST,url1, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("sdufghiudghiu", "iudghiuegheru"+response);

                        try {
                            JSONObject jsonObjec=new JSONObject(response);
                            String otpvr=jsonObjec.getString("opt");

                            Intent intent=new Intent(LoginActivity.this,OtpVerificationActivity.class);
                            intent.putExtra("otp1",otpvr);
                            startActivity(intent);
                            finish();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }




                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ehgieurhgieur", "ughieuhgieurg"+error.getMessage());



                    }
                }){
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String,String> params = new HashMap<String, String>();
                        params.put("phone","6209265435");
                        return params;
                    }
                };
                queue.add(request);
            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginActivity.this.finish();
            }
        });

        otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progress.setVisibility(View.VISIBLE);
                Intent intent=new Intent(LoginActivity.this,OtpActivity.class);

                intent.putExtra("number",phone_number.getText().toString());
                startActivity(intent);
            }
        });
        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(phone_number.getText().toString())){

                    Toast.makeText(LoginActivity.this, "Enter Phone number", Toast.LENGTH_SHORT).show();
                }

                else if (TextUtils.isEmpty(password.getText().toString())){

                    Toast.makeText(LoginActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();

                }

                else {
                    progress.setVisibility(View.VISIBLE);
                    queue = Volley.newRequestQueue(LoginActivity.this);
                    request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("gjhriogjor", "jghrigjoei"+response);

                            progress.setVisibility(View.GONE);

                            try {
                                JSONObject object=new JSONObject(response);
                                String message = object.getString("message");
                                boolean status = object.getBoolean("status");
                                Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();

                                SharedPreferences sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
                                SharedPreferences.Editor editor=sharedPreferences.edit();
                                editor.putBoolean("status",status);
                                editor.putString("numberte",phone_number.getText().toString());
                                editor.commit();



                                if (status){

                               startActivity(new Intent(LoginActivity.this,DashboaedActivity.class));

                                }else {

                                    startActivity(new Intent(LoginActivity.this,RagisterActivity.class));

                                }
                                finish();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }



                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("jfbejghie", "iuthiehtet"+error);
                            progress.setVisibility(View.GONE);
                            try {
                                String res = new String(error.networkResponse.data, StandardCharsets.UTF_8);
                                JSONObject resp = new JSONObject(res);
                                Toast.makeText(LoginActivity.this, resp.getString("message"), Toast.LENGTH_SHORT).show();

                            } catch (JSONException e) {
                                e.printStackTrace();
                                Intent i = new Intent();
                                i.putExtra("status", false);
                                setResult(RESULT_CANCELED, i);
                                finish();
                            }

                        }
                    }

                    ){

                        @Override
                        protected Map<String, String> getParams() {
                            Map<String,String> params = new HashMap<String, String>();
                            params.put("phone_number",phone_number.getText().toString());
                            params.put("password",password.getText().toString());

                            return params;
                        }
                    };
                    queue.add(request);

                }
            }
        });
    }
}