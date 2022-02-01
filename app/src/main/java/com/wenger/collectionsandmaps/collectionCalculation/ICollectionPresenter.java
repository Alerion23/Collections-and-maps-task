package com.wenger.collectionsandmaps.collectionCalculation;

import com.wenger.collectionsandmaps.BaseItem;

import java.util.List;

public interface ICollectionPresenter {

    List<BaseItem> createDefaultList();

    void collectionCalculation(int collectionSize);

    void stop();

    void updateItem(int resultCollection, int idCollection);
}
