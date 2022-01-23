package com.wenger.collectionsandmaps.collectionCalculation;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wenger.collectionsandmaps.BaseItem;
import com.wenger.collectionsandmaps.HeaderItem;
import com.wenger.collectionsandmaps.R;

import java.util.List;

class CollectionHeaderViewHolder extends RecyclerView.ViewHolder {

    TextView header;

    public CollectionHeaderViewHolder(@NonNull View itemView) {
        super(itemView);
        header = itemView.findViewById(R.id.textViewHeader);
    }

    public void bind(HeaderItem headerItem) {
        header.setText(headerItem.getHeader());
    }
}
