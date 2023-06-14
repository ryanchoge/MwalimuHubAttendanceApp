package com.rachel.attendance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rachel.attendance.Adapters.SubjectAdapter;
import com.rachel.attendance.Adapters.UpcomingCAdapter;
import com.rachel.attendance.Models.SubjectModel;
import com.rachel.attendance.Models.UpcomingCModel;
import com.rachel.attendance.databinding.FragmentTscFeedsBinding;
import com.rachel.attendance.databinding.FragmentUpcomingWCBinding;

import java.util.ArrayList;

public class UpcomingWCFragment extends Fragment {

    private FragmentUpcomingWCBinding binding;
    RecyclerView upcomingRec;
    ArrayList<UpcomingCModel> upcomingCModels;
    UpcomingCAdapter upcomingCAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUpcomingWCBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        upcomingRec = root.findViewById(R.id.upcomingWeekly);
        /// recyclerview
        upcomingCModels =new ArrayList<>();
        upcomingCModels.add(new UpcomingCModel( "Monday","Biology","8:00 AM"));
        upcomingCModels.add(new UpcomingCModel( "Tuesday","Biology","8:00 AM"));
        upcomingCModels.add(new UpcomingCModel( "Wednesday","Biology","8:00 AM"));
        upcomingCModels.add(new UpcomingCModel( "Thursday","Biology","8:00 AM"));
        upcomingCModels.add(new UpcomingCModel( "Friday","Biology","8:00 AM"));

        upcomingCAdapter = new UpcomingCAdapter(getActivity(), upcomingCModels);
        upcomingRec.setAdapter(upcomingCAdapter);
        upcomingRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL, false));
        upcomingRec.setHasFixedSize(true);
        upcomingRec.setNestedScrollingEnabled(false);

        return root;
    }
}