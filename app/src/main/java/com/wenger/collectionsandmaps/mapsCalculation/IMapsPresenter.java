package com.wenger.collectionsandmaps.mapsCalculation;

import com.wenger.collectionsandmaps.BaseItem;

import java.util.List;

public interface IMapsPresenter {

    List<BaseItem> createDefaultList();

    void mapsCalculation(int mapsSize);

    void updateItem(int resultMaps, int idMaps);
}
