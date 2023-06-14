package com.rachel.attendance.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rachel.attendance.Models.TTSubjectModel;
import com.rachel.attendance.R;

import java.util.ArrayList;

public class TTSubjectAdapter extends RecyclerView.Adapter<TTSubjectAdapter.ViewHolder> {
    Context context;
    ArrayList<TTSubjectModel>list;

    public TTSubjectAdapter(Context context, ArrayList<TTSubjectModel> list, Context context1) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TTSubjectAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.timetable_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TTSubjectAdapter.ViewHolder holder, int position) {
        final TTSubjectModel s = list.get(position);
        holder.Subject.setText(s.getTitle());
        holder.time.setText(s.getTime());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Subject;
        TextView time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Subject = itemView.findViewById(R.id.textView17);
            time = itemView.findViewById(R.id.timeTxt);
        }
    }
}
