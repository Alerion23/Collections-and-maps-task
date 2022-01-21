package com.wenger.collectionsandmaps.app;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

import com.wenger.collectionsandmaps.di.AppComponent;
import com.wenger.collectionsandmaps.di.AppModule;
import com.wenger.collectionsandmaps.di.DaggerAppComponent;

public class MyApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .application(this)
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
        return appComponent;
    }

}
