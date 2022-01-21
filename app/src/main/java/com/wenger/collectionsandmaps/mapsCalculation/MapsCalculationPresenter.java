package com.wenger.collectionsandmaps.mapsCalculation;

import com.wenger.collectionsandmaps.BaseItem;
import com.wenger.collectionsandmaps.HeaderItem;
import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.ResultItem;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class MapsCalculationPresenter implements IMapsPresenter {

    private CalculationMapsFragment mapsView;
    private List<BaseItem> defaultItems;
    private final int MAPS_ID_121 = 121;
    private final int MAPS_ID_122 = 122;
    private final int MAPS_ID_123 = 123;
    private final int MAPS_ID_124 = 124;
    private final int MAPS_ID_125 = 125;
    private final int MAPS_ID_126 = 126;

    @Inject
    public MapsCalculationPresenter(CalculationMapsFragment mapsView) {
        this.mapsView = mapsView;
    }

    @Override
    public List<BaseItem> createDefaultList() {
        int treeMapTitle = R.string.treeMap;
        int hashMapTitle = R.string.hashMap;
        int addingNewHeader = R.string.adding_new_map;
        int searchByKeyHeader = R.string.search_by_key_map;
        int removingHeader = R.string.removing_map;
        defaultItems = Arrays.asList(
                new HeaderItem(addingNewHeader),
                new ResultItem(-1, treeMapTitle, MAPS_ID_121),
                new ResultItem(-1, hashMapTitle, MAPS_ID_122),
                new HeaderItem(searchByKeyHeader),
                new ResultItem(-1, treeMapTitle, MAPS_ID_123),
                new ResultItem(-1, hashMapTitle, MAPS_ID_124),
                new HeaderItem(removingHeader),
                new ResultItem(-1, treeMapTitle, MAPS_ID_125),
                new ResultItem(-1, hashMapTitle, MAPS_ID_126));
        return defaultItems;
    }

    @Override
    public void getDataFromReceiver(int resultMaps, int idMaps) {
        for (int y = 0; y < defaultItems.size(); y++) {
            BaseItem item = defaultItems.get(y);
            if (item instanceof ResultItem && ((ResultItem) item).getId() == idMaps) {
                ResultItem resultItem = new ResultItem(resultMaps,
                        ((ResultItem) item).getTitle(), ((ResultItem) item).getId());
                mapsView.onMapsItemReceived(resultItem);
            }
        }
    }
}
