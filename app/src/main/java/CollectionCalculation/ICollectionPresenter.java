package CollectionCalculation;

import com.wenger.collectionsandmaps.BaseItem;

import java.util.List;

public interface ICollectionPresenter {

    List<BaseItem> createDefaultList(String arrayList,
                                     String linkedList,
                                     String copyOnWrite,
                                     String addITheBeginningCollection,
                                     String addInTheMiddleCollection,
                                     String addInTheEndCollection,
                                     String searchByValueCollection,
                                     String removeInTheBeginningCollection,
                                     String removeInTheMiddleCollection,
                                     String removeInTheEndCollection);

    void getDataFromReceiver(int resultCollection, int idCollection);
}
