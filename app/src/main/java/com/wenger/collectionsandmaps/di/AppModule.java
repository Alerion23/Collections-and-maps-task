package com.wenger.collectionsandmaps.di;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @AppContext
    @Provides
    @Singleton
    @Inject
    Context provideContext() {
        return context;
    }

}
