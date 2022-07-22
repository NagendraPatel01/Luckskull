package com.example.luckskullnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingDeque;

public class RagisterActivity extends AppCompatActivity {

    EditText name,phoneNumber,password;
    ProgressBar progress;
    TextView submit;
    String url = "https://luckskull.com/api/user-register";
    RequestQueue queue;
    StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ragister);

        name=findViewById(R.id.name);
        phoneNumber=findViewById(R.id.phoneNumber);
        password=findViewById(R.id.password);
        submit=findViewById(R.id.submit);
        progress=findViewById(R.id.progress);

        String number;
        number=getIntent().getStringExtra("textvire");

        phoneNumber.setText(number);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(name.getText().toString())){
                    Toast.makeText(RagisterActivity.this, "enter name", Toast.LENGTH_SHORT).show();
                }

               else if (TextUtils.isEmpty(phoneNumber.getText().toString())){
                    Toast.makeText(RagisterActivity.this, "enter phone number", Toast.LENGTH_SHORT).show();
                }

                else if (TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(RagisterActivity.this, "enter password number", Toast.LENGTH_SHORT).show();
                }

                else {

                    progress.setVisibility(View.VISIBLE);
                    queue= Volley.newRequestQueue(RagisterActivity.this);
                    request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("hutiuethieuh", "eiutheiurther"+response);


                            progress.setVisibility(View.GONE);

                            try {
                                JSONObject object=new JSONObject(response);
                                boolean done = object.getBoolean("done");
                                String id=object.getString("id");
                                String otp=object.getString("otp");
                                Toast.makeText(RagisterActivity.this, "Ragister Successfully", Toast.LENGTH_SHORT).show();

                                SharedPreferences sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
                                SharedPreferences.Editor editor=sharedPreferences.edit();
                                editor.putBoolean("done",done);
                                editor.putString("namete",object.getString("name"));
                                editor.putString("numberte",object.getString("phone_number"));
                                editor.putString("passwordte",object.getString("password"));
                                editor.commit();

                                if (done){

                                    Intent intent=new Intent(RagisterActivity.this,OtpActivity.class);
                                    intent.putExtra("id",id);
                                    intent.putExtra("otp",otp);
                                    startActivity(intent);
                                    finish();

                                }


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("iodgjiorgjoerigjoir", "iuwrhiewrhoeifg"+error);


                            try {
                                String res = new String(error.networkResponse.data, StandardCharsets.UTF_8);
                                JSONObject resp = new JSONObject(res);
                                Toast.makeText(RagisterActivity.this, resp.getString("message"), Toast.LENGTH_SHORT).show();

                            } catch (JSONException e) {
                                e.printStackTrace();
                                Intent i = new Intent();
                                i.putExtra("status", false);
                                setResult(RESULT_CANCELED, i);
                                finish();
                            }
                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() {

                            Map<String,String> params = new HashMap<String, String>();
                            params.put("name",name.getText().toString());
                            params.put("phone_number",phoneNumber.getText().toString());
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