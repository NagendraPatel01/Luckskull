package com.example.luckskullnew.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.luckskullnew.Adapter.CreateIdAdapter;
import com.example.luckskullnew.Adapter.MyidAdapter;
import com.example.luckskullnew.Model.CreateIdModel;
import com.example.luckskullnew.Model.MyidModel;
import com.example.luckskullnew.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyIdFragment extends Fragment {

    RecyclerView recycle;
    String url = "https://luckskull.com/api/myids";
    RequestQueue queue;
    StringRequest request;
    List<MyidModel> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_id, container, false);

        recycle=view.findViewById(R.id.recycle);
        list = new ArrayList<>();


        queue= Volley.newRequestQueue(getContext());
        request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("ibdsfhisdigu", "ifhgudyfgud"+response);

                try {
                    JSONArray jsonArray=new JSONArray(response);
                    MyidModel myidModel = new MyidModel();

                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject jsonObject=jsonArray.getJSONObject(i);

                        myidModel.setId(jsonObject.getString("id"));
                        myidModel.setPaymentgateway(jsonObject.getString("paymentgateway"));
                        myidModel.setSiteurl(jsonObject.getString("siteurl"));
                        myidModel.setUserphone(jsonObject.getString("userphone"));
                        myidModel.setUserid(jsonObject.getString("userid"));
                        myidModel.setPassword(jsonObject.getString("password"));
                        myidModel.setAmount(jsonObject.getString("amount"));
                        myidModel.setCreated_at(jsonObject.getString("created_at"));

                    }

                    list.add(myidModel);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                    recycle.setLayoutManager(linearLayoutManager);
                    Log.d("huifiuehg", "kjghfigejhikj"+list);
                    MyidAdapter adapter = new MyidAdapter(getContext(),list);
                    recycle.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ibfijwhgi", "jhefgiwehgu"+error.getMessage());

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
        return view;
    }
}