package com.rachel.attendance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rachel.attendance.Adapters.UpcomingCAdapter;
import com.rachel.attendance.Models.UpcomingCModel;
import com.rachel.attendance.databinding.FragmentExtraBinding;
import com.rachel.attendance.databinding.FragmentUpcomingWCBinding;

import java.util.ArrayList;

public class ExtraFragment extends Fragment {
    private FragmentExtraBinding binding;
    RecyclerView upcomingRec;
    ArrayList<UpcomingCModel> upcomingCModels;
    UpcomingCAdapter upcomingCAdapter;
    TextView headerTextview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentExtraBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        upcomingRec = root.findViewById(R.id.upcomingWeekly);
        headerTextview= root.findViewById(R.id.textView5);
        Bundle args = getArguments();
        if (args != null) {
            String textValue = args.getString("textValue");
            headerTextview.setText(textValue);
        }
        /// recyclerview
        upcomingCModels =new ArrayList<>();
        upcomingCModels.add(new UpcomingCModel( "Monday","Biology","8:00 AM"));
        upcomingCModels.add(new UpcomingCModel( "Tuesday","Biology","8:00 AM"));
        upcomingCModels.add(new UpcomingCModel( "Wednesday","Biology","8:00 AM"));
        upcomingCModels.add(new UpcomingCModel( "Thursday","Biology","8:00 AM"));
        upcomingCModels.add(new UpcomingCModel( "Friday","Biology","8:00 AM"));

        upcomingCAdapter = new UpcomingCAdapter(getActivity(), upcomingCModels);
        upcomingRec.setAdapter(upcomingCAdapter);
        upcomingRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        upcomingRec.setHasFixedSize(true);
        upcomingRec.setNestedScrollingEnabled(false);

        return root;
    }
}