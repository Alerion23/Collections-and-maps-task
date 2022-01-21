package com.wenger.collectionsandmaps.mapsCalculation;

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
import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.ResultItem;
import com.wenger.collectionsandmaps.databinding.FragmentCalcMapsBinding;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


public class CalculationMapsFragment extends DaggerFragment implements IMapsView {

    private FragmentCalcMapsBinding binding;
    private MapsAdapter adapter;
    private BroadcastReceiver br;
    private String key = "mapSize";

    @Inject
    MapsCalculationPresenter mapsPresenter;

    public CalculationMapsFragment() {
        super(R.layout.fragment_calc_maps);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCalcMapsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int mapSize = getArguments() != null ? getArguments().getInt(key) : 0;
        adapter = new MapsAdapter(mapsPresenter.createDefaultList());
        startService(mapSize);
        recyclerViewConfiguration(adapter);
        registerReceiver();
        onClearClickListener();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(br);
    }

    public void recyclerViewConfiguration(MapsAdapter adapter) {
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.getItemViewType(position) == MapsAdapter.VIEW_TYPE_HEADER ? 2 : 1;
            }
        });
        binding.mapRecycler.setLayoutManager(layoutManager);
        binding.mapRecycler.setAdapter(adapter);
    }

    private void startService(int mapSize) {
        Intent service = new Intent(getActivity(), CalculationService.class);
        service.putExtra(key, mapSize);
        getContext().startService(service);
    }

    private void registerReceiver() {
        br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int resultMaps = intent.getExtras().getInt("resultMaps");
                int idMaps = intent.getExtras().getInt("idMaps");
                mapsPresenter.getDataFromReceiver(resultMaps, idMaps);
            }
        };
        LocalBroadcastManager.getInstance(getContext())
                .registerReceiver(br, new IntentFilter("CollectionCalculate"));
    }

    private void onClearClickListener() {
        binding.clearMap.setOnClickListener(v -> {
            getParentFragmentManager().popBackStack();
        });
    }

    @Override
    public void onMapsItemReceived(ResultItem resultItem) {
        adapter.updateMapsItem(resultItem);
    }

    public static CalculationMapsFragment newInstance(Integer mapSize) {
        CalculationMapsFragment fragment = new CalculationMapsFragment();
        Bundle args = new Bundle();
        args.putInt(fragment.key, mapSize);
        fragment.setArguments(args);
        return fragment;
    }
}
