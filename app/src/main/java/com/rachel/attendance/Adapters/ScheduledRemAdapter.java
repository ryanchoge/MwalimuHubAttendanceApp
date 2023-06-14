package com.rachel.attendance.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rachel.attendance.Models.ScheduledRemModel;
import com.rachel.attendance.R;
import com.rachel.attendance.ScheRemedialFragment;

import java.util.ArrayList;


public class ScheduledRemAdapter extends RecyclerView.Adapter<ScheduledRemAdapter.ViewHolder> {
    Context context;
    ArrayList<ScheduledRemModel>list;

    public ScheduledRemAdapter(Context context, ArrayList<ScheduledRemModel> list, ScheRemedialFragment scheRemedialFragment) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ScheduledRemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduledRemAdapter.ViewHolder holder, int position) {
        final ScheduledRemModel s = list.get(position);
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
