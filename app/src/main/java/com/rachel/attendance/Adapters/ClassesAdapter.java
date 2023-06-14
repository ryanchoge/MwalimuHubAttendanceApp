package com.rachel.attendance.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rachel.attendance.ClassesFragment;
import com.rachel.attendance.Models.ClassesModel;
import com.rachel.attendance.R;

import java.util.ArrayList;

public class ClassesAdapter extends RecyclerView.Adapter<ClassesAdapter.ViewHolder> {
    Context context;
    ArrayList<ClassesModel>list;

    public ClassesAdapter(Context context, ArrayList<ClassesModel> list, ClassesFragment classesFragment) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ClassesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.class_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ClassesAdapter.ViewHolder holder, int position) {
        final ClassesModel s = list.get(position);
        holder.classTitle.setText(s.getTitle());
        holder.subjects.setText(s.getSubjects());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView classTitle;
        TextView subjects;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            classTitle = itemView.findViewById(R.id.textView12);
            subjects = itemView.findViewById(R.id.subjectsTxt);
        }
    }
}
