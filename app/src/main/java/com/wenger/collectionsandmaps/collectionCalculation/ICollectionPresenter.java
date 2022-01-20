package com.wenger.collectionsandmaps.collectionCalculation;

import com.wenger.collectionsandmaps.BaseItem;

import java.util.List;

public interface ICollectionPresenter {

    List<BaseItem> createDefaultList(String arrayListTitle,
                                     String linkedListTitle,
                                     String copyOnWriteTitle,
                                     String addITheBeginningCollectionHeader,
                                     String addInTheMiddleCollectionHeader,
                                     String addInTheEndCollectionHeader,
                                     String searchByValueCollectionHeader,
                                     String removeInTheBeginningCollectionHeader,
                                     String removeInTheMiddleCollectionHeader,
                                     String removeInTheEndCollectionHeader);

    void getDataFromReceiver(int resultCollection, int idCollection);
}
