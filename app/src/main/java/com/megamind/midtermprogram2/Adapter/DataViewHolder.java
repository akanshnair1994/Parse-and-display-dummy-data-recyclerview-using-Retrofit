package com.megamind.midtermprogram2.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.megamind.midtermprogram2.R;

public class DataViewHolder extends RecyclerView.ViewHolder {
    TextView id, fromName, message, commentLink, likeLink;

    public DataViewHolder(@NonNull View itemView) {
        super(itemView);

        id = itemView.findViewById(R.id.ID);
        fromName = itemView.findViewById(R.id.fromName);
        message = itemView.findViewById(R.id.message);
        commentLink = itemView.findViewById(R.id.commentLink);
        likeLink = itemView.findViewById(R.id.likeLink);
    }
}
