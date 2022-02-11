package com.wenger.collectionsandmaps.di;

import com.wenger.collectionsandmaps.collectionCalculation.CalculationCollectionsFragment;
import com.wenger.collectionsandmaps.collectionCalculation.ICollectionView;
import com.wenger.collectionsandmaps.mapsCalculation.CalculationMapsFragment;
import com.wenger.collectionsandmaps.mapsCalculation.IMapsView;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModule {

    @Binds
    abstract ICollectionView bindCollectionView(CalculationCollectionsFragment collectionView);

    @Binds
    abstract IMapsView bindMapsView(CalculationMapsFragment mapsView);
}
