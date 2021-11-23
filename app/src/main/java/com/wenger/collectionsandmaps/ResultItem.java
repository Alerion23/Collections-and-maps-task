package com.wenger.collectionsandmaps;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ResultItem extends BaseItem {

    Integer collectionSize;
    String title;

    public ResultItem(Integer collectionSize, String title) {
        super("result");
        this.title = title;
        this.collectionSize = collectionSize;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void arrayListAddInTheBeginning(IGetResult getResult) {
        Single.fromCallable(() -> {
            ArrayList<Integer> size = new ArrayList<Integer>();
            for (int y = 0; y < collectionSize; y++) {
                size.add(y);
            }
            long startTime = System.currentTimeMillis();
            size.add(0, 500000);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);

    }


    public void arrayListAddInTheMiddle(IGetResult getResult) {
        Single.fromCallable(() -> {
            ArrayList<Integer> size = new ArrayList<>();
            for (int y = 0; y < collectionSize; y++) {
                size.add(y);
            }
            long startTime = System.currentTimeMillis();
            size.add(size.size() / 2, 500000);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);

    }

    public void arrayListAddInTheEnd(IGetResult getResult) {
        Single.fromCallable(() -> {
            ArrayList<Integer> size = new ArrayList<>();
            for (int y = 0; y < collectionSize; y++) {
                size.add(y);
            }
            long startTime = System.currentTimeMillis();
            size.add(500000);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void arrayListSearchBy(IGetResult getResult) {
        Single.fromCallable(() -> {
            ArrayList<Integer> size = new ArrayList<>();
            Integer value = 500000;
            for (int i = 0; i < collectionSize; i++) {
                size.add(i);
            }
            long startTime = System.currentTimeMillis();
            for (int y = 0; y < collectionSize; y++) {
                if (value.equals(size.get(y))) {
                    return y;
                }
            }
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void arrayListRemoveInTheBeginning(IGetResult getResult) {
        Single.fromCallable(() -> {
            ArrayList<Integer> size = new ArrayList<>();
            for (int i = 0; i < collectionSize; i++) {
                size.add(i);
            }
            long startTime = System.currentTimeMillis();
            size.remove(0);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void arrayListRemoveInTheMiddle(IGetResult getResult) {
        Single.fromCallable(() -> {
            ArrayList<Integer> size = new ArrayList<>();
            for (int i = 0; i < collectionSize; i++) {
                size.add(i);
            }
            long startTime = System.currentTimeMillis();
            size.remove(size.size() / 2);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void arrayListRemoveInTheEnd(IGetResult getResult) {
        Single.fromCallable(() -> {
            ArrayList<Integer> size = new ArrayList<>();
            for (int i = 0; i < collectionSize; i++) {
                size.add(i);
            }
            long startTime = System.currentTimeMillis();
            size.remove(size.size() - 1);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void linkInListAddInTheBeginning(IGetResult getResult) {
        Single.fromCallable(() -> {
            LinkedList<Integer> size = new LinkedList<>();
            for (int i = 0; i < collectionSize; i++) {
                size.add(i);
            }
            long startTime = System.currentTimeMillis();
            size.addFirst(500000);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void linkInListAddInTheMiddle(IGetResult getResult) {
        Single.fromCallable(() -> {
            LinkedList<Integer> size = new LinkedList<>();
            for (int i = 0; i < collectionSize; i++) {
                size.add(i);
            }
            long startTime = System.currentTimeMillis();
            size.add(size.size() / 2, 500000);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void linkInListAddInTheEnd(IGetResult getResult) {
        Single.fromCallable(() -> {
            LinkedList<Integer> size = new LinkedList<>();
            for (int i = 0; i < collectionSize; i++) {
                size.add(i);
            }
            long startTime = System.currentTimeMillis();
            size.addLast(500000);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void linkInListSearByValue(IGetResult getResult) {
        Single.fromCallable(() -> {
            LinkedList<Integer> size = new LinkedList<>();
            Integer value = 500000;
            for (int i = 0; i < collectionSize; i++) {
                size.add(i);
            }
            long startTime = System.currentTimeMillis();
            for (int y = 0; y < collectionSize; y++) {
                if (value.equals(size.get(y))) {
                    return y;
                }
            }
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void linkInListRemoveInTheBeginning(IGetResult getResult) {
        Single.fromCallable(() -> {
            LinkedList<Integer> size = new LinkedList<>();
            for (int i = 0; i < collectionSize; i++) {
                size.add(i);
            }
            long startTime = System.currentTimeMillis();
            size.removeFirst();
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void linkInListRemoveInTheMiddle(IGetResult getResult) {
        Single.fromCallable(() -> {
            LinkedList<Integer> size = new LinkedList<>();
            for (int i = 0; i < collectionSize; i++) {
                size.add(i);
            }
            long startTime = System.currentTimeMillis();
            size.remove(size.size() / 2);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void linkInListRemoveInTheEnd(IGetResult getResult) {
        Single.fromCallable(() -> {
            LinkedList<Integer> size = new LinkedList<>();
            for (int i = 0; i < collectionSize; i++) {
                size.add(i);
            }
            long startTime = System.currentTimeMillis();
            size.removeLast();
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void copyOnWriteAddInTheBeginning(IGetResult getResult) {
        Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> size = new CopyOnWriteArrayList<>();
            for (int i = 0; i < collectionSize; i++) {
                size.add(i);
            }
            long startTime = System.currentTimeMillis();
            size.add(0, 500000);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void copyOnWriteAddInTheMiddle(IGetResult getResult) {
        Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> size = new CopyOnWriteArrayList<>();
            for (int i = 0; i < collectionSize; i++) {
                size.add(i);
            }
            long startTime = System.currentTimeMillis();
            size.add(size.size() / 2, 500000);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void copyOnWriteAddInTheEnd(IGetResult getResult) {
        Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> size = new CopyOnWriteArrayList<>();
            for (int i = 0; i < collectionSize; i++) {
                size.add(i);
            }
            long startTime = System.currentTimeMillis();
            size.add(500000);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void copyOnWriteSearchByValue(IGetResult getResult) {
        Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> size = new CopyOnWriteArrayList<>();
            Integer value = 500000;
            for (int i = 0; i < collectionSize; i++) {
                size.add(i);
            }
            long startTime = System.currentTimeMillis();
            for (int y = 0; y < collectionSize; y++) {
                if (value.equals(size.get(y))) {
                    return y;
                }
            }
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void copyOnWriteRemovingInTheBeginning(IGetResult getResult) {
        Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> size = new CopyOnWriteArrayList<>();
            for (int i = 0; i < collectionSize; i++) {
                size.add(i);
            }
            long startTime = System.currentTimeMillis();
            size.remove(0);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void copyOnWriteRemovingInTheMiddle(IGetResult getResult) {
        Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> size = new CopyOnWriteArrayList<>();
            for (int i = 0; i < collectionSize; i++) {
                size.add(i);
            }
            long startTime = System.currentTimeMillis();
            size.remove(size.size() / 2);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void copyOnWriteRemovingInTheEnd(IGetResult getResult) {
        Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> size = new CopyOnWriteArrayList<>();
            for (int i = 0; i < collectionSize; i++) {
                size.add(i);
            }
            long startTime = System.currentTimeMillis();
            size.remove(size.size() - 1);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void treeMapAddingNew(IGetResult getResult) {
        Single.fromCallable(() -> {
            TreeMap<Integer, Integer> size = new TreeMap();
            for (int i = 0, y = 0; i < collectionSize; i++, y++) {
                size.put(y, i);
            }
            long startTime = System.currentTimeMillis();
            size.put(size.size() + 1, 500000);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void treeMapSearchByKey(IGetResult getResult) {
        Single.fromCallable(() -> {
            TreeMap<Integer, Integer> size = new TreeMap<>();
            Integer key = 500;
            for (int i = 0, y = 0; i < collectionSize; i++, y++) {
                size.put(y, i);
            }
            long startTime = System.currentTimeMillis();
            for (int z = 0; z < collectionSize; z++) {
                if (key.equals(size.get(z))) {
                    return size.get(z);
                }
            }
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void treeMapRemove(IGetResult getResult) {
        Single.fromCallable(() -> {
            TreeMap<Integer, Integer> size = new TreeMap<>();
            for (int i = 0, y = 0; i < collectionSize; i++, y++) {
                size.put(y, i);
            }
            long startTime = System.currentTimeMillis();
            size.remove(100);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void hashMapAddingNew(IGetResult getResult) {
        Single.fromCallable(() -> {
            HashMap<Integer, Integer> size = new HashMap();
            for (int i = 0, y = 0; i < collectionSize; i++, y++) {
                size.put(y, i);
            }
            long startTime = System.currentTimeMillis();
            size.put(size.size() + 1, 500000);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void hashMapSearchByKey(IGetResult getResult) {
        Single.fromCallable(() -> {
            HashMap<Integer, Integer> size = new HashMap<>();
            Integer key = 500;
            for (int i = 0, y = 0; i < collectionSize; i++, y++) {
                size.put(y, i);
            }
            long startTime = System.currentTimeMillis();
            for (int z = 0; z < collectionSize; z++) {
                if (key.equals(size.get(z))) {
                    return size.get(z);
                }
            }
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

    public void hashMapRemove(IGetResult getResult) {
        Single.fromCallable(() -> {
            HashMap<Integer, Integer> size = new HashMap<>();
            for (int i = 0, y = 0; i < collectionSize; i++, y++) {
                size.put(y, i);
            }
            long startTime = System.currentTimeMillis();
            size.remove(100);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getResult::getTime);
    }

}