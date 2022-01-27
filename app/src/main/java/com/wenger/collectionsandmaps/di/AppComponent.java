package com.wenger.collectionsandmaps.di;

import android.app.Application;

import javax.inject.Singleton;

import com.wenger.collectionsandmaps.app.MyApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {AppModule.class, AndroidInjectionModule.class,
        FragmentModule.class, RepositoryModule.class})
public interface AppComponent extends AndroidInjector<MyApplication> {

    void inject(MyApplication myApplication);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        Builder appModule(AppModule appModule);

        AppComponent build();
    }

}
