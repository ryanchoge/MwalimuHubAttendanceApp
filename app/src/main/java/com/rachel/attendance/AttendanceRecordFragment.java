package com.rachel.attendance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rachel.attendance.Adapters.TeacherAdapter;
import com.rachel.attendance.Adapters.WeekdayRecordsAdapter;
import com.rachel.attendance.Models.TeacherModel;
import com.rachel.attendance.Models.WeekdayRecords;
import com.rachel.attendance.databinding.FragmentAttendanceRecordBinding;
import com.rachel.attendance.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class AttendanceRecordFragment extends Fragment {
    private FragmentAttendanceRecordBinding binding;
    RecyclerView  recordsRV;
    ArrayList<WeekdayRecords> weekdayRecords;
    WeekdayRecordsAdapter  weekdayRecordsAdapter;
    TextView headerTextview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAttendanceRecordBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recordsRV = root.findViewById(R.id.recordsRV);
        headerTextview= root.findViewById(R.id.textView5);
        Bundle args = getArguments();
        if (args != null) {
            String textValue = args.getString("textValue");
            headerTextview.setText(textValue);
        }
        // Create and populate the teacherModels list
        weekdayRecords = new ArrayList<>();
        weekdayRecords.addAll(Arrays.asList(
                new WeekdayRecords("31/05/2023","Missed","Biology"),
                new WeekdayRecords("31/05/2023","Attended","Kiswahili"),
                new WeekdayRecords("31/05/2023","Missed","English"),
                new WeekdayRecords("31/05/2023","Attended","History"),
                new WeekdayRecords("31/05/2023","Missed","Chemistry"),
                new WeekdayRecords("31/05/2023","Attended","CRE"),
                new WeekdayRecords("30/05/2023","Attended","Biology"),
                new WeekdayRecords("30/05/2023","Attended","English"),
                new WeekdayRecords("30/05/2023","Attended","Kiswahili"),
                new WeekdayRecords("29/05/2023","Attended","Biology"),
                new WeekdayRecords("29/05/2023","Missed","English"),
                new WeekdayRecords("29/05/2023","Missed","Kiswahili")

        ));

        weekdayRecordsAdapter = new WeekdayRecordsAdapter(getActivity(), weekdayRecords, this);
        recordsRV.setAdapter(weekdayRecordsAdapter);
        recordsRV.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        recordsRV.setHasFixedSize(true);
        recordsRV.setNestedScrollingEnabled(false);
        return root;
    }
}