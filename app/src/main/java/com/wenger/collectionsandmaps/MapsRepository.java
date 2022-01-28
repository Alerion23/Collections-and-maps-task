package com.wenger.collectionsandmaps;

import java.util.HashMap;
import java.util.TreeMap;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MapsRepository implements IMapsRepository {

    private final int VALUE = 500000;

    @Inject
    public MapsRepository() {
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

    private Integer calculateTime(long endTime, long startTime) {
        long timeElapsed = endTime - startTime;
        return (int) timeElapsed;
    }

    @Override
    public Single treeMapAddingNew(Integer mapsSize) {
        return Single.fromCallable(() -> {
            TreeMap<Integer, Integer> map = createTreeMap(mapsSize);
            long startTime = System.currentTimeMillis();
            map.put(map.size() + 1, VALUE);
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single treeMapSearchByKey(Integer mapsSize) {
        return Single.fromCallable(() -> {
            TreeMap<Integer, Integer> map = createTreeMap(mapsSize);
            long startTime = System.currentTimeMillis();
            for (int z = 0; z < mapsSize; z++) {
                if (map.get(z) == 500) {
                    Integer result = map.get(z);
                }
            }
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single treeMapRemove(Integer mapsSize) {
        return Single.fromCallable(() -> {
            TreeMap<Integer, Integer> map = createTreeMap(mapsSize);
            long startTime = System.currentTimeMillis();
            map.remove(100);
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single hashMapAddingNew(Integer mapsSize) {
        return Single.fromCallable(() -> {
            HashMap<Integer, Integer> map = createHashMap(mapsSize);
            long startTime = System.currentTimeMillis();
            map.put(map.size() + 1, VALUE);
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single hashMapSearchByKey(Integer mapsSize) {
        return Single.fromCallable(() -> {
            HashMap<Integer, Integer> map = createHashMap(mapsSize);
            Integer key = 500;
            long startTime = System.currentTimeMillis();
            for (int z = 0; z < mapsSize; z++) {
                if (key.equals(map.get(z))) {
                    Integer result = map.get(z);
                }
            }
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single hashMapRemove(Integer mapsSize) {
        return Single.fromCallable(() -> {
            HashMap<Integer, Integer> map = createHashMap(mapsSize);
            long startTime = System.currentTimeMillis();
            map.remove(100);
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
