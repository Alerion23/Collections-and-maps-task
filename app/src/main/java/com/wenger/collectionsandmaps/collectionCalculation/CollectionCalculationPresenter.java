package com.wenger.collectionsandmaps.collectionCalculation;

import com.wenger.collectionsandmaps.BaseItem;
import com.wenger.collectionsandmaps.CollectionRepository;
import com.wenger.collectionsandmaps.HeaderItem;
import com.wenger.collectionsandmaps.ICollectionRepository;
import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.ResultItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class CollectionCalculationPresenter implements ICollectionPresenter {

    private List<BaseItem> defaultItems;
    private CalculationCollectionsFragment collectionView;
    private CompositeDisposable disposables = new CompositeDisposable();
    private ICollectionRepository collectionRepository;

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
    public CollectionCalculationPresenter(CalculationCollectionsFragment collectionView, ICollectionRepository collectionRepository) {
        this.collectionView = collectionView;
        this.collectionRepository = collectionRepository;
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
    public void collectionCalculation(int collectionSize) {
        arrayListAddInTheBeginning(collectionSize);
        linkInListAddInTheBeginning(collectionSize);
        copyOnWriteAddInTheBeginning(collectionSize);
        arrayListAddInTheMiddle(collectionSize);
        linkInListAddInTheMiddle(collectionSize);
        copyOnWriteAddInTheMiddle(collectionSize);
        arrayListAddInTheEnd(collectionSize);
        linkInListAddInTheEnd(collectionSize);
        copyOnWriteAddInTheEnd(collectionSize);
        arrayListSearchBy(collectionSize);
        linkInListSearByValue(collectionSize);
        copyOnWriteSearchByValue(collectionSize);
        arrayListRemoveInTheBeginning(collectionSize);
        linkInListRemoveInTheBeginning(collectionSize);
        copyOnWriteRemovingInTheBeginning(collectionSize);
        arrayListRemoveInTheMiddle(collectionSize);
        linkInListRemoveInTheMiddle(collectionSize);
        copyOnWriteRemovingInTheMiddle(collectionSize);
        arrayListRemoveInTheEnd(collectionSize);
        linkInListRemoveInTheEnd(collectionSize);
        copyOnWriteRemovingInTheEnd(collectionSize);
    }

    @Override
    public void stop() {
        disposables.clear();
    }

    private void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

    private void arrayListAddInTheBeginning(Integer collectionSize) {
        addDisposable(collectionRepository.arrayListAddInTheBeginning(collectionSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, COLLECTION_ID_100);
                }));

    }

    private void arrayListAddInTheMiddle(Integer collectionSize) {
        addDisposable(collectionRepository.arrayListAddInTheMiddle(collectionSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, COLLECTION_ID_103);
                }));

    }

    private void arrayListAddInTheEnd(Integer collectionSize) {
        addDisposable(collectionRepository.arrayListAddInTheEnd(collectionSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, COLLECTION_ID_106);
                }));
    }

    private void arrayListSearchBy(Integer collectionSize) {
        addDisposable(collectionRepository.arrayListSearchBy(collectionSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, COLLECTION_ID_109);
                }));
    }

    private void arrayListRemoveInTheBeginning(Integer collectionSize) {
        addDisposable(collectionRepository.arrayListRemoveInTheBeginning(collectionSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, COLLECTION_ID_112);
                }));
    }

    private void arrayListRemoveInTheMiddle(Integer collectionSize) {
        addDisposable(collectionRepository.arrayListRemoveInTheMiddle(collectionSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, COLLECTION_ID_115);
                }));
    }

    private void arrayListRemoveInTheEnd(Integer collectionSize) {
        addDisposable(collectionRepository.arrayListRemoveInTheEnd(collectionSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, COLLECTION_ID_118);
                }));
    }

    private void linkInListAddInTheBeginning(Integer collectionSize) {
        addDisposable(collectionRepository.linkInListAddInTheBeginning(collectionSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, COLLECTION_ID_101);
                }));
    }

    private void linkInListAddInTheMiddle(Integer collectionSize) {
        addDisposable(collectionRepository.linkInListAddInTheMiddle(collectionSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, COLLECTION_ID_104);
                }));
    }

    private void linkInListAddInTheEnd(Integer collectionSize) {
        addDisposable(collectionRepository.linkInListAddInTheEnd(collectionSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, COLLECTION_ID_107);
                }));
    }

    private void linkInListSearByValue(Integer collectionSize) {
        addDisposable(collectionRepository.linkInListSearByValue(collectionSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, COLLECTION_ID_110);
                }));
    }

    private void linkInListRemoveInTheBeginning(Integer collectionSize) {
        addDisposable(collectionRepository.linkInListRemoveInTheBeginning(collectionSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, COLLECTION_ID_113);
                }));
    }

    private void linkInListRemoveInTheMiddle(Integer collectionSize) {
        addDisposable(collectionRepository.linkInListRemoveInTheMiddle(collectionSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, COLLECTION_ID_116);
                }));
    }

    private void linkInListRemoveInTheEnd(Integer collectionSize) {
        addDisposable(collectionRepository.linkInListRemoveInTheEnd(collectionSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, COLLECTION_ID_119);
                }));
    }

    private void copyOnWriteAddInTheBeginning(Integer collectionSize) {
        addDisposable(collectionRepository.copyOnWriteAddInTheBeginning(collectionSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, COLLECTION_ID_102);
                }));
    }

    private void copyOnWriteAddInTheMiddle(Integer collectionSize) {
        addDisposable(collectionRepository.copyOnWriteAddInTheMiddle(collectionSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, COLLECTION_ID_105);
                }));
    }

    private void copyOnWriteAddInTheEnd(Integer collectionSize) {
        addDisposable(collectionRepository.copyOnWriteAddInTheEnd(collectionSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, COLLECTION_ID_108);
                }));
    }

    private void copyOnWriteSearchByValue(Integer collectionSize) {
        addDisposable(collectionRepository.copyOnWriteSearchByValue(collectionSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, COLLECTION_ID_111);
                }));
    }

    private void copyOnWriteRemovingInTheBeginning(Integer collectionSize) {
        addDisposable(collectionRepository.copyOnWriteRemovingInTheBeginning(collectionSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, COLLECTION_ID_114);
                }));
    }

    private void copyOnWriteRemovingInTheMiddle(Integer collectionSize) {
        addDisposable(collectionRepository.copyOnWriteRemovingInTheMiddle(collectionSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, COLLECTION_ID_117);
                }));
    }

    private void copyOnWriteRemovingInTheEnd(Integer collectionSize) {
        addDisposable(collectionRepository.copyOnWriteRemovingInTheEnd(collectionSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, COLLECTION_ID_120);
                }));
    }

    @Override
    public void updateItem(int resultCollection, int idCollection) {
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
