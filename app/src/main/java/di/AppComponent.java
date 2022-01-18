package di;

import android.app.Application;

import javax.inject.Singleton;

import CollectionCalculation.CalculationCollectionsFragment;
import CollectionCalculation.CollectionCalculationPresenter;
import MapsCalculation.MapsCalculationPresenter;
import app.MyApplication;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

@Singleton
@Component(modules = {AppModule.class, AndroidInjectionModule.class,
        FragmentModule.class})
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
