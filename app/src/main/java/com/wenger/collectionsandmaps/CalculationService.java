package com.wenger.collectionsandmaps;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.wenger.collectionsandmaps.collectionCalculation.CollectionCalculationPresenter;
import com.wenger.collectionsandmaps.mapsCalculation.MapsCalculationPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CalculationService extends Service {

    private final String COLLECTION_RESULT = "result";
    private final String COLLECTION_ID = "id";
    private final String MAP_RESULT = "resultMaps";
    private final String MAP_ID = "idMaps";
    private final String ACTION = "CollectionCalculate";
    private final String COLLECTION_KEY = "collectionSize";
    private final String MAPS_KEY = "mapSize";
    private final int VALUE = 500000;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int collectionSize = intent.getExtras().getInt(COLLECTION_KEY);
        int mapsSize = intent.getExtras().getInt(MAPS_KEY);
        if (collectionSize != 0) {
            collectionCalculate(collectionSize);
        }
        if (mapsSize != 0) {
            mapsCalculation(mapsSize);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void collectionCalculate(Integer collectionSize) {
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

    private void mapsCalculation(Integer mapsSize) {
        treeMapAddingNew(mapsSize);
        hashMapAddingNew(mapsSize);
        treeMapSearchByKey(mapsSize);
        hashMapSearchByKey(mapsSize);
        treeMapRemove(mapsSize);
        hashMapRemove(mapsSize);
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

    private void sendCollectionBroadcast(int integer, int id) {
        Intent intent = new Intent(ACTION);
        intent.putExtra(COLLECTION_RESULT, integer);
        intent.putExtra(COLLECTION_ID, id);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
    }

    private void sendMapsBroadcast(int integer, int id) {
        Intent intent = new Intent(ACTION);
        intent.putExtra(MAP_RESULT, integer);
        intent.putExtra(MAP_ID, id);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
    }

    private void arrayListAddInTheBeginning(Integer collectionSize) {
        Single.fromCallable(() -> {
            ArrayList<Integer> list = createArrayList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.add(0, VALUE);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    sendCollectionBroadcast(integer, CollectionCalculationPresenter.COLLECTION_ID_100);
                });

    }


    private void arrayListAddInTheMiddle(Integer collectionSize) {
        Single.fromCallable(() -> {
            ArrayList<Integer> list = createArrayList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.add(list.size() / 2, VALUE);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    sendCollectionBroadcast(integer, CollectionCalculationPresenter.COLLECTION_ID_103);
                });

    }

    private void arrayListAddInTheEnd(Integer collectionSize) {
        Single.fromCallable(() -> {
            ArrayList<Integer> list = createArrayList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.add(VALUE);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    sendCollectionBroadcast(integer, CollectionCalculationPresenter.COLLECTION_ID_106);
                });
    }

    private void arrayListSearchBy(Integer collectionSize) {
        Single.fromCallable(() -> {
            ArrayList<Integer> list = createArrayList(collectionSize);
            long startTime = System.currentTimeMillis();
            for (int y = 0; y < collectionSize; y++) {
                if (list.get(y) == VALUE) {
                    Integer result = list.get(y);
                }
            }
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    sendCollectionBroadcast(integer, CollectionCalculationPresenter.COLLECTION_ID_109);
                });
    }

    private void arrayListRemoveInTheBeginning(Integer collectionSize) {
        Single.fromCallable(() -> {
            ArrayList<Integer> list = createArrayList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.remove(0);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    sendCollectionBroadcast(integer, CollectionCalculationPresenter.COLLECTION_ID_112);
                });
    }

    private void arrayListRemoveInTheMiddle(Integer collectionSize) {
        Single.fromCallable(() -> {
            ArrayList<Integer> list = createArrayList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.remove(list.size() / 2);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    sendCollectionBroadcast(integer, CollectionCalculationPresenter.COLLECTION_ID_115);
                });
    }

    private void arrayListRemoveInTheEnd(Integer collectionSize) {
        Single.fromCallable(() -> {
            ArrayList<Integer> list = createArrayList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.remove(list.size() - 1);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    sendCollectionBroadcast(integer, CollectionCalculationPresenter.COLLECTION_ID_118);
                });
    }

    private void linkInListAddInTheBeginning(Integer collectionSize) {
        Single.fromCallable(() -> {
            LinkedList<Integer> list = createLinkedList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.addFirst(VALUE);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    sendCollectionBroadcast(integer, CollectionCalculationPresenter.COLLECTION_ID_101);
                });
    }

    private void linkInListAddInTheMiddle(Integer collectionSize) {
        Single.fromCallable(() -> {
            LinkedList<Integer> list = createLinkedList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.add(list.size() / 2, VALUE);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    sendCollectionBroadcast(integer, CollectionCalculationPresenter.COLLECTION_ID_104);
                });
    }

    private void linkInListAddInTheEnd(Integer collectionSize) {
        Single.fromCallable(() -> {
            LinkedList<Integer> list = createLinkedList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.addLast(VALUE);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    sendCollectionBroadcast(integer, CollectionCalculationPresenter.COLLECTION_ID_107);
                });
    }

    private void linkInListSearByValue(Integer collectionSize) {
        Single.fromCallable(() -> {
            LinkedList<Integer> list = createLinkedList(collectionSize);
            Integer value = 500000;
            long startTime = System.currentTimeMillis();
            for (int y = 0; y < collectionSize; y++) {
                if (value.equals(list.get(y))) {
                    Integer result = list.get(y);
                }
            }
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    sendCollectionBroadcast(integer, CollectionCalculationPresenter.COLLECTION_ID_110);
                });
    }

    private void linkInListRemoveInTheBeginning(Integer collectionSize) {
        Single.fromCallable(() -> {
            LinkedList<Integer> list = createLinkedList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.removeFirst();
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    sendCollectionBroadcast(integer, CollectionCalculationPresenter.COLLECTION_ID_113);
                });
    }

    private void linkInListRemoveInTheMiddle(Integer collectionSize) {
        Single.fromCallable(() -> {
            LinkedList<Integer> list = createLinkedList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.remove(list.size() / 2);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    sendCollectionBroadcast(integer, CollectionCalculationPresenter.COLLECTION_ID_116);
                });
    }

    private void linkInListRemoveInTheEnd(Integer collectionSize) {
        Single.fromCallable(() -> {
            LinkedList<Integer> list = createLinkedList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.removeLast();
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    sendCollectionBroadcast(integer, CollectionCalculationPresenter.COLLECTION_ID_119);
                });
    }

    private void copyOnWriteAddInTheBeginning(Integer collectionSize) {
        Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> list = createCopyOnWrite(collectionSize);
            long startTime = System.currentTimeMillis();
            list.add(0, VALUE);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    sendCollectionBroadcast(integer, CollectionCalculationPresenter.COLLECTION_ID_102);
                });
    }

    private void copyOnWriteAddInTheMiddle(Integer collectionSize) {
        Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> list = createCopyOnWrite(collectionSize);
            long startTime = System.currentTimeMillis();
            list.add(list.size() / 2, VALUE);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    sendCollectionBroadcast(integer, CollectionCalculationPresenter.COLLECTION_ID_105);
                });
    }

    private void copyOnWriteAddInTheEnd(Integer collectionSize) {
        Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> list = createCopyOnWrite(collectionSize);
            long startTime = System.currentTimeMillis();
            list.add(VALUE);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    sendCollectionBroadcast(integer, CollectionCalculationPresenter.COLLECTION_ID_108);
                });
    }

    private void copyOnWriteSearchByValue(Integer collectionSize) {
        Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> list = createCopyOnWrite(collectionSize);
            Integer value = 500000;
            long startTime = System.currentTimeMillis();
            for (int y = 0; y < collectionSize; y++) {
                if (value.equals(list.get(y))) {
                    Integer result = list.get(y);
                }
            }
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    sendCollectionBroadcast(integer, CollectionCalculationPresenter.COLLECTION_ID_111);
                });
    }

    private void copyOnWriteRemovingInTheBeginning(Integer collectionSize) {
        Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> list = createCopyOnWrite(collectionSize);
            long startTime = System.currentTimeMillis();
            list.remove(0);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    sendCollectionBroadcast(integer, CollectionCalculationPresenter.COLLECTION_ID_114);
                });
    }

    private void copyOnWriteRemovingInTheMiddle(Integer collectionSize) {
        Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> list = createCopyOnWrite(collectionSize);
            long startTime = System.currentTimeMillis();
            list.remove(list.size() / 2);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    sendCollectionBroadcast(integer, CollectionCalculationPresenter.COLLECTION_ID_117);
                });
    }

    private void copyOnWriteRemovingInTheEnd(Integer collectionSize) {
        Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> list = createCopyOnWrite(collectionSize);
            long startTime = System.currentTimeMillis();
            list.remove(list.size() - 1);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    sendCollectionBroadcast(integer, CollectionCalculationPresenter.COLLECTION_ID_120);
                });
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
                    sendMapsBroadcast(integer, MapsCalculationPresenter.MAPS_ID_121);
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
                    sendMapsBroadcast(integer, MapsCalculationPresenter.MAPS_ID_123);
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
                    sendMapsBroadcast(integer, MapsCalculationPresenter.MAPS_ID_125);
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
                    sendMapsBroadcast(integer, MapsCalculationPresenter.MAPS_ID_122);
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
                    sendMapsBroadcast(integer, MapsCalculationPresenter.MAPS_ID_124);
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
                    sendMapsBroadcast(integer, MapsCalculationPresenter.MAPS_ID_126);
                });
    }
}
