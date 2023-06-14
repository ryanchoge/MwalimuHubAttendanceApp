package com.rachel.attendance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rachel.attendance.Adapters.TeacherAdapter;
import com.rachel.attendance.Adapters.TscFeedAdapter;
import com.rachel.attendance.Models.TeacherModel;
import com.rachel.attendance.Models.TscFeedModel;
import com.rachel.attendance.databinding.FragmentNewsFeedBinding;
import com.rachel.attendance.databinding.FragmentTscFeedsBinding;

import java.util.ArrayList;

public class TscFeedsFragment extends Fragment {

    private FragmentTscFeedsBinding binding;
    RecyclerView tscFeedRv;
    ArrayList<TscFeedModel> tscFeedModel;
    TscFeedAdapter tscFeedAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTscFeedsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        tscFeedRv = root.findViewById(R.id.tscFeedsRV);
        /// recyclerview
        tscFeedModel =new ArrayList<>();
        tscFeedModel.add(new TscFeedModel( "Prudence M","2 days ago","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incidid"));
        tscFeedModel.add(new TscFeedModel( "Prudence M","2 days ago","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incidid"));
        tscFeedModel.add(new TscFeedModel( "Prudence M","2 days ago","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incidid"));
        tscFeedModel.add(new TscFeedModel( "Prudence M","2 days ago","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incidid"));
        tscFeedModel.add(new TscFeedModel( "Prudence M","2 days ago","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incidid"));
        tscFeedModel.add(new TscFeedModel( "Prudence M","2 days ago","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incidid"));
        tscFeedModel.add(new TscFeedModel( "Prudence M","2 days ago","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incidid"));
        tscFeedModel.add(new TscFeedModel( "Prudence M","2 days ago","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incidid"));

        tscFeedAdapter = new TscFeedAdapter(getActivity(), tscFeedModel, this);
        tscFeedRv.setAdapter(tscFeedAdapter);
        tscFeedRv.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL, false));
        tscFeedRv.setHasFixedSize(true);
        tscFeedRv.setNestedScrollingEnabled(false);

        return root;
    }
}