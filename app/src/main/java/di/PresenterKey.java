package di;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import CollectionCalculation.CollectionCalculationPresenter;
import dagger.MapKey;

@Retention(RetentionPolicy.RUNTIME)
@MapKey
public @interface PresenterKey {

    String value();
}
