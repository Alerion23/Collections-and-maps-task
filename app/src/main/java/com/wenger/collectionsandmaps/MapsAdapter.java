package com.wenger.collectionsandmaps;

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
            ResultItem title = (ResultItem) itemList.get(position);
            h.title.setText(title.getTitle());
            IGetResult getResult = time -> {
                h.result.setText(String.valueOf(time));
                h.loading.setVisibility(ProgressBar.GONE);
            };
            switch (position) {
                case 1: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.treeMapAddingNew(getResult);
                }
                case 2: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.hashMapAddingNew(getResult);
                }
                case 4: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.treeMapSearchByKey(getResult);
                }
                case 5: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.hashMapSearchByKey(getResult);
                }
                case 7: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.treeMapRemove(getResult);
                }
                case 8: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.hashMapRemove(getResult);
                }
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
