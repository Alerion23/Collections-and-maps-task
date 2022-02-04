package com.wenger.collectionsandmaps.di;

import com.wenger.collectionsandmaps.collectionCalculation.CollectionCalculationPresenter;
import com.wenger.collectionsandmaps.mapsCalculation.MapsCalculationPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class PresenterModule {

    @Binds
    @IntoMap
    @PresenterKey(value = "CollectionCalculationPresenter")
    abstract CollectionCalculationPresenter bindCollectionPresenter(CollectionCalculationPresenter presenter);

    @Binds
    @IntoMap
    @PresenterKey(value = "MapsCalculationPresenter")
    abstract MapsCalculationPresenter bindMapsPresenter(MapsCalculationPresenter presenter);
}
