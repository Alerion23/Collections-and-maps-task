package com.wenger.collectionsandmaps.collectionCalculation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;

import com.wenger.collectionsandmaps.BaseItem;
import com.wenger.collectionsandmaps.CalculationService;

import dagger.android.support.DaggerFragment;

import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.ResultItem;
import com.wenger.collectionsandmaps.databinding.FragmentCalcCollectionsBinding;

import java.util.List;

import javax.inject.Inject;


public class CalculationCollectionsFragment extends DaggerFragment implements ICollectionView {

    private FragmentCalcCollectionsBinding binding;
    private CollectionAdapter adapter;
    private BroadcastReceiver br;
    private final String KEY = "collectionSize";

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
        startService(collectionSize);
        recyclerViewConfiguration(adapter);
        registerReceiver();
        onClearClickListener();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(br);
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

    private void startService(int collectionSize) {
        Intent service = new Intent(getActivity(), CalculationService.class);
        service.putExtra(KEY, collectionSize);
        getContext().startService(service);
    }

    private void registerReceiver() {
        br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int resultCollection = intent.getExtras().getInt("result");
                int idCollection = intent.getExtras().getInt("id");
                collectionPresenter.getDataFromReceiver(resultCollection, idCollection);
            }
        };
        LocalBroadcastManager.getInstance(getContext())
                .registerReceiver(br, new IntentFilter("CollectionCalculate"));
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

