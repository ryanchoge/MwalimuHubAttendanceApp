package com.rachel.attendance;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rachel.attendance.Adapters.SubjectAdapter;
import com.rachel.attendance.Models.SubjectModel;
import com.rachel.attendance.databinding.FragmentHomeBinding;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements FragmentInterface {
   private FragmentHomeBinding binding;
    RecyclerView subjectRec;
    ArrayList<SubjectModel> subjectModels;
    SubjectAdapter subjectAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        subjectRec = root.findViewById(R.id.upcoming_subjects);
        /// recyclerview
        subjectModels =new ArrayList<>();
        subjectModels.add(new SubjectModel( "Biology","Excretion and Homeostasis","10:00 -10:30 AM"));

        subjectAdapter = new SubjectAdapter(getActivity(), subjectModels, this);
        subjectRec.setAdapter(subjectAdapter);
        subjectRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL, false));
        subjectRec.setHasFixedSize(true);
        subjectRec.setNestedScrollingEnabled(false);
        binding.classes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textValue = binding.classes.getText().toString();

                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                Fragment fragment = new ExtraFragment();
                Bundle args = new Bundle();
                args.putString("textValue", textValue);
                fragment.setArguments(args);

                fragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, fragment) // Replace with your desired fragment
                        .addToBackStack(null)
                        .commit();
            }
        });
        binding.extraTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textValue = binding.extraTxt.getText().toString();

                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                Fragment fragment = new ExtraFragment();
                Bundle args = new Bundle();
                args.putString("textValue", textValue);
                fragment.setArguments(args);

                fragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, fragment) // Replace with your desired fragment
                        .addToBackStack(null)
                        .commit();
            }
        });
        binding.textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textValue = binding.textView8.getText().toString();

                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                Fragment fragment = new AttendanceRecordFragment();
                Bundle args = new Bundle();
                args.putString("textValue", textValue);
                fragment.setArguments(args);

                fragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, fragment) // Replace with your desired fragment
                        .addToBackStack(null)
                        .commit();
            }
        });
        binding.textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textValue = binding.textView9.getText().toString();

                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                Fragment fragment = new AttendanceRecordFragment();
                Bundle args = new Bundle();
                args.putString("textValue", textValue);
                fragment.setArguments(args);

                fragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, fragment) // Replace with your desired fragment
                        .addToBackStack(null)
                        .commit();
            }
        });
        binding.textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textValue = binding.textView10.getText().toString();

                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                Fragment fragment = new AttendanceRecordFragment();
                Bundle args = new Bundle();
                args.putString("textValue", textValue);
                fragment.setArguments(args);

                fragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, fragment) // Replace with your desired fragment
                        .addToBackStack(null)
                        .commit();
            }
        });
        binding.swapped.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textValue = binding.swapped.getText().toString();

                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                Fragment fragment = new AttendanceRecordFragment();
                Bundle args = new Bundle();
                args.putString("textValue", textValue);
                fragment.setArguments(args);

                fragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, fragment) // Replace with your desired fragment
                        .addToBackStack(null)
                        .commit();
            }
        });

        binding.weekdayTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace the current fragment with a new fragment
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, new UpcomingWCFragment()) // Replace with your desired fragment
                        .addToBackStack(null)
                        .commit();
            }
        });
        binding.RemedialTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace the current fragment with a new fragment
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, new ScheRemedialFragment()) // Replace with your desired fragment
                        .addToBackStack(null)
                        .commit();

            }
        });
        binding.textView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace the current fragment with a new fragment
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, new AllRecordsFragment()) // Replace with your desired fragment
                        .addToBackStack(null)
                        .commit();

            }
        });
        return root;
    }

    @Override
    public String getFragmentTitle() {
        return "My Classes"; // Return the desired title for HomeFragment
    }
}
