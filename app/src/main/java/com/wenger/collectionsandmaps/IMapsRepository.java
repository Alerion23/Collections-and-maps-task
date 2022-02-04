package com.wenger.collectionsandmaps;

import io.reactivex.rxjava3.core.Single;

public interface IMapsRepository {

    public Single treeMapAddingNew(Integer mapsSize);

    public Single treeMapSearchByKey(Integer mapsSize);

    public Single treeMapRemove(Integer mapsSize);

    public Single hashMapAddingNew(Integer mapsSize);

    public Single hashMapSearchByKey(Integer mapsSize);

    public Single hashMapRemove(Integer mapsSize);

}
