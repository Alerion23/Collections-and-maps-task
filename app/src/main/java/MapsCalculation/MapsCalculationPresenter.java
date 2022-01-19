package MapsCalculation;

import android.content.Context;

import com.wenger.collectionsandmaps.BaseItem;
import com.wenger.collectionsandmaps.HeaderItem;
import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.ResultItem;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import di.AppContext;

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
    public List<BaseItem> createDefaultList(String treeMap, String hashMap, String addingNew,
                                            String searchByKey, String removing) {

        defaultItems = Arrays.asList(
                new HeaderItem(addingNew),
                new ResultItem(-1, treeMap, mapsId121),
                new ResultItem(-1, hashMap, mapsId122),
                new HeaderItem(searchByKey),
                new ResultItem(-1, treeMap, mapsId123),
                new ResultItem(-1, hashMap, mapsId124),
                new HeaderItem(removing),
                new ResultItem(-1, treeMap, mapsId125),
                new ResultItem(-1, hashMap, mapsId126));
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
