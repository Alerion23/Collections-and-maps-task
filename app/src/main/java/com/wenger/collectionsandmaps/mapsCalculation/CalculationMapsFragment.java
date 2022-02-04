package com.wenger.collectionsandmaps.mapsCalculation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;

import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.ResultItem;
import com.wenger.collectionsandmaps.databinding.FragmentCalcMapsBinding;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


public class CalculationMapsFragment extends DaggerFragment implements IMapsView {

    private FragmentCalcMapsBinding binding;
    private MapsAdapter adapter;
    private static final String KEY = "mapSize";

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
        int mapSize = getArguments() != null ? getArguments().getInt(KEY) : 0;
        adapter = new MapsAdapter(mapsPresenter.createDefaultList());
        recyclerViewConfiguration(adapter);
        mapsPresenter.mapsCalculation(mapSize);
        onClearClickListener();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapsPresenter.stop();
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

    private void onClearClickListener() {
        binding.clearMap.setOnClickListener(v -> {
            getParentFragmentManager().popBackStack();
        });
    }

    @Override
    public void onMapsItemReceived(ResultItem resultItem) {
        adapter.updateItem(resultItem);
    }

    public static CalculationMapsFragment newInstance(Integer mapSize) {
        CalculationMapsFragment fragment = new CalculationMapsFragment();
        Bundle args = new Bundle();
        args.putInt(fragment.KEY, mapSize);
        fragment.setArguments(args);
        return fragment;
    }
}
