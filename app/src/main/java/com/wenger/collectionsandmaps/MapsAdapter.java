package com.wenger.collectionsandmaps;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MapsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<BaseItem> itemList;
    public static final int VIEW_TYPE_HEADER = 0;
    public static final int VIEW_TYPE_ITEM = 1;

    public MapsAdapter(List<BaseItem> itemList) {
        this.itemList = itemList;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setMapsItems(List<BaseItem> baseItems) {
        for (int i = 0; i < baseItems.size(); i++) {
            BaseItem defaultItem = itemList.get(i);
            BaseItem newItem = baseItems.get(i);
            if (defaultItem instanceof ResultItem && newItem instanceof ResultItem &&
                    ((ResultItem) defaultItem).getId().equals(((ResultItem) newItem).getId())) {
                if (((ResultItem) defaultItem).getResult() != ((ResultItem) newItem).getResult()) {
                    itemList.set(i, new ResultItem(((ResultItem) newItem).getResult(),
                            ((ResultItem) defaultItem).getTitle(), ((ResultItem) defaultItem).getId()));
                    notifyItemChanged(i);
                }
            }
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_collection, parent, false);
            return new ItemViewHolder(view.getRootView());
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_item_collections, parent, false);
            return new HeaderViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (itemList.get(position).getType() == "header") {
            HeaderViewHolder h = (HeaderViewHolder) holder;
            HeaderItem header = (HeaderItem) itemList.get(position);
            h.header.setText(header.getHeader());
        } else {
            ItemViewHolder h = (ItemViewHolder) holder;
            ResultItem item = (ResultItem) itemList.get(position);
            h.title.setText(item.getTitle());
            if (item.getResult() >= 0) {
                h.result.setText(item.getResult().toString());
                h.loading.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (itemList.get(position).getType() == "header") {
            return VIEW_TYPE_HEADER;
        } else {
            return VIEW_TYPE_ITEM;
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView result;
        ProgressBar loading;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_coll);
            result = itemView.findViewById(R.id.result);
            loading = itemView.findViewById(R.id.progress_bar_collection);
        }
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView header;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.textViewHeader);
        }
    }

}
