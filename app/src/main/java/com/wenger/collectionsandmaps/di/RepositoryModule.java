package com.wenger.collectionsandmaps.di;

import com.wenger.collectionsandmaps.CollectionRepository;
import com.wenger.collectionsandmaps.MapsRepository;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class RepositoryModule {

    @Binds
    @IntoMap
    @RepositoryKey(value = "CollectionRepository")
    abstract CollectionRepository bindCollectionRepository(CollectionRepository repository);

    @Binds
    @IntoMap
    @RepositoryKey(value = "MapsRepository")
    abstract MapsRepository bindMapsRepository(MapsRepository repository);
}
