package app;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import di.AppComponent;
import di.AppModule;
import di.DaggerAppComponent;

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
