package com.example.luckskullnew;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DepositActivity extends AppCompatActivity {

    ImageView img;
    CardView card;
    EditText edit;
    TextView text;

    String url = "https://luckskull.com/api/get-coins";
    RequestQueue queue;
    StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        img=findViewById(R.id.img);
        card=findViewById(R.id.card);
        edit=findViewById(R.id.edit);
        text=findViewById(R.id.text);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DepositActivity.this.finish();
            }
        });

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(edit.getText().toString())){

                    Toast.makeText(DepositActivity.this, "Please enter coin", Toast.LENGTH_SHORT).show();
                }

                else {

                    Intent intent=new Intent(DepositActivity.this, PaymentMethodActivity.class);
                    intent.putExtra("editcoin",edit.getText().toString());
                    intent.putExtra("type","deposit");
                    startActivity(intent);

                }
            }
        });

        queue= Volley.newRequestQueue(DepositActivity.this);
        request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("hgfjef", "uieytueite"+response);
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String coin =jsonObject.getString("coins");
                    text.setText(coin);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("sdghjsgkjd", "guyfguwefg"+error.getMessage());

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Authorization", "Bearer 6209265435");
                return headers;
            }
        };
        queue.add(request);
    }
}