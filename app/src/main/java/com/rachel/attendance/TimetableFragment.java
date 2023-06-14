package com.rachel.attendance;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rachel.attendance.Adapters.CalendarAdapter;
import com.rachel.attendance.Adapters.TTSubjectAdapter;
import com.rachel.attendance.Adapters.TeacherAdapter;
import com.rachel.attendance.Models.CalendarModel;
import com.rachel.attendance.Models.TTSubjectModel;
import com.rachel.attendance.Models.TeacherModel;
import com.rachel.attendance.databinding.FragmentNewsFeedBinding;
import com.rachel.attendance.databinding.FragmentTimetableBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TimetableFragment extends Fragment implements CalendarAdapter.OnDateClickListener {
    private FragmentTimetableBinding binding;
    private TextView selectedDateTextView;
    RecyclerView ttSubjectsRV;
    ArrayList<TTSubjectModel> ttSubjectModels;
    TTSubjectAdapter ttSubjectAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTimetableBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        RecyclerView calendarRecyclerView = root.findViewById(R.id.calendarRecyclerView);
        selectedDateTextView = root.findViewById(R.id.selectedDateTextView);
        List<CalendarModel> calendarList = new ArrayList<>();

        // Populate the calendarList with the necessary day and date information
        // You can customize this based on your calendar requirements
        Calendar calendar = Calendar.getInstance();

        for (int i = 0; i < 7; i++) { // Display 7 days starting from today
            String formattedDate = formatDate(calendar.getTime());
            calendarList.add(new CalendarModel(formattedDate, calendar.getTime(), false));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }


        CalendarAdapter calendarAdapter = new CalendarAdapter(requireContext(), calendarList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
        ttSubjectsRV = root.findViewById(R.id.SubjectsRV);
        /// recyclerview
        ttSubjectModels =new ArrayList<>();
        ttSubjectModels.add(new TTSubjectModel( "Biology","08:00AM - 10:00AM"));
        ttSubjectModels.add(new TTSubjectModel( "Maths","10:00AM - 11:00AM"));
        ttSubjectModels.add(new TTSubjectModel( "Physics","02:00PM - 03:00PM"));

        ttSubjectAdapter = new TTSubjectAdapter(getActivity(), ttSubjectModels, getContext());
        ttSubjectsRV.setAdapter(ttSubjectAdapter);
        ttSubjectsRV.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL, false));
        ttSubjectsRV.setHasFixedSize(true);
        ttSubjectsRV.setNestedScrollingEnabled(false);

        return root;
    }

    // Method to format the date in the desired format
    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM EEEE", Locale.US);
        return dateFormat.format(date);
    }

    @Override
    public void onDateClick(String selectedDate) {
        selectedDateTextView.setText(selectedDate);
    }
}
