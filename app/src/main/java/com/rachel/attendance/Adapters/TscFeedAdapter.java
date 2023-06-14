package com.rachel.attendance.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rachel.attendance.Models.TscFeedModel;
import com.rachel.attendance.R;
import com.rachel.attendance.TscFeedsFragment;

import java.util.ArrayList;

public class TscFeedAdapter extends RecyclerView.Adapter<TscFeedAdapter.ViewHolder> {

    Context context;
    ArrayList<TscFeedModel>list;

    public TscFeedAdapter(Context context, ArrayList<TscFeedModel> list, TscFeedsFragment teachersFragment) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TscFeedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.tsc_feed_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull TscFeedAdapter.ViewHolder holder, int position) {
        final TscFeedModel s = list.get(position);
        holder.name.setText(s.getName());
        holder.content.setText(s.getContent());
        holder.time.setText(s.getTime());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView time;
        TextView content;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_txt);
            time = itemView.findViewById(R.id.time_txt);
            content = itemView.findViewById(R.id.message_txt);
        }
    }
}
