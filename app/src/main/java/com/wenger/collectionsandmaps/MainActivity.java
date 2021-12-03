package com.wenger.collectionsandmaps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import android.view.View;

import com.google.android.material.tabs.TabLayoutMediator;
import com.wenger.collectionsandmaps.databinding.ActivityMainBinding;

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
                            tab.setText(R.string.Collections);
                            break;
                        }
                        case 1: {
                            tab.setText(R.string.Maps);
                            break;
                        }
                    }
                }
        ).attach();
    }
}
