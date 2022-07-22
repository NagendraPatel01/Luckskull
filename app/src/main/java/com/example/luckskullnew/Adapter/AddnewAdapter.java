package com.example.luckskullnew.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.luckskullnew.R;

public class AddnewAdapter extends RecyclerView.Adapter<AddnewAdapter.ViewHolder> {

    Context context;

    public AddnewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.addnewdesign,parent,false);
        return new AddnewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SharedPreferences sharedPreferences=context.getSharedPreferences("data",context.MODE_PRIVATE);
        String nam=sharedPreferences.getString("name","");
        String numbr=sharedPreferences.getString("number","");

        holder.addname.setText(nam);
        holder.addnumber.setText(numbr);

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        holder.delet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        EditText addnumber,addname;
        ImageView update,delet;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            addnumber=itemView.findViewById(R.id.addnumber);
            addname=itemView.findViewById(R.id.addname);
            update=itemView.findViewById(R.id.update);
            delet=itemView.findViewById(R.id.delet);
        }
    }
}
