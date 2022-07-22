package com.example.luckskullnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    CardView cardview;
    EditText phone_number;
    ProgressBar progress;

    String url = "https://luckskull.com/api/user-auth";
    RequestQueue queue;
    StringRequest request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardview=findViewById(R.id.cardview);
        phone_number=findViewById(R.id.phone_number);
        progress=findViewById(R.id.progress);

        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(phone_number.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Enter Mobile no", Toast.LENGTH_SHORT).show();
                }

                else {

                    progress.setVisibility(View.VISIBLE);
                    queue = Volley.newRequestQueue(MainActivity.this);
                    request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("iuhreteuir", "8y7eyt7er"+response);
                            progress.setVisibility(View.GONE);

                            try {
                                JSONObject object=new JSONObject(response);
                                String message = object.getString("message");
                                boolean status = object.getBoolean("status");
                                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

                                if (status){

                                   Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                                   intent.putExtra("textvire",phone_number.getText().toString());
                                   startActivity(intent);



                                }else {


                                    Intent intent=new Intent(MainActivity.this,RagisterActivity.class);
                                    intent.putExtra("textvire",phone_number.getText().toString());
                                    startActivity(intent);


                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("ghiuerhieor", "ertjoieryjori"+error);

                        }
                    }){

                        @Override
                        protected Map<String, String> getParams() {
                            Map<String,String> params = new HashMap<String, String>();
                            params.put("phone_number",phone_number.getText().toString());

                            return params;
                        }
                    };
                    queue.add(request);

                }
            }
        });


    }

}