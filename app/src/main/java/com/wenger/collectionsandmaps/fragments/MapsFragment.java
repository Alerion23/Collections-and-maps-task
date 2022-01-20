package com.wenger.collectionsandmaps.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.wenger.collectionsandmaps.BaseFragment;
import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.databinding.FragmentMapsBinding;

import com.wenger.collectionsandmaps.mapsCalculation.CalculationMapsFragment;


public class MapsFragment extends BaseFragment {
    public MapsFragment() {
        super(R.layout.fragment_maps);
    }

    private FragmentMapsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMapsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onCalcMapClickListener();
    }

    private void onCalcMapClickListener() {
        binding.calculateMaps.setOnClickListener(v -> {
            String editText = binding.typeMapSize.getText().toString();
            if (!(editText.isEmpty())) {
                CalculationMapsFragment fragment =
                        CalculationMapsFragment.newInstance(Integer.parseInt(editText));
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.inner_maps_fragment_container, fragment, null)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    public static MapsFragment newInstance() {
        MapsFragment fragment = new MapsFragment();
        return fragment;
    }
}
