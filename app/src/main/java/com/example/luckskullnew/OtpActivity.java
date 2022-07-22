package com.example.luckskullnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

import java.util.HashMap;
import java.util.Map;

public class OtpActivity extends AppCompatActivity {

    TextView text2,submit;
    EditText Edit;
    ProgressBar progress;
    String url = "https://luckskull.com/api/user-register-update";
    RequestQueue queue;
    StringRequest request;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        text2=findViewById(R.id.text2);
        submit=findViewById(R.id.submit);
        Edit=findViewById(R.id.Edit);
        progress=findViewById(R.id.progress);

        String number;
        number=getIntent().getStringExtra("number");
        text2.setText(number);

        String id;
        String otp;

        id=getIntent().getStringExtra("id");
        otp=getIntent().getStringExtra("otp");


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(Edit.getText().toString())){

                    Toast.makeText(OtpActivity.this, "Enter Otp", Toast.LENGTH_SHORT).show();

                }


                else if (Edit.getText().toString().equals(otp)) {
                    progress.setVisibility(View.VISIBLE);

                    queue= Volley.newRequestQueue(OtpActivity.this);
                    request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("hugfidujghidu", "jdgiodkgjoif"+response);

                            progress.setVisibility(View.GONE);
                            try {
                                JSONObject jsonObject=new JSONObject(response);

                                boolean status= jsonObject.getBoolean("status");
                                String message=jsonObject.getString("message");

                                Toast.makeText(OtpActivity.this, "Ragister Successfully", Toast.LENGTH_SHORT).show();
                                Toast.makeText(OtpActivity.this, message, Toast.LENGTH_SHORT).show();

                                if (status){

                                    startActivity(new Intent(OtpActivity.this,DashboaedActivity.class));
                                    finish();

                                }

                                else {

                                    Toast.makeText(OtpActivity.this, "Status notupdate", Toast.LENGTH_SHORT).show();

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Log.d("ijrgoirjhoijh", "iughriuhgoeur"+error);
                        }

                    }){
                        @Override
                        protected Map<String, String> getParams() {

                            Map<String,String> params = new HashMap<String, String>();
                            params.put("id",id);


                            return params;
                        }
                    };
                    queue.add(request);


                }

                else {

                    Toast.makeText(OtpActivity.this, "Ragister UnSuccessfully", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }
}