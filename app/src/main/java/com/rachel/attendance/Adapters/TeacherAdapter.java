package com.rachel.attendance.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.rachel.attendance.ChatFragment;
import com.rachel.attendance.Models.TeacherModel;
import com.rachel.attendance.R;
import com.rachel.attendance.SwapFragment;

import java.util.ArrayList;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.ViewHolder> {

    Context context;
    ArrayList<TeacherModel>list;
    FragmentManager fragmentManager;

    public TeacherAdapter(Context context, ArrayList<TeacherModel> list, FragmentManager fragmentManager) {
        this.context = context;
        this.list = list;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public TeacherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.teacher_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull TeacherAdapter.ViewHolder holder, int position) {
        final TeacherModel s = list.get(position);
        holder.name.setText(s.getName());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(context,holder.name);
                popupMenu.inflate(R.menu.flow_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.chat_menu:
                                // Open the chat fragment here
                                openChatFragment();

                                return true;
                            case R.id.swap_menu:
                                // Open the swap fragment here
                                openSwapFragment();

                                return true;
                            default:
                                return false;
                        }
                    }
                });

                popupMenu.show();

            }
        });

    }

    private void openSwapFragment() {
        AppCompatActivity activity = (AppCompatActivity) context;
        SwapFragment swapFragment = new SwapFragment();
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, swapFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void openChatFragment() {
        AppCompatActivity activity = (AppCompatActivity) context;
        ChatFragment chatFragment = new ChatFragment();
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, chatFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_txt);
        }
    }
}
