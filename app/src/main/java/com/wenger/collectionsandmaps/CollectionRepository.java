package com.wenger.collectionsandmaps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CollectionRepository implements ICollectionRepository {

    private final int VALUE = 500000;

    @Inject
    public CollectionRepository() {
    }

    private Integer calculateTime(long endTime, long startTime) {
        long timeElapsed = endTime - startTime;
        return (int) timeElapsed;
    }

    private ArrayList<Integer> createArrayList(Integer collectionSize) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int y = 0; y < collectionSize; y++) {
            list.add(y);
        }
        return list;
    }

    private LinkedList<Integer> createLinkedList(Integer collectionSize) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < collectionSize; i++) {
            list.add(i);
        }
        return list;
    }

    private CopyOnWriteArrayList<Integer> createCopyOnWrite(Integer collectionSize) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < collectionSize; i++) {
            list.add(i);
        }
        return list;
    }

    @Override
    public Single arrayListAddInTheBeginning(Integer collectionSize) {
        return Single.fromCallable(() -> {
            ArrayList<Integer> list = createArrayList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.add(0, VALUE);
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single arrayListAddInTheMiddle(Integer collectionSize) {
        return Single.fromCallable(() -> {
            ArrayList<Integer> list = createArrayList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.add(list.size() / 2, VALUE);
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single arrayListAddInTheEnd(Integer collectionSize) {
        return Single.fromCallable(() -> {
            ArrayList<Integer> list = createArrayList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.add(VALUE);
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single arrayListSearchBy(Integer collectionSize) {
        return Single.fromCallable(() -> {
            ArrayList<Integer> list = createArrayList(collectionSize);
            long startTime = System.currentTimeMillis();
            for (int y = 0; y < collectionSize; y++) {
                if (list.get(y) == VALUE) {
                    Integer result = list.get(y);
                }
            }
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single arrayListRemoveInTheBeginning(Integer collectionSize) {
        return Single.fromCallable(() -> {
            ArrayList<Integer> list = createArrayList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.remove(0);
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single arrayListRemoveInTheMiddle(Integer collectionSize) {
        return Single.fromCallable(() -> {
            ArrayList<Integer> list = createArrayList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.remove(list.size() / 2);
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single arrayListRemoveInTheEnd(Integer collectionSize) {
        return Single.fromCallable(() -> {
            ArrayList<Integer> list = createArrayList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.remove(list.size() - 1);
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single linkInListAddInTheBeginning(Integer collectionSize) {
        return Single.fromCallable(() -> {
            LinkedList<Integer> list = createLinkedList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.addFirst(VALUE);
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single linkInListAddInTheMiddle(Integer collectionSize) {
        return Single.fromCallable(() -> {
            LinkedList<Integer> list = createLinkedList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.add(list.size() / 2, VALUE);
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single linkInListAddInTheEnd(Integer collectionSize) {
        return Single.fromCallable(() -> {
            LinkedList<Integer> list = createLinkedList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.addLast(VALUE);
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single linkInListSearByValue(Integer collectionSize) {
        return Single.fromCallable(() -> {
            LinkedList<Integer> list = createLinkedList(collectionSize);
            Integer value = 500000;
            long startTime = System.currentTimeMillis();
            for (int y = 0; y < collectionSize; y++) {
                if (value.equals(list.get(y))) {
                    Integer result = list.get(y);
                }
            }
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single linkInListRemoveInTheBeginning(Integer collectionSize) {
        return Single.fromCallable(() -> {
            LinkedList<Integer> list = createLinkedList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.removeFirst();
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single linkInListRemoveInTheMiddle(Integer collectionSize) {
        return Single.fromCallable(() -> {
            LinkedList<Integer> list = createLinkedList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.remove(list.size() / 2);
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single linkInListRemoveInTheEnd(Integer collectionSize) {
        return Single.fromCallable(() -> {
            LinkedList<Integer> list = createLinkedList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.removeLast();
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single copyOnWriteAddInTheBeginning(Integer collectionSize) {
        return Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> list = createCopyOnWrite(collectionSize);
            long startTime = System.currentTimeMillis();
            list.add(0, VALUE);
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single copyOnWriteAddInTheMiddle(Integer collectionSize) {
        return Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> list = createCopyOnWrite(collectionSize);
            long startTime = System.currentTimeMillis();
            list.add(list.size() / 2, VALUE);
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single copyOnWriteAddInTheEnd(Integer collectionSize) {
        return Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> list = createCopyOnWrite(collectionSize);
            long startTime = System.currentTimeMillis();
            list.add(VALUE);
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single copyOnWriteSearchByValue(Integer collectionSize) {
        return Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> list = createCopyOnWrite(collectionSize);
            Integer value = 500000;
            long startTime = System.currentTimeMillis();
            for (int y = 0; y < collectionSize; y++) {
                if (value.equals(list.get(y))) {
                    Integer result = list.get(y);
                }
            }
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single copyOnWriteRemovingInTheBeginning(Integer collectionSize) {
        return Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> list = createCopyOnWrite(collectionSize);
            long startTime = System.currentTimeMillis();
            list.remove(0);
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single copyOnWriteRemovingInTheMiddle(Integer collectionSize) {
        return Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> list = createCopyOnWrite(collectionSize);
            long startTime = System.currentTimeMillis();
            list.remove(list.size() / 2);
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single copyOnWriteRemovingInTheEnd(Integer collectionSize) {
        return Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> list = createCopyOnWrite(collectionSize);
            long startTime = System.currentTimeMillis();
            list.remove(list.size() - 1);
            long endTime = System.currentTimeMillis();
            return calculateTime(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
