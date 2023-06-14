package com.rachel.attendance.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rachel.attendance.Models.UpcomingCModel;
import com.rachel.attendance.R;
import com.rachel.attendance.UpcomingWCFragment;

import java.util.ArrayList;


public class UpcomingCAdapter extends RecyclerView.Adapter<UpcomingCAdapter.ViewHolder> {
    Context context;
    ArrayList<UpcomingCModel>list;

    public UpcomingCAdapter(Context context, ArrayList<UpcomingCModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public UpcomingCAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingCAdapter.ViewHolder holder, int position) {
        final UpcomingCModel s = list.get(position);
        holder.day.setText(s.getDay());
        holder.time.setText(s.getTime());
        holder.subject.setText(s.getSubject());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView day;
        TextView subject;
        TextView time;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.textView16);
            subject = itemView.findViewById(R.id.textView17);
            time = itemView.findViewById(R.id.timeTxt);

        }
    }
}
