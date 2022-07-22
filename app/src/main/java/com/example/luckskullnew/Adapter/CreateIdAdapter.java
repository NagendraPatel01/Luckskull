package com.example.luckskullnew.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.luckskullnew.CreateidOneActivity;
import com.example.luckskullnew.Model.CreateIdModel;
import com.example.luckskullnew.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CreateIdAdapter extends RecyclerView.Adapter<CreateIdAdapter.ViewHolder>{
    Context context;
    List<CreateIdModel>list;

    public CreateIdAdapter(Context context, List<CreateIdModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.text1.setText(list.get(position).getName());
        holder.text2.setText(list.get(position).getWebsiteurl());
        holder.text3.setText(list.get(position).getDemoid());
        holder.text4.setText(list.get(position).getDemopassword());
        Glide.with(context).load(""+list.get(position).getImageurl()).into(holder.img);

        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (holder.card.getVisibility() == View.VISIBLE){
                    holder.card.setVisibility(View.GONE);
                }else {
                    holder.card.setVisibility(View.VISIBLE);
                }


                Intent intent=new Intent(context, CreateidOneActivity.class);
                intent.putExtra("nam",list.get(position).getName());
                intent.putExtra("imgurl",list.get(position).getImageurl());
                intent.putExtra("weburl",list.get(position).getWebsiteurl());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder {

        TextView text,text1,text2,text3,text4;
        CardView card;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            text=itemView.findViewById(R.id.text);
            card=itemView.findViewById(R.id.card);
            text1=itemView.findViewById(R.id.text1);
            text2=itemView.findViewById(R.id.text2);
            text3=itemView.findViewById(R.id.text3);
            text4=itemView.findViewById(R.id.text4);
            img=itemView.findViewById(R.id.img);
        }
    }


}
