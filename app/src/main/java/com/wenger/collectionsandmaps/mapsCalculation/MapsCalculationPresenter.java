package com.wenger.collectionsandmaps.mapsCalculation;

import com.wenger.collectionsandmaps.BaseItem;
import com.wenger.collectionsandmaps.HeaderItem;
import com.wenger.collectionsandmaps.ResultItem;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class MapsCalculationPresenter implements IMapsPresenter {

    private CalculationMapsFragment mapsView;
    private List<BaseItem> defaultItems;
    private int mapsId121 = 121;
    private int mapsId122 = 122;
    private int mapsId123 = 123;
    private int mapsId124 = 124;
    private int mapsId125 = 125;
    private int mapsId126 = 126;

    @Inject
    public MapsCalculationPresenter(CalculationMapsFragment mapsView) {
        this.mapsView = mapsView;
    }

    @Override
    public List<BaseItem> createDefaultList(String treeMapTitle, String hashMapTitle, String addingNewHeader,
                                            String searchByKeyHeader, String removingHeader) {

        defaultItems = Arrays.asList(
                new HeaderItem(addingNewHeader),
                new ResultItem(-1, treeMapTitle, mapsId121),
                new ResultItem(-1, hashMapTitle, mapsId122),
                new HeaderItem(searchByKeyHeader),
                new ResultItem(-1, treeMapTitle, mapsId123),
                new ResultItem(-1, hashMapTitle, mapsId124),
                new HeaderItem(removingHeader),
                new ResultItem(-1, treeMapTitle, mapsId125),
                new ResultItem(-1, hashMapTitle, mapsId126));
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
