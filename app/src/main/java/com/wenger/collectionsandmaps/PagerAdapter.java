package com.wenger.collectionsandmaps;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;


import com.wenger.collectionsandmaps.fragments.CollectionsFragment;
import com.wenger.collectionsandmaps.fragments.MapsFragment;

public class PagerAdapter extends FragmentStateAdapter {
    PagerAdapter(FragmentActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return CollectionsFragment.newInstance();
            case 1:
                return MapsFragment.newInstance();
            default:
                return CollectionsFragment.newInstance();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
