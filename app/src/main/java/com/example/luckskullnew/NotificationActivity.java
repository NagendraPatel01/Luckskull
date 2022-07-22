package com.example.luckskullnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.luckskullnew.Adapter.NotificationAdapter;
import com.example.luckskullnew.Model.NotificationModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationActivity extends AppCompatActivity {
    ImageView img;
    RecyclerView recycle;

    String url = "https://luckskull.com/api/my-notification";
    RequestQueue queue;
    StringRequest request;
    List<NotificationModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        img=findViewById(R.id.img);
        recycle=findViewById(R.id.recycle);
        list = new ArrayList<>();

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationActivity.this.finish();
            }
        });



        queue= Volley.newRequestQueue(this);
        request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("lksfjoisfjois", "duhhisdukvds"+response);
                try {
                    JSONArray jsonArray=new JSONArray(response);

                    for (int i=0; i<jsonArray.length(); i++){
                        NotificationModel notificationModel = new NotificationModel();
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                       notificationModel.setMessage(jsonObject.getString("message"));
                       notificationModel.setCreated_at(jsonObject.getString("created_at"));
                        list.add(notificationModel);

                    }

                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(NotificationActivity.this, RecyclerView.VERTICAL, false);
                    recycle.setLayoutManager(linearLayoutManager);
                    NotificationAdapter adapter = new NotificationAdapter(NotificationActivity.this,list);
                    recycle.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("hietijerhgiek", "usfhuiegik"+error.getMessage());

            }
        }){
            @Override
            public Map<String, String> getHeaders(){

                SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
                String phonenumber = sharedPreferences.getString("numberte", "");

                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Authorization", "Bearer 6209265435");
                return headers;
            }
        };
        queue.add(request);
    }
}