package com.megamind.midtermprogram2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.megamind.midtermprogram2.Pojo.Datum;
import com.megamind.midtermprogram2.R;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {
    Context context;
    List<Datum> dataList;

    public DataAdapter(Context context, List<Datum> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_data, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        Datum data = dataList.get(position);

        holder.id.setText("ID: " + data.getId());
        holder.fromName.setText("From Name: " + data.getFrom().getName());
        holder.message.setText("Message: " + data.getMessage());
        holder.commentLink.setText("Comment Link: " + data.getActions().get(0).getLink());
        holder.likeLink.setText("Like Link: " + data.getActions().get(1).getLink());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
