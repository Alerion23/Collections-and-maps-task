package di;

import android.content.Context;

import javax.inject.Singleton;

import CollectionCalculation.CalculationCollectionsFragment;
import CollectionCalculation.CollectionCalculationPresenter;
import CollectionCalculation.ICollectionPresenter;
import MapsCalculation.MapsCalculationPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
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
