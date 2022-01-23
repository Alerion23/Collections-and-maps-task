package com.wenger.collectionsandmaps.collectionCalculation;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.wenger.collectionsandmaps.BaseItem;
import com.wenger.collectionsandmaps.HeaderItem;
import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.ResultItem;

import java.util.List;

public class CollectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<BaseItem> itemList;
    public static final int VIEW_TYPE_HEADER = 0;
    public static final int VIEW_TYPE_ITEM = 1;
    private final String HEADER_ITEM = "header";

    public CollectionAdapter(List<BaseItem> itemList) {
        this.itemList = itemList;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateItem(ResultItem newItem) {
        for (int i = 0; i < itemList.size(); i++) {
            BaseItem item = itemList.get(i);
            if (item instanceof ResultItem && newItem.getId() == ((ResultItem) item).getId()) {
                itemList.set(i, new ResultItem(newItem.getResult(),
                        ((ResultItem) item).getTitle(), ((ResultItem) item).getId()));
                notifyItemChanged(i);
            }
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_collection, parent, false);
            return new CollectionItemViewHolder(view.getRootView());
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_item_collections, parent, false);
            return new CollectionHeaderViewHolder(view.getRootView());
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (itemList.get(position).getType() == HEADER_ITEM) {
            HeaderItem header = ((HeaderItem) itemList.get(position));
            CollectionHeaderViewHolder h = (CollectionHeaderViewHolder) holder;
            h.bind(header);
        } else {
            ResultItem item = ((ResultItem) itemList.get(position));
            CollectionItemViewHolder h = (CollectionItemViewHolder) holder;
            h.bind(item);
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (itemList.get(position).getType() == HEADER_ITEM) {
            return VIEW_TYPE_HEADER;
        } else {
            return VIEW_TYPE_ITEM;
        }
    }

}
