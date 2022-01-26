package com.wenger.collectionsandmaps.mapsCalculation;

import com.wenger.collectionsandmaps.BaseItem;
import com.wenger.collectionsandmaps.HeaderItem;
import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.ResultItem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MapsCalculationPresenter implements IMapsPresenter {

    private CalculationMapsFragment mapsView;
    private List<BaseItem> defaultItems;
    public static final int MAPS_ID_121 = 121;
    public static final int MAPS_ID_122 = 122;
    public static final int MAPS_ID_123 = 123;
    public static final int MAPS_ID_124 = 124;
    public static final int MAPS_ID_125 = 125;
    public static final int MAPS_ID_126 = 126;
    private final int VALUE = 500000;

    @Inject
    public MapsCalculationPresenter(CalculationMapsFragment mapsView) {
        this.mapsView = mapsView;
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

    private TreeMap<Integer, Integer> createTreeMap(Integer mapsSize) {
        TreeMap<Integer, Integer> list = new TreeMap();
        for (int i = 0, y = 0; i < mapsSize; i++, y++) {
            list.put(y, i);
        }
        return list;
    }

    private HashMap<Integer, Integer> createHashMap(Integer mapsSize) {
        HashMap<Integer, Integer> list = new HashMap();
        for (int i = 0, y = 0; i < mapsSize; i++, y++) {
            list.put(y, i);
        }
        return list;
    }

    private Integer timeResult(long endTime, long startTime) {
        long timeElapsed = endTime - startTime;
        return (int) timeElapsed;
    }

    public void treeMapAddingNew(Integer mapsSize) {
        Single.fromCallable(() -> {
            TreeMap<Integer, Integer> map = createTreeMap(mapsSize);
            long startTime = System.currentTimeMillis();
            map.put(map.size() + 1, VALUE);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    getNewItem(integer, MAPS_ID_121);
                });
    }

    public void treeMapSearchByKey(Integer mapsSize) {
        Single.fromCallable(() -> {
            TreeMap<Integer, Integer> map = createTreeMap(mapsSize);
            long startTime = System.currentTimeMillis();
            for (int z = 0; z < mapsSize; z++) {
                if (map.get(z) == 500) {
                    Integer result = map.get(z);
                }
            }
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    getNewItem(integer, MAPS_ID_123);
                });
    }

    public void treeMapRemove(Integer mapsSize) {
        Single.fromCallable(() -> {
            TreeMap<Integer, Integer> map = createTreeMap(mapsSize);
            long startTime = System.currentTimeMillis();
            map.remove(100);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    getNewItem(integer, MAPS_ID_125);
                });
    }

    public void hashMapAddingNew(Integer mapsSize) {
        Single.fromCallable(() -> {
            HashMap<Integer, Integer> map = createHashMap(mapsSize);
            long startTime = System.currentTimeMillis();
            map.put(map.size() + 1, VALUE);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    getNewItem(integer, MAPS_ID_122);
                });
    }

    public void hashMapSearchByKey(Integer mapsSize) {
        Single.fromCallable(() -> {
            HashMap<Integer, Integer> map = createHashMap(mapsSize);
            Integer key = 500;
            long startTime = System.currentTimeMillis();
            for (int z = 0; z < mapsSize; z++) {
                if (key.equals(map.get(z))) {
                    Integer result = map.get(z);
                }
            }
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    getNewItem(integer, MAPS_ID_124);
                });
    }

    public void hashMapRemove(Integer mapsSize) {
        Single.fromCallable(() -> {
            HashMap<Integer, Integer> map = createHashMap(mapsSize);
            long startTime = System.currentTimeMillis();
            map.remove(100);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    getNewItem(integer, MAPS_ID_126);
                });
    }

    @Override
    public void getNewItem(int resultMaps, int idMaps) {
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
