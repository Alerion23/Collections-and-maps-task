package com.wenger.collectionsandmaps.di;

import com.wenger.collectionsandmaps.CollectionRepository;
import com.wenger.collectionsandmaps.ICollectionRepository;
import com.wenger.collectionsandmaps.IMapsRepository;
import com.wenger.collectionsandmaps.MapsRepository;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RepositoryModule {

    @Binds
    abstract IMapsRepository bindIMapsRepository(MapsRepository repository);

    @Binds
    abstract ICollectionRepository bindICollectionRepository(CollectionRepository repository);
}
