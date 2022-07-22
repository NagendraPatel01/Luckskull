package com.example.luckskullnew.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.luckskullnew.Model.MyidModel;
import com.example.luckskullnew.R;

import java.util.List;

public class MyidAdapter extends RecyclerView.Adapter<MyidAdapter.ViewHolder> {

    Context context;
    List<MyidModel> list;

    public MyidAdapter(Context context, List<MyidModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.myiddesign,parent,false);
        return new MyidAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.text3.setText(list.get(position).getSiteurl());
        holder.text4.setText(list.get(position).getUserphone());
        holder.text5.setText(list.get(position).getUserid());
        holder.text6.setText(list.get(position).getPassword());
        holder.text7.setText(list.get(position).getAmount());
        holder.text8.setText(list.get(position).getCreated_at());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView text1,text2,text3,text4,text5,text6,text7,text8;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            text1=itemView.findViewById(R.id.text1);
            text2=itemView.findViewById(R.id.text2);
            text3=itemView.findViewById(R.id.text3);
            text4=itemView.findViewById(R.id.text4);
            text5=itemView.findViewById(R.id.text5);
            text6=itemView.findViewById(R.id.text6);
            text7=itemView.findViewById(R.id.text7);
            text8=itemView.findViewById(R.id.text8);
        }
    }
}
