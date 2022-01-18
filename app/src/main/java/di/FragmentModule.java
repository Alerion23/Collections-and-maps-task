package di;

import CollectionCalculation.CalculationCollectionsFragment;
import MapsCalculation.CalculationMapsFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector(modules = PresenterModule.class)
    abstract CalculationCollectionsFragment bindCalculationCollectionFragment();

    @ContributesAndroidInjector(modules = PresenterModule.class)
    abstract CalculationMapsFragment bindCalculationMapsFragment();
}
