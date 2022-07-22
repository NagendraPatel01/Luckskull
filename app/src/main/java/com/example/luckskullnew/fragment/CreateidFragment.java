package com.example.luckskullnew.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.luckskullnew.Adapter.CreateIdAdapter;
import com.example.luckskullnew.Model.CreateIdModel;
import com.example.luckskullnew.R;
import com.example.luckskullnew.RagisterActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class CreateidFragment extends Fragment {

    RecyclerView recycle;
    String url = "https://luckskull.com/api/website";
    RequestQueue queue;
    ProgressBar progress;
    StringRequest request;
    List<CreateIdModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_createid, container, false);

        recycle=view.findViewById(R.id.recycle);
        progress=view.findViewById(R.id.progress);
        list = new ArrayList<>();

     /*  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recycle.setLayoutManager(linearLayoutManager);
        CreateIdAdapter adapter = new CreateIdAdapter(getContext());
      recycle.setAdapter(adapter);*/

        progress.setVisibility(View.VISIBLE);
        queue= Volley.newRequestQueue(getContext());
        request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                progress.setVisibility(View.GONE);
                Log.d("huewgufweg", "idugidgie"+response);
                try {
                    JSONArray jsonArray=new JSONArray(response);


                    for (int i=0; i<jsonArray.length(); i++){
                        CreateIdModel createIdModel = new CreateIdModel();
                        JSONObject jsonObject=jsonArray.getJSONObject(i);

                        createIdModel.setId(jsonObject.getString("id"));
                        createIdModel.setName(jsonObject.getString("name"));
                        createIdModel.setDemoid(jsonObject.getString("demoid"));
                        createIdModel.setDemopassword(jsonObject.getString("demopassword"));
                        createIdModel.setImageurl(jsonObject.getString("imageurl"));
                        createIdModel.setWebsiteurl(jsonObject.getString("websiteurl"));
                        createIdModel.setCreated_at(jsonObject.getString("created_at"));
                        createIdModel.setCreated_at(jsonObject.getString("updated_at"));

                        list.add(createIdModel);
                    }


                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                    recycle.setLayoutManager(linearLayoutManager);
                    Log.d("huifiuehg", "kjghfigejhikj"+list);
                    CreateIdAdapter adapter = new CreateIdAdapter(getContext(),list);
                    recycle.setAdapter(adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
        return view;
    }
}