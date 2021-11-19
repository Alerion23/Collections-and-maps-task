package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.wenger.collectionsandmaps.BaseItem;
import com.wenger.collectionsandmaps.CollectionAdapter;
import com.wenger.collectionsandmaps.HeaderItem;
import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.ResultItem;
import com.wenger.collectionsandmaps.databinding.FragmentCalcCollectionsBinding;
import com.wenger.collectionsandmaps.databinding.FragmentCollectionsBinding;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class CalculCollectionsFragment extends Fragment {

    private FragmentCalcCollectionsBinding binding;
    CollectionAdapter adapter;


    public CalculCollectionsFragment() {
        super(R.layout.fragment_calc_collections);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCalcCollectionsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.getItemViewType(position) == CollectionAdapter.VIEW_TYPE_HEADER ? 3 : 1;
            }
        });
        binding.collectionsRecycler.setLayoutManager(layoutManager);
        adapter = new CollectionAdapter(createItemsList());
        binding.collectionsRecycler.setAdapter(adapter);
        onClearClickListener();
    }

    private void onClearClickListener() {
        binding.clearCollection.setOnClickListener(v -> {
            getParentFragmentManager().popBackStack();
        });
    }

    public List<BaseItem> createItemsList() {
        Integer collectionSize = getArguments() != null ? getArguments().getInt("collectionSize") : 0;
        List<BaseItem> itemsList = Arrays.asList(new HeaderItem("Adding in the beginning"),
                new ResultItem(collectionSize, "ArrayList"),
                new ResultItem(collectionSize, "LinkedList"),
                new ResultItem(collectionSize, "CopyOnWrite"),
                new HeaderItem("Adding in the middle"),
                new ResultItem(collectionSize, "ArrayList"),
                new ResultItem(collectionSize, "LinkedList"),
                new ResultItem(collectionSize, "CopyOnWrite"),
                new HeaderItem("Adding in the end"),
                new ResultItem(collectionSize, "ArrayList"),
                new ResultItem(collectionSize, "LinkedList"),
                new ResultItem(collectionSize, "CopyOnWrite"),
                new HeaderItem("Search by value"),
                new ResultItem(collectionSize, "ArrayList"),
                new ResultItem(collectionSize, "LinkedList"),
                new ResultItem(collectionSize, "CopyOnWrite"),
                new HeaderItem("Removing in the beginning"),
                new ResultItem(collectionSize, "ArrayList"),
                new ResultItem(collectionSize, "LinkedList"),
                new ResultItem(collectionSize, "CopyOnWrite"),
                new HeaderItem("Removing in the middle"),
                new ResultItem(collectionSize, "ArrayList"),
                new ResultItem(collectionSize, "LinkedList"),
                new ResultItem(collectionSize, "CopyOnWrite"),
                new HeaderItem("Removing in the end"),
                new ResultItem(collectionSize, "ArrayList"),
                new ResultItem(collectionSize, "LinkedList"),
                new ResultItem(collectionSize, "CopyOnWrite"));
        return itemsList;
    }

    public static CalculCollectionsFragment newInstance(Integer collectionSize) {
        CalculCollectionsFragment fragment = new CalculCollectionsFragment();
        Bundle args = new Bundle();
        args.putInt("collectionSize", collectionSize);
        fragment.setArguments(args);
        return fragment;
    }
}

