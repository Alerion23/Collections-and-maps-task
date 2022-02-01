package com.wenger.collectionsandmaps.collectionCalculation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;

import dagger.android.support.DaggerFragment;

import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.ResultItem;
import com.wenger.collectionsandmaps.databinding.FragmentCalcCollectionsBinding;

import javax.inject.Inject;


public class CalculationCollectionsFragment extends DaggerFragment implements ICollectionView {

    private FragmentCalcCollectionsBinding binding;
    private CollectionAdapter adapter;
    private static final String KEY = "collectionSize";

    @Inject
    CollectionCalculationPresenter collectionPresenter;

    public CalculationCollectionsFragment() {
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
        int collectionSize = getArguments() != null ? getArguments().getInt(KEY) : 0;
        adapter = new CollectionAdapter(collectionPresenter.createDefaultList());
        recyclerViewConfiguration(adapter);
        collectionPresenter.collectionCalculation(collectionSize);
        onClearClickListener();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        collectionPresenter.stop();
    }

    private void recyclerViewConfiguration(CollectionAdapter adapter) {
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.getItemViewType(position) == CollectionAdapter.VIEW_TYPE_HEADER ? 3 : 1;
            }
        });
        binding.collectionsRecycler.setLayoutManager(layoutManager);
        binding.collectionsRecycler.setAdapter(adapter);
    }

    private void onClearClickListener() {
        binding.clearCollection.setOnClickListener(v -> {
            getParentFragmentManager().popBackStack();
        });
    }

    @Override
    public void onCollectionItemReceived(ResultItem resultItem) {
        adapter.updateItem(resultItem);
    }

    public static CalculationCollectionsFragment newInstance(Integer collectionSize) {
        CalculationCollectionsFragment fragment = new CalculationCollectionsFragment();
        Bundle args = new Bundle();
        args.putInt(fragment.KEY, collectionSize);
        fragment.setArguments(args);
        return fragment;

    }
}

