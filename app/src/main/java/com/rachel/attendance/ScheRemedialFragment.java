package com.rachel.attendance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rachel.attendance.Adapters.ScheduledRemAdapter;
import com.rachel.attendance.Adapters.UpcomingCAdapter;
import com.rachel.attendance.Models.ScheduledRemModel;
import com.rachel.attendance.Models.UpcomingCModel;
import com.rachel.attendance.databinding.FragmentScheRemedialBinding;
import com.rachel.attendance.databinding.FragmentUpcomingWCBinding;

import java.util.ArrayList;


public class ScheRemedialFragment extends Fragment {
    private FragmentScheRemedialBinding binding;
    RecyclerView scheduledRv;
    ArrayList<ScheduledRemModel> scheduledRemModels;
    ScheduledRemAdapter scheduledRemAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentScheRemedialBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        scheduledRv = root.findViewById(R.id.scheduledRV);
        /// recyclerview
        scheduledRemModels =new ArrayList<>();
        scheduledRemModels.add(new ScheduledRemModel( "Saturday","Biology","8:00 AM"));
        scheduledRemModels.add(new ScheduledRemModel( "Tuesday","Biology","8:00 AM"));
        scheduledRemModels.add(new ScheduledRemModel( "Sunday","Biology","8:00 AM"));
        scheduledRemModels.add(new ScheduledRemModel( "Saturday","Biology","8:00 AM"));
        scheduledRemModels.add(new ScheduledRemModel( "Saturday","Biology","8:00 AM"));
        scheduledRemModels.add(new ScheduledRemModel( "Sunday","Biology","8:00 AM"));
        scheduledRemModels.add(new ScheduledRemModel( "Friday","Biology","8:00 AM"));
        scheduledRemModels.add(new ScheduledRemModel( "Sunday","Biology","8:00 AM"));

        scheduledRemAdapter = new ScheduledRemAdapter(getActivity(), scheduledRemModels, this);
        scheduledRv.setAdapter(scheduledRemAdapter);
        scheduledRv.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL, false));
        scheduledRv.setHasFixedSize(true);
        scheduledRv.setNestedScrollingEnabled(false);

        return root;
    }
}