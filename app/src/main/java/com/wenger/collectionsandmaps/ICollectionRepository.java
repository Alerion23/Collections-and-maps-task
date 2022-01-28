package com.wenger.collectionsandmaps;


import io.reactivex.rxjava3.core.Single;

public interface ICollectionRepository {

    public Single arrayListAddInTheBeginning(Integer collectionSize);

    public Single arrayListAddInTheMiddle(Integer collectionSize);

    public Single arrayListAddInTheEnd(Integer collectionSize);

    public Single arrayListSearchBy(Integer collectionSize);

    public Single arrayListRemoveInTheBeginning(Integer collectionSize);

    public Single arrayListRemoveInTheMiddle(Integer collectionSize);

    public Single arrayListRemoveInTheEnd(Integer collectionSize);

    public Single linkInListAddInTheBeginning(Integer collectionSize);

    public Single linkInListAddInTheMiddle(Integer collectionSize);

    public Single linkInListAddInTheEnd(Integer collectionSize);

    public Single linkInListSearByValue(Integer collectionSize);

    public Single linkInListRemoveInTheBeginning(Integer collectionSize);

    public Single linkInListRemoveInTheMiddle(Integer collectionSize);

    public Single linkInListRemoveInTheEnd(Integer collectionSize);

    public Single copyOnWriteAddInTheBeginning(Integer collectionSize);

    public Single copyOnWriteAddInTheMiddle(Integer collectionSize);

    public Single copyOnWriteAddInTheEnd(Integer collectionSize);

    public Single copyOnWriteSearchByValue(Integer collectionSize);

    public Single copyOnWriteRemovingInTheBeginning(Integer collectionSize);

    public Single copyOnWriteRemovingInTheMiddle(Integer collectionSize);

    public Single copyOnWriteRemovingInTheEnd(Integer collectionSize);

}
