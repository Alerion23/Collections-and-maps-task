package com.wenger.collectionsandmaps;

import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import android.view.View;

import com.google.android.material.tabs.TabLayoutMediator;
import com.wenger.collectionsandmaps.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;

import fragments.CalculCollectionsFragment;
import fragments.CalculMapsFragment;
import fragments.CollectionsFragment;
import fragments.MapsFragment;

public class MainActivity extends FragmentActivity {

    private ActivityMainBinding binding;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        pagerAdapter = new PagerAdapter(this);
        binding.viewPager2.setAdapter(new PagerAdapter(this));
        new TabLayoutMediator(binding.tabLayout, binding.viewPager2,
                (tab, position) -> {
                    switch (position) {
                        case 0: {
                            tab.setText("Collections");
                            break;
                        }
                        case 1: {
                            tab.setText("Maps");
                            break;
                        }
                    }
                }
        ).attach();
    }

}
