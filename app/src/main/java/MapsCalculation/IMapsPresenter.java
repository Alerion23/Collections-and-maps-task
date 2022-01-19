package MapsCalculation;

import com.wenger.collectionsandmaps.BaseItem;

import java.util.List;

public interface IMapsPresenter {

    List<BaseItem> createDefaultList(String treeMap, String hashMap, String addingNew,
                                     String searchByKey, String removing);

    void getDataFromReceiver(int resultMaps, int idMaps);
}
