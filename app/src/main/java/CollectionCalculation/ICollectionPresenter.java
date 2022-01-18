package CollectionCalculation;

import com.wenger.collectionsandmaps.BaseItem;

import java.util.List;

public interface ICollectionPresenter {

    List<BaseItem> createDefaultList();

    void getDataFromReceiver(int resultCollection, int idCollection);
}
