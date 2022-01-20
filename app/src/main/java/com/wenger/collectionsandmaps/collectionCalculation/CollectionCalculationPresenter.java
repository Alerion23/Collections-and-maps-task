package com.wenger.collectionsandmaps.collectionCalculation;

import com.wenger.collectionsandmaps.BaseItem;
import com.wenger.collectionsandmaps.HeaderItem;
import com.wenger.collectionsandmaps.ResultItem;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;


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
    public List<BaseItem> createDefaultList(String arrayListTitle,
                                            String linkedListTitle,
                                            String copyOnWriteTitle,
                                            String addITheBeginningCollectionHeader,
                                            String addInTheMiddleCollectionHeader,
                                            String addInTheEndCollectionHeader,
                                            String searchByValueCollectionHeader,
                                            String removeInTheBeginningCollectionHeader,
                                            String removeInTheMiddleCollectionHeader,
                                            String removeInTheEndCollectionHeader) {
        defaultItems = Arrays.asList(
                new HeaderItem(addITheBeginningCollectionHeader),
                new ResultItem(-1, arrayListTitle, collectionId100),
                new ResultItem(-1, linkedListTitle, collectionId101),
                new ResultItem(-1, copyOnWriteTitle, collectionId102),
                new HeaderItem(addInTheMiddleCollectionHeader),
                new ResultItem(-1, arrayListTitle, collectionId103),
                new ResultItem(-1, linkedListTitle, collectionId104),
                new ResultItem(-1, copyOnWriteTitle, collectionId105),
                new HeaderItem(addInTheEndCollectionHeader),
                new ResultItem(-1, arrayListTitle, collectionId106),
                new ResultItem(-1, linkedListTitle, collectionId107),
                new ResultItem(-1, copyOnWriteTitle, collectionId108),
                new HeaderItem(searchByValueCollectionHeader),
                new ResultItem(-1, arrayListTitle, collectionId109),
                new ResultItem(-1, linkedListTitle, collectionId110),
                new ResultItem(-1, copyOnWriteTitle, collectionId111),
                new HeaderItem(removeInTheBeginningCollectionHeader),
                new ResultItem(-1, arrayListTitle, collectionId112),
                new ResultItem(-1, linkedListTitle, collectionId113),
                new ResultItem(-1, copyOnWriteTitle, collectionId114),
                new HeaderItem(removeInTheMiddleCollectionHeader),
                new ResultItem(-1, arrayListTitle, collectionId115),
                new ResultItem(-1, linkedListTitle, collectionId116),
                new ResultItem(-1, copyOnWriteTitle, collectionId117),
                new HeaderItem(removeInTheEndCollectionHeader),
                new ResultItem(-1, arrayListTitle, collectionId118),
                new ResultItem(-1, linkedListTitle, collectionId119),
                new ResultItem(-1, copyOnWriteTitle, collectionId120));
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
