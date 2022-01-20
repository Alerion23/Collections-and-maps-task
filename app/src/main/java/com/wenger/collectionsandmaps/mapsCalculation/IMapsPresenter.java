package com.wenger.collectionsandmaps.mapsCalculation;

import com.wenger.collectionsandmaps.BaseItem;

import java.util.List;

public interface IMapsPresenter {

    List<BaseItem> createDefaultList(String treeMapTitle, String hashMapTitle, String addingNewHeader,
                                     String searchByKeyHeader, String removingHeader);

    void getDataFromReceiver(int resultMaps, int idMaps);
}
