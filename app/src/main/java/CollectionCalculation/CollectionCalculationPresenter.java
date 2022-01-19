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

    private List<BaseItem> defaultItems;
    private CalculationCollectionsFragment collectionView;
    private int collectionId100 = 100;
    private int collectionId101 = 101;
    private int collectionId102 = 102;
    private int collectionId103 = 103;
    private int collectionId104 = 104;
    private int collectionId105 = 105;
    private int collectionId106 = 106;
    private int collectionId107 = 107;
    private int collectionId108 = 108;
    private int collectionId109 = 109;
    private int collectionId110 = 110;
    private int collectionId111 = 111;
    private int collectionId112 = 112;
    private int collectionId113 = 113;
    private int collectionId114 = 114;
    private int collectionId115 = 115;
    private int collectionId116 = 116;
    private int collectionId117 = 117;
    private int collectionId118 = 118;
    private int collectionId119 = 119;
    private int collectionId120 = 120;

    @Inject
    public CollectionCalculationPresenter(CalculationCollectionsFragment collectionView) {
        this.collectionView = collectionView;
    }

    @Override
    public List<BaseItem> createDefaultList(String arrayList, String linkedList, String copyOnWrite,
                                            String addITheBeginningCollection, String addInTheMiddleCollection,
                                            String addInTheEndCollection, String searchByValueCollection,
                                            String removeInTheBeginningCollection, String removeInTheMiddleCollection,
                                            String removeInTheEndCollection) {
        defaultItems = Arrays.asList(
                new HeaderItem(addITheBeginningCollection),
                new ResultItem(-1, arrayList, collectionId100),
                new ResultItem(-1, linkedList, collectionId101),
                new ResultItem(-1, copyOnWrite, collectionId102),
                new HeaderItem(addInTheMiddleCollection),
                new ResultItem(-1, arrayList, collectionId103),
                new ResultItem(-1, linkedList, collectionId104),
                new ResultItem(-1, copyOnWrite, collectionId105),
                new HeaderItem(addInTheEndCollection),
                new ResultItem(-1, arrayList, collectionId106),
                new ResultItem(-1, linkedList, collectionId107),
                new ResultItem(-1, copyOnWrite, collectionId108),
                new HeaderItem(searchByValueCollection),
                new ResultItem(-1, arrayList, collectionId109),
                new ResultItem(-1, linkedList, collectionId110),
                new ResultItem(-1, copyOnWrite, collectionId111),
                new HeaderItem(removeInTheBeginningCollection),
                new ResultItem(-1, arrayList, collectionId112),
                new ResultItem(-1, linkedList, collectionId113),
                new ResultItem(-1, copyOnWrite, collectionId114),
                new HeaderItem(removeInTheMiddleCollection),
                new ResultItem(-1, arrayList, collectionId115),
                new ResultItem(-1, linkedList, collectionId116),
                new ResultItem(-1, copyOnWrite, collectionId117),
                new HeaderItem(removeInTheEndCollection),
                new ResultItem(-1, arrayList, collectionId118),
                new ResultItem(-1, linkedList, collectionId119),
                new ResultItem(-1, copyOnWrite, collectionId120));
        return defaultItems;
    }

    @Override
    public void getDataFromReceiver(int resultCollection, int idCollection) {
        for (int i = 0; i < defaultItems.size(); i++) {
            BaseItem item = defaultItems.get(i);
            if (item instanceof ResultItem && ((ResultItem) item).getId() == idCollection) {
                ResultItem resultItem = new ResultItem(resultCollection,
                        ((ResultItem) item).getTitle(), ((ResultItem) item).getId());
                collectionView.onCollectionItemReceived(resultItem);
            }
        }
    }
}
