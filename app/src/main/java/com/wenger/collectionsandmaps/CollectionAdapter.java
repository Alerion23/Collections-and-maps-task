package com.wenger.collectionsandmaps;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class CollectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<BaseItem> itemList;
    public static final int VIEW_TYPE_HEADER = 0;
    public static final int VIEW_TYPE_ITEM = 1;

    public CollectionAdapter(List<BaseItem> itemList) {
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
            return new HeaderViewHolder(view.getRootView());
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (itemList.get(position).getType() == "header") {
            HeaderViewHolder h = (HeaderViewHolder) holder;
            HeaderItem header = ((HeaderItem) itemList.get(position));
            h.header.setText(header.getHeader());
        } else {
            ItemViewHolder h = (ItemViewHolder) holder;
            ResultItem title = ((ResultItem) itemList.get(position));
            h.title.setText(title.getTitle());
            IGetResult getResult = time -> {
                h.result.setText(String.valueOf(time));
                h.loading.setVisibility(ProgressBar.GONE);
            };
            switch (position) {
                case 1: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.arrayListAddInTheBeginning(getResult);
                }
                case 2: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.linkInListAddInTheBeginning(getResult);
                }
                case 3: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.copyOnWriteAddInTheBeginning(getResult);
                }
                case 5: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.arrayListAddInTheMiddle(getResult);
                }
                case 6: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.linkInListAddInTheMiddle(getResult);
                }
                case 7: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.copyOnWriteAddInTheMiddle(getResult);
                }
                case 9: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.arrayListAddInTheEnd(getResult);
                }
                case 10: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.linkInListAddInTheEnd(getResult);
                }
                case 11: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.copyOnWriteAddInTheEnd(getResult);
                }
                case 13: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.arrayListSearchBy(getResult);
                }
                case 14: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.linkInListSearByValue(getResult);
                }
                case 15: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.copyOnWriteSearchByValue(getResult);
                }
                case 17: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.arrayListRemoveInTheBeginning(getResult);
                }
                case 18: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.linkInListRemoveInTheBeginning(getResult);
                }
                case 19: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.copyOnWriteRemovingInTheBeginning(getResult);
                }
                case 21: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.arrayListRemoveInTheMiddle(getResult);
                }
                case 22: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.linkInListRemoveInTheMiddle(getResult);
                }
                case 23: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.copyOnWriteRemovingInTheMiddle(getResult);
                }
                case 25: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.arrayListRemoveInTheEnd(getResult);
                }
                case 26: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.linkInListRemoveInTheEnd(getResult);
                }
                case 27: {
                    ResultItem result = ((ResultItem) itemList.get(position));
                    result.copyOnWriteRemovingInTheEnd(getResult);
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
