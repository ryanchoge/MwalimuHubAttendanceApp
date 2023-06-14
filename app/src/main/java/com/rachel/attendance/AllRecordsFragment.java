package com.rachel.attendance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rachel.attendance.Adapters.AllCompletedClassAdapter;
import com.rachel.attendance.Adapters.ClassesAdapter;
import com.rachel.attendance.Models.AllCompletedClassModel;
import com.rachel.attendance.Models.ClassesModel;
import com.rachel.attendance.databinding.FragmentAllRecordsBinding;
import com.rachel.attendance.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class AllRecordsFragment extends Fragment {

    private FragmentAllRecordsBinding binding;
    RecyclerView completedRV;
    ArrayList<AllCompletedClassModel> allCompletedClassModels;
    AllCompletedClassAdapter allCompletedClassAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAllRecordsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        completedRV = root.findViewById(R.id.completedRV);
        /// recyclerview
        allCompletedClassModels =new ArrayList<>();
        allCompletedClassModels.add(new AllCompletedClassModel( "Completed Weekday classes","Monday","Biology\n\nKiswahili\n\nEnglish","Missed\n\nAttended\n\nAttended"));
        allCompletedClassModels.add(new AllCompletedClassModel( "Completed Remedial classes","Wednesday","Biology\n\nKiswahili\n\nEnglish","Missed\n\nAttended\n\nAttended"));
        allCompletedClassModels.add(new AllCompletedClassModel( "Completed Swapped classes","Friday","Biology\n\nKiswahili\n\nEnglish","Missed\n\nAttended\n\nAttended"));
        allCompletedClassModels.add(new AllCompletedClassModel( "Completed Remedial classes","Saturday","Biology\n\nKiswahili\n\nEnglish","Missed\n\nAttended\n\nAttended"));

        allCompletedClassAdapter = new AllCompletedClassAdapter(getActivity(), allCompletedClassModels, this);
        completedRV.setAdapter(allCompletedClassAdapter);
        completedRV.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL, false));
        completedRV.setHasFixedSize(true);
        completedRV.setNestedScrollingEnabled(false);



        return root;
    }
}