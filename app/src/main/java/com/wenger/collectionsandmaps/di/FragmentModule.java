package com.wenger.collectionsandmaps.di;

import com.wenger.collectionsandmaps.collectionCalculation.CalculationCollectionsFragment;
import com.wenger.collectionsandmaps.mapsCalculation.CalculationMapsFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector(modules = PresenterModule.class)
    abstract CalculationCollectionsFragment bindCalculationCollectionFragment();

    @ContributesAndroidInjector(modules = PresenterModule.class)
    abstract CalculationMapsFragment bindCalculationMapsFragment();
}
