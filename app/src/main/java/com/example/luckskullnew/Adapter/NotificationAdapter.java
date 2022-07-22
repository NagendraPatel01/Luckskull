package com.example.luckskullnew.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.luckskullnew.Model.NotificationModel;
import com.example.luckskullnew.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    Context context;
    List<NotificationModel> list;

    public NotificationAdapter(Context context, List<NotificationModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.notificationdesign, parent, false);
        return new NotificationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       /* holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.linear.getVisibility() == View.VISIBLE){
                    holder.linear.setVisibility(View.GONE);
                }else {
                    holder.linear.setVisibility(View.VISIBLE);
                }

            }
        });*/

        String current = new SimpleDateFormat("dd MMM yyyy hh:mm a").format(Calendar.getInstance().getTime());

        String date2 = convertUtc3Local(list.get(position).getCreated_at());
        String date = convertUtc2Local(list.get(position).getCreated_at());

        Log.d("smhxbsjxs", "onBindViewHolder: "+date);
        Log.d("smhxbsjxs", "onBindViewHolder: "+current);


        try {
            Date start = new SimpleDateFormat("dd MMM yyy", Locale.ENGLISH)
                    .parse(current);

            Date end = new SimpleDateFormat("dd MMM yyy", Locale.ENGLISH)
                    .parse(date);

            if (start.compareTo(end) == 0) {
                holder.text.setText(date2);
            }else {
                holder.text.setText(date);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }



        holder.text1.setText(list.get(position).getMessage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        /* ImageView img;
         LinearLayout linear;*/
        TextView text, text1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

          /*  img=itemView.findViewById(R.id.img);
            linear=itemView.findViewById(R.id.linear);*/
            text = itemView.findViewById(R.id.text);
            text1 = itemView.findViewById(R.id.text1);
        }

    }

    public static String convertUtc2Local(String utcTime) {
        String time = "";
        if (utcTime != null) {
            SimpleDateFormat utcFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            utcFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date gpsUTCDate = null;//from  ww  w.j  a va 2 s  . c  o  m
            try {
                gpsUTCDate = utcFormatter.parse(utcTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            SimpleDateFormat localFormatter = new SimpleDateFormat("dd MMM yyyy hh:mm a");
            localFormatter.setTimeZone(TimeZone.getDefault());
            assert gpsUTCDate != null;
            time = localFormatter.format(gpsUTCDate.getTime());
        }
        return time;
    }

    public static String convertUtc3Local(String utcTime) {
        String time = "";
        if (utcTime != null) {
            SimpleDateFormat utcFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            utcFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date gpsUTCDate = null;//from  ww  w.j  a va 2 s  . c  o  m
            try {
                gpsUTCDate = utcFormatter.parse(utcTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            SimpleDateFormat localFormatter = new SimpleDateFormat("hh:mm a");
            localFormatter.setTimeZone(TimeZone.getDefault());
            assert gpsUTCDate != null;
            time = localFormatter.format(gpsUTCDate.getTime());
        }
        return time;
    }
}
