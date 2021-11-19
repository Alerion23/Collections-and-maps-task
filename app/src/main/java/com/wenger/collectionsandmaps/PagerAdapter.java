package com.wenger.collectionsandmaps;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import fragments.CollectionsFragment;
import fragments.MapsFragment;

public class PagerAdapter extends FragmentStateAdapter {
    PagerAdapter(FragmentActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new CollectionsFragment();
            case 1:
                return new MapsFragment();
            default:
                return new CollectionsFragment();
        }
    }

    @Override
    public int getItemCount() {

        return 2;
    }
}
