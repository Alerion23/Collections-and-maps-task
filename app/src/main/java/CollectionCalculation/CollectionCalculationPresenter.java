package CollectionCalculation;

import android.content.Context;

import com.wenger.collectionsandmaps.BaseItem;
import com.wenger.collectionsandmaps.HeaderItem;
import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.ResultItem;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import app.MyApplication;
import di.AppContext;


public class CollectionCalculationPresenter implements ICollectionPresenter {

    private Context context;
    private List<BaseItem> defaultItems;
    private String arrayList;
    private String linkedList;
    private String copyOnWrite;
    private CalculationCollectionsFragment collectionView;

    @Inject
    public CollectionCalculationPresenter(@AppContext Context context, CalculationCollectionsFragment collectionView) {
        this.context = context;
        this.collectionView = collectionView;
    }

    @Override
    public List<BaseItem> createDefaultList() {
        arrayList = context.getString(R.string.arrayList);
        linkedList = context.getString(R.string.linkedList);
        copyOnWrite = context.getString(R.string.copyOnWrite);
        defaultItems = Arrays.asList(new HeaderItem(context.getString(R.string.add_in_the_beginning_collection)),
                new ResultItem(-1, arrayList, 100),
                new ResultItem(-1, linkedList, 101),
                new ResultItem(-1, copyOnWrite, 102),
                new HeaderItem(context.getString(R.string.add_in_the_middle_collection)),
                new ResultItem(-1, arrayList, 103),
                new ResultItem(-1, linkedList, 104),
                new ResultItem(-1, copyOnWrite, 105),
                new HeaderItem(context.getString(R.string.add_in_the_end_collection)),
                new ResultItem(-1, arrayList, 106),
                new ResultItem(-1, linkedList, 107),
                new ResultItem(-1, copyOnWrite, 108),
                new HeaderItem(context.getString(R.string.search_by_value_collection)),
                new ResultItem(-1, arrayList, 109),
                new ResultItem(-1, linkedList, 110),
                new ResultItem(-1, copyOnWrite, 111),
                new HeaderItem(context.getString(R.string.remove_in_the_beginning_collection)),
                new ResultItem(-1, arrayList, 112),
                new ResultItem(-1, linkedList, 113),
                new ResultItem(-1, copyOnWrite, 114),
                new HeaderItem(context.getString(R.string.remove_in_the_middle_collection)),
                new ResultItem(-1, arrayList, 115),
                new ResultItem(-1, linkedList, 116),
                new ResultItem(-1, copyOnWrite, 117),
                new HeaderItem(context.getString(R.string.remove_in_the_end_collection)),
                new ResultItem(-1, arrayList, 118),
                new ResultItem(-1, linkedList, 119),
                new ResultItem(-1, copyOnWrite, 120));
        return defaultItems;
    }

    @Override
    public void getDataFromReceiver(int resultCollection, int idCollection) {
        for (int i = 0; i < defaultItems.size(); i++) {
            BaseItem item = defaultItems.get(i);
            if (item instanceof ResultItem && ((ResultItem) item).getId() == idCollection) {
                ResultItem resultItem = new ResultItem(resultCollection,
                        ((ResultItem) item).getTitle(), ((ResultItem) item).getId());
                collectionView.onCollectionItemsReceived(resultItem);
            }
        }
    }
}
