package com.wenger.collectionsandmaps.mapsCalculation;

import com.wenger.collectionsandmaps.BaseItem;
import com.wenger.collectionsandmaps.HeaderItem;
import com.wenger.collectionsandmaps.IMapsRepository;
import com.wenger.collectionsandmaps.MapsRepository;
import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.ResultItem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MapsCalculationPresenter implements IMapsPresenter {

    private CalculationMapsFragment mapsView;
    private List<BaseItem> defaultItems;
    private CompositeDisposable disposables = new CompositeDisposable();
    private IMapsRepository mapsRepository;
    public static final int MAPS_ID_121 = 121;
    public static final int MAPS_ID_122 = 122;
    public static final int MAPS_ID_123 = 123;
    public static final int MAPS_ID_124 = 124;
    public static final int MAPS_ID_125 = 125;
    public static final int MAPS_ID_126 = 126;

    @Inject
    public MapsCalculationPresenter(CalculationMapsFragment mapsView, IMapsRepository mapsRepository) {
        this.mapsView = mapsView;
        this.mapsRepository = mapsRepository;
    }

    @Override
    public List<BaseItem> createDefaultList() {
        int treeMapTitle = R.string.treeMap;
        int hashMapTitle = R.string.hashMap;
        int addingNewHeader = R.string.adding_new_map;
        int searchByKeyHeader = R.string.search_by_key_map;
        int removingHeader = R.string.removing_map;
        defaultItems = Arrays.asList(
                new HeaderItem(addingNewHeader),
                new ResultItem(-1, treeMapTitle, MAPS_ID_121),
                new ResultItem(-1, hashMapTitle, MAPS_ID_122),
                new HeaderItem(searchByKeyHeader),
                new ResultItem(-1, treeMapTitle, MAPS_ID_123),
                new ResultItem(-1, hashMapTitle, MAPS_ID_124),
                new HeaderItem(removingHeader),
                new ResultItem(-1, treeMapTitle, MAPS_ID_125),
                new ResultItem(-1, hashMapTitle, MAPS_ID_126));
        return defaultItems;
    }

    @Override
    public void mapsCalculation(int mapsSize) {
        treeMapAddingNew(mapsSize);
        hashMapAddingNew(mapsSize);
        treeMapSearchByKey(mapsSize);
        hashMapSearchByKey(mapsSize);
        treeMapRemove(mapsSize);
        hashMapRemove(mapsSize);
    }

    @Override
    public void stop() {
        disposables.clear();
    }

    private void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

    public void treeMapAddingNew(Integer mapsSize) {
        addDisposable(mapsRepository.treeMapAddingNew(mapsSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, MAPS_ID_121);
                }));
    }

    public void treeMapSearchByKey(Integer mapsSize) {
        addDisposable(mapsRepository.treeMapSearchByKey(mapsSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, MAPS_ID_123);
                }));
    }

    public void treeMapRemove(Integer mapsSize) {
        addDisposable(mapsRepository.treeMapRemove(mapsSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, MAPS_ID_125);
                }));
    }

    public void hashMapAddingNew(Integer mapsSize) {
        addDisposable(mapsRepository.hashMapAddingNew(mapsSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, MAPS_ID_122);
                }));
    }

    public void hashMapSearchByKey(Integer mapsSize) {
        addDisposable(mapsRepository.hashMapSearchByKey(mapsSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, MAPS_ID_124);
                }));
    }

    public void hashMapRemove(Integer mapsSize) {
        addDisposable(mapsRepository.hashMapRemove(mapsSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    updateItem((Integer) integer, MAPS_ID_126);
                }));
    }

    @Override
    public void updateItem(int resultMaps, int idMaps) {
        for (int y = 0; y < defaultItems.size(); y++) {
            BaseItem item = defaultItems.get(y);
            if (item instanceof ResultItem && ((ResultItem) item).getId() == idMaps) {
                ResultItem resultItem = new ResultItem(resultMaps,
                        ((ResultItem) item).getTitle(), ((ResultItem) item).getId());
                mapsView.onMapsItemReceived(resultItem);
            }
        }
    }
}
