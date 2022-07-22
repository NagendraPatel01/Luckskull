package com.example.luckskullnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ChangePasswordActivity extends AppCompatActivity {

    TextInputEditText conformpassword;
    ImageView img;
    EditText edit;
    CardView cardview;
    String url1 = "https://luckskull.com/api/update-password";
    RequestQueue queue;
    StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        img=findViewById(R.id.img);
        edit=findViewById(R.id.edit);
        conformpassword=findViewById(R.id.conformpassword);
        cardview=findViewById(R.id.cardview);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangePasswordActivity.this.finish();
            }
        });

        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(edit.getText().toString())){
                    Toast.makeText(ChangePasswordActivity.this, "Enter pphonenumber", Toast.LENGTH_SHORT).show();
                }

                else if (TextUtils.isEmpty(conformpassword.getText().toString())){
                    Toast.makeText(ChangePasswordActivity.this, "Enter conform password", Toast.LENGTH_SHORT).show();
                }

                else {
                            queue = Volley.newRequestQueue(ChangePasswordActivity.this);
                            request=new StringRequest(Request.Method.POST,url1, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.d("sdufghiudghiu", "iudghiuegheru"+response);

                                    try {
                                        JSONObject jsonObject=new JSONObject(response);
                                        String update=jsonObject.getString("message");
                                        Toast.makeText(ChangePasswordActivity.this,update, Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(ChangePasswordActivity.this,DashboaedActivity.class);
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
                                    params.put("phone",edit.getText().toString());
                                    params.put("password",conformpassword.getText().toString());
                                    return params;
                                }
                            };
                            queue.add(request);
                }
            }
        });
    }
}