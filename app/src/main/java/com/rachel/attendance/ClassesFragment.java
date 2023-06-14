package com.rachel.attendance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rachel.attendance.Adapters.ClassesAdapter;
import com.rachel.attendance.Adapters.ScheduledRemAdapter;
import com.rachel.attendance.Models.ClassesModel;
import com.rachel.attendance.Models.ScheduledRemModel;
import com.rachel.attendance.databinding.FragmentClassesBinding;
import com.rachel.attendance.databinding.FragmentScheRemedialBinding;

import java.util.ArrayList;


public class ClassesFragment extends Fragment {
    private FragmentClassesBinding binding;
    RecyclerView classesRv;
    ArrayList<ClassesModel> classesModels;
    ClassesAdapter classesAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentClassesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        classesRv = root.findViewById(R.id.classesRV);
        /// recyclerview
        classesModels =new ArrayList<>();
        classesModels.add(new ClassesModel( "Form 1 South","Biology\n\nKiswahili\n\nEnglish"));
        classesModels.add(new ClassesModel( "Form 1 North","Biology\n\nKiswahili\n\nEnglish"));
        classesModels.add(new ClassesModel( "Form 2 South","Biology\n\nKiswahili\n\nEnglish"));
        classesModels.add(new ClassesModel( "Form 3 West","Biology\n\nKiswahili\n\nEnglish"));
        classesModels.add(new ClassesModel( "Form 4 East","Biology\n\nKiswahili\n\nEnglish"));

        classesAdapter = new ClassesAdapter(getActivity(), classesModels, this);
        classesRv.setAdapter(classesAdapter);
        classesRv.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL, false));
        classesRv.setHasFixedSize(true);
        classesRv.setNestedScrollingEnabled(false);

        return root;
    }
}