package com.rachel.attendance.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rachel.attendance.AllRecordsFragment;
import com.rachel.attendance.Models.AllCompletedClassModel;
import com.rachel.attendance.R;

import java.util.ArrayList;

public class AllCompletedClassAdapter extends RecyclerView.Adapter<AllCompletedClassAdapter.ViewHolder> {
    Context context;
    ArrayList<AllCompletedClassModel>list;

    public AllCompletedClassAdapter(Context context, ArrayList<AllCompletedClassModel> list, AllRecordsFragment allRecordsFragment) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AllCompletedClassAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.all_attendace_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull AllCompletedClassAdapter.ViewHolder holder, int position) {
        final AllCompletedClassModel s = list.get(position);
        holder.title.setText(s.getTitle());
        holder.day.setText(s.getDay());
        holder.subject.setText(s.getSubject());
        holder.status.setText(s.getStatus());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView subject;
        TextView day;
        TextView status;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            subject = itemView.findViewById(R.id.subject);
            day = itemView.findViewById(R.id.dayTxt);
            status = itemView.findViewById(R.id.status);
        }
    }
}
