package com.wenger.collectionsandmaps.mapsCalculation;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wenger.collectionsandmaps.BaseItem;
import com.wenger.collectionsandmaps.HeaderItem;
import com.wenger.collectionsandmaps.R;

import java.util.Base64;
import java.util.List;

class MapsHeaderViewHolder extends RecyclerView.ViewHolder {
    private TextView header;

    public MapsHeaderViewHolder(@NonNull View itemView) {
        super(itemView);
        header = itemView.findViewById(R.id.textViewHeader);
    }

    public void bind(HeaderItem headerItem) {
        header.setText(headerItem.getHeader());
    }
}
