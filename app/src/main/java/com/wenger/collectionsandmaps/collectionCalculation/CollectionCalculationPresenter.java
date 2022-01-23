package com.wenger.collectionsandmaps.collectionCalculation;

import com.wenger.collectionsandmaps.BaseItem;
import com.wenger.collectionsandmaps.HeaderItem;
import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.ResultItem;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;


public class CollectionCalculationPresenter implements ICollectionPresenter {

    private List<BaseItem> defaultItems;
    private CalculationCollectionsFragment collectionView;
    public static final int COLLECTION_ID_100 = 100;
    public static final int COLLECTION_ID_101 = 101;
    public static final int COLLECTION_ID_102 = 102;
    public static final int COLLECTION_ID_103 = 103;
    public static final int COLLECTION_ID_104 = 104;
    public static final int COLLECTION_ID_105 = 105;
    public static final int COLLECTION_ID_106 = 106;
    public static final int COLLECTION_ID_107 = 107;
    public static final int COLLECTION_ID_108 = 108;
    public static final int COLLECTION_ID_109 = 109;
    public static final int COLLECTION_ID_110 = 110;
    public static final int COLLECTION_ID_111 = 111;
    public static final int COLLECTION_ID_112 = 112;
    public static final int COLLECTION_ID_113 = 113;
    public static final int COLLECTION_ID_114 = 114;
    public static final int COLLECTION_ID_115 = 115;
    public static final int COLLECTION_ID_116 = 116;
    public static final int COLLECTION_ID_117 = 117;
    public static final int COLLECTION_ID_118 = 118;
    public static final int COLLECTION_ID_119 = 119;
    public static final int COLLECTION_ID_120 = 120;

    @Inject
    public CollectionCalculationPresenter(CalculationCollectionsFragment collectionView) {
        this.collectionView = collectionView;
    }

    @Override
    public List<BaseItem> createDefaultList() {
        int arrayListTitle = R.string.arrayList;
        int linkedListTitle = R.string.linkedList;
        int copyOnWriteTitle = R.string.copyOnWrite;
        int addITheBeginningCollectionHeader = R.string.add_in_the_beginning_collection;
        int addInTheMiddleCollectionHeader = R.string.add_in_the_middle_collection;
        int addInTheEndCollectionHeader = R.string.add_in_the_end_collection;
        int searchByValueCollectionHeader = R.string.search_by_value_collection;
        int removeInTheBeginningCollectionHeader = R.string.remove_in_the_beginning_collection;
        int removeInTheMiddleCollectionHeader = R.string.remove_in_the_middle_collection;
        int removeInTheEndCollectionHeader = R.string.remove_in_the_end_collection;
        defaultItems = Arrays.asList(
                new HeaderItem(addITheBeginningCollectionHeader),
                new ResultItem(-1, arrayListTitle, COLLECTION_ID_100),
                new ResultItem(-1, linkedListTitle, COLLECTION_ID_101),
                new ResultItem(-1, copyOnWriteTitle, COLLECTION_ID_102),
                new HeaderItem(addInTheMiddleCollectionHeader),
                new ResultItem(-1, arrayListTitle, COLLECTION_ID_103),
                new ResultItem(-1, linkedListTitle, COLLECTION_ID_104),
                new ResultItem(-1, copyOnWriteTitle, COLLECTION_ID_105),
                new HeaderItem(addInTheEndCollectionHeader),
                new ResultItem(-1, arrayListTitle, COLLECTION_ID_106),
                new ResultItem(-1, linkedListTitle, COLLECTION_ID_107),
                new ResultItem(-1, copyOnWriteTitle, COLLECTION_ID_108),
                new HeaderItem(searchByValueCollectionHeader),
                new ResultItem(-1, arrayListTitle, COLLECTION_ID_109),
                new ResultItem(-1, linkedListTitle, COLLECTION_ID_110),
                new ResultItem(-1, copyOnWriteTitle, COLLECTION_ID_111),
                new HeaderItem(removeInTheBeginningCollectionHeader),
                new ResultItem(-1, arrayListTitle, COLLECTION_ID_112),
                new ResultItem(-1, linkedListTitle, COLLECTION_ID_113),
                new ResultItem(-1, copyOnWriteTitle, COLLECTION_ID_114),
                new HeaderItem(removeInTheMiddleCollectionHeader),
                new ResultItem(-1, arrayListTitle, COLLECTION_ID_115),
                new ResultItem(-1, linkedListTitle, COLLECTION_ID_116),
                new ResultItem(-1, copyOnWriteTitle, COLLECTION_ID_117),
                new HeaderItem(removeInTheEndCollectionHeader),
                new ResultItem(-1, arrayListTitle, COLLECTION_ID_118),
                new ResultItem(-1, linkedListTitle, COLLECTION_ID_119),
                new ResultItem(-1, copyOnWriteTitle, COLLECTION_ID_120));
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
