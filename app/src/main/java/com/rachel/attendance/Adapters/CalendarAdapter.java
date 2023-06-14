package com.rachel.attendance.Adapters;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rachel.attendance.Models.CalendarModel;
import com.rachel.attendance.R;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {
    private List<CalendarModel> calendarList;
    private Context context;
    private OnDateClickListener onDateClickListener;
    private SimpleDateFormat dateFormat;

    public CalendarAdapter(Context context, List<CalendarModel> calendarList, OnDateClickListener onDateClickListener) {
        this.context = context;
        this.calendarList = calendarList;
        this.onDateClickListener = onDateClickListener;
        this.dateFormat = new SimpleDateFormat("dd MMM EEEE", Locale.US);

        // Find today's date and set its isSelected field to true
        Calendar todayCalendar = Calendar.getInstance();
        for (CalendarModel model : calendarList) {
            if (isSameDate(model.getDate(), todayCalendar.getTime())) {
                model.setSelected(true);
                break;
            }
        }
    }

    private boolean isSameDate(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
                cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_calendar_day, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CalendarModel calendarModel = calendarList.get(position);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd", Locale.getDefault());
        String formattedDate = dateFormat.format(calendarModel.getDate());
        holder.dateTextView.setText(formattedDate);

        SimpleDateFormat dayFormat = new SimpleDateFormat("EEE", Locale.getDefault());
        String formattedDay = dayFormat.format(calendarModel.getDate());
        holder.dayTextView.setText(formattedDay);

        // Set background based on the selected state
        if (calendarModel.isSelected()) {
            holder.itemView.setBackgroundResource(R.drawable.selected_background);
        } else {
            holder.itemView.setBackgroundResource(R.drawable.default_background);
        }

        // Set click listener for the calendar item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update the selected state of the clicked item
                for (CalendarModel model : calendarList) {
                    model.setSelected(false); // Reset all other items
                }
                calendarModel.setSelected(true); // Set clicked item as selected

                // Notify the adapter that the data has changed
                notifyDataSetChanged();

                // Handle calendar item click
                // Fetch the day's teacher lessons or perform any other action
                // You can pass the necessary information from the calendarModel
                Date selectedDate = calendarModel.getDate(); // Get the selected date
                String formattedDate = calendarModel.getFormattedDate(); // Get the formatted date
                onDateClickListener.onDateClick(formattedDate); // Call the interface method and pass the formatted date
            }
        });

    }

    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yy", Locale.getDefault());
        return sdf.format(date);
    }


    @Override
    public int getItemCount() {
        return calendarList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dateTextView;
        TextView dayTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            dayTextView = itemView.findViewById(R.id.dayTextView);
        }
    }

    // Interface for click events on calendar items
    public interface OnDateClickListener {
        void onDateClick(String selectedDate);
    }
}
