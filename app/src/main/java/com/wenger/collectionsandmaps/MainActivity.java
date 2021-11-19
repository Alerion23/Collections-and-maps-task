package com.wenger.collectionsandmaps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.wenger.collectionsandmaps.databinding.ActivityMainBinding;

import fragments.CalculCollectionsFragment;

public class MainActivity extends FragmentActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
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

    public void replaceCollectionFragment (Fragment fragment, Integer layout) {
        getSupportFragmentManager().beginTransaction()
                .replace(layout, fragment, null)
                .addToBackStack(null)
                .commit();
    }
}