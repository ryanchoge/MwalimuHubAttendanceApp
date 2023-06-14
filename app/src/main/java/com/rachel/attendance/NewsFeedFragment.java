package com.rachel.attendance;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rachel.attendance.databinding.FragmentHomeBinding;
import com.rachel.attendance.databinding.FragmentNewsFeedBinding;

public class NewsFeedFragment extends Fragment implements FragmentInterface {
    private FragmentNewsFeedBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentNewsFeedBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //Tsc messages
        binding.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace the current fragment with a new fragment
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, new TscFeedsFragment()) // Replace with your desired fragment
                        .addToBackStack(null)
                        .commit();

            }
        });
        //Internal Memo
        binding.cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace the current fragment with a new fragment
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, new TscFeedsFragment()) // Replace with your desired fragment
                        .addToBackStack(null)
                        .commit();

            }
        });


        return root;
    }

    @Override
    public String getFragmentTitle() {
        return "News Feed"; // Return the desired title for HomeFragment
    }
}