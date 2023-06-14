package com.rachel.attendance.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.rachel.attendance.AttendanceRecordFragment;
import com.rachel.attendance.Models.WeekdayRecords;
import com.rachel.attendance.R;

import java.util.ArrayList;

public class WeekdayRecordsAdapter extends RecyclerView.Adapter<WeekdayRecordsAdapter.ViewHolder> {
    Context context;
    ArrayList<WeekdayRecords>list;

    public WeekdayRecordsAdapter(Context context, ArrayList<WeekdayRecords> list, AttendanceRecordFragment attendanceRecordFragment) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public WeekdayRecordsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_record_items,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull WeekdayRecordsAdapter.ViewHolder holder, int position) {
        final WeekdayRecords s = list.get(position);
        holder.date.setText(s.getDay());
        holder.subject.setText(s.getSubject());

        // Set the text and color for the status TextView based on the response
        String status = s.getStatus();
        holder.status.setText(status);
        if (status.equals("Missed")) {
            holder.status.setTextColor(ContextCompat.getColor(context, R.color.red)); // Set red color
        } else if (status.equals("Attended")) {
            holder.status.setTextColor(ContextCompat.getColor(context, R.color.green)); // Set green color
        } else {
            holder.status.setTextColor(ContextCompat.getColor(context, R.color.white)); // Set default color
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView date;
        TextView subject;
        TextView status;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.dateText);
            subject = itemView.findViewById(R.id.subjectText);
            status = itemView.findViewById(R.id.statusText);
        }
    }
}
