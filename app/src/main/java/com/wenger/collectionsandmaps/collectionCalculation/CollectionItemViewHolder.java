package com.wenger.collectionsandmaps.collectionCalculation;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wenger.collectionsandmaps.BaseItem;
import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.ResultItem;

import java.util.List;

class CollectionItemViewHolder extends RecyclerView.ViewHolder {

    TextView title;
    TextView result;
    ProgressBar loading;

    public CollectionItemViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title_coll);
        result = itemView.findViewById(R.id.result);
        loading = itemView.findViewById(R.id.progress_bar_collection);
    }

    public void bind(CollectionItemViewHolder h, List<BaseItem> itemList, int position) {
        ResultItem item = ((ResultItem) itemList.get(position));
        h.title.setText(item.getTitle());
        if (item.getResult() >= 0) {
            h.result.setText(item.getResult().toString());
            h.loading.setVisibility(View.GONE);
        }
    }
}
