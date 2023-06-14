package com.rachel.attendance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rachel.attendance.Adapters.TeacherAdapter;
import com.rachel.attendance.Models.TeacherModel;
import com.rachel.attendance.databinding.FragmentHomeBinding;
import com.rachel.attendance.databinding.FragmentTeachersBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class TeachersFragment extends Fragment implements FragmentInterface{

    RecyclerView teacherRec;
    ArrayList<TeacherModel> teacherModels;
    TeacherAdapter teacherAdapter;

    private FragmentTeachersBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTeachersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        teacherRec = root.findViewById(R.id.teachersRV);
        // Create and populate the teacherModels list
        teacherModels = new ArrayList<>();
        teacherModels.addAll(Arrays.asList(
                new TeacherModel("Prudence M"),
                new TeacherModel("Prudence M"),
                new TeacherModel("Prudence M"),
                new TeacherModel("Prudence M"),
                new TeacherModel("Prudence M"),
                new TeacherModel("Prudence M"),
                new TeacherModel("Prudence M"),
                new TeacherModel("Moses M"),
                new TeacherModel("Moses M"),
                new TeacherModel("Moses M"),
                new TeacherModel("Moses M"),
                new TeacherModel("Moses M"),
                new TeacherModel("Moses M")
        ));

        teacherAdapter = new TeacherAdapter(getActivity(), teacherModels, getChildFragmentManager());
        teacherRec.setAdapter(teacherAdapter);
        teacherRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        teacherRec.setHasFixedSize(true);
        teacherRec.setNestedScrollingEnabled(false);

        return root;
    }

    @Override
    public String getFragmentTitle() {
        return "Teachers"; // Return the desired title for HomeFragment
    }
}