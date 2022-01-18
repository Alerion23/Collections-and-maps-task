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

    Context context;
    CalculationMapsFragment mapsView;
    List<BaseItem> defaultItems;
    private String treeMap;
    private String hashMap;

    @Inject
    public MapsCalculationPresenter(@AppContext Context context, CalculationMapsFragment mapsView) {
        this.context = context;
        this.mapsView = mapsView;
    }

    @Override
    public List<BaseItem> createDefaultList() {
        treeMap = context.getString(R.string.treeMap);
        hashMap = context.getString(R.string.hashMap);
        defaultItems = Arrays.asList(new HeaderItem(context.getString(R.string.adding_new_map)),
                new ResultItem(-1, treeMap, 121),
                new ResultItem(-1, hashMap, 122),
                new HeaderItem(context.getString(R.string.search_by_key_map)),
                new ResultItem(-1, treeMap, 123),
                new ResultItem(-1, hashMap, 124),
                new HeaderItem(context.getString(R.string.removing_map)),
                new ResultItem(-1, treeMap, 125),
                new ResultItem(-1, hashMap, 126));
        return defaultItems;
    }

    @Override
    public void getDataFromReceiver(int resultMaps, int idMaps) {
        for (int y = 0; y < defaultItems.size(); y++) {
            BaseItem item = defaultItems.get(y);
            if (item instanceof ResultItem && ((ResultItem) item).getId() == idMaps) {
                ResultItem resultItem = new ResultItem(resultMaps,
                        ((ResultItem) item).getTitle(), ((ResultItem) item).getId());
                mapsView.onMapsItemsReceived(resultItem);
            }
        }
    }
}
