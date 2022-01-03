package com.wenger.collectionsandmaps;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CalculationService extends Service {

    private String collectionResult = "result";
    private String collectionId = "id";
    private String mapResult = "resultMaps";
    private String mapId = "idMaps";
    private String action = "CollectionCalculate";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int collectionSize = intent.getExtras().getInt("collectionSize");
        int mapsSize = intent.getExtras().getInt("mapSize");
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

    private void arrayListAddInTheBeginning(Integer collectionSize) {
        Single.fromCallable(() -> {
            ArrayList<Integer> list = createArrayList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.add(0, 500000);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    Intent intent = new Intent(action);
                    intent.putExtra(collectionResult, integer);
                    intent.putExtra(collectionId, 100);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });

    }


    private void arrayListAddInTheMiddle(Integer collectionSize) {
        Single.fromCallable(() -> {
            ArrayList<Integer> list = createArrayList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.add(list.size() / 2, 500000);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    Intent intent = new Intent(action);
                    intent.putExtra(collectionResult, integer);
                    intent.putExtra(collectionId, 103);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });

    }

    private void arrayListAddInTheEnd(Integer collectionSize) {
        Single.fromCallable(() -> {
            ArrayList<Integer> list = createArrayList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.add(500000);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    Intent intent = new Intent(action);
                    intent.putExtra(collectionResult, integer);
                    intent.putExtra(collectionId, 106);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void arrayListSearchBy(Integer collectionSize) {
        Single.fromCallable(() -> {
            ArrayList<Integer> list = createArrayList(collectionSize);
            long startTime = System.currentTimeMillis();
            for (int y = 0; y < collectionSize; y++) {
                if (list.get(y) == 500000) {
                    Integer result = list.get(y);
                }
            }
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    Intent intent = new Intent(action);
                    intent.putExtra(collectionResult, integer);
                    intent.putExtra(collectionId, 109);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
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
                    Intent intent = new Intent(action);
                    intent.putExtra(collectionResult, integer);
                    intent.putExtra(collectionId, 112);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
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
                    Intent intent = new Intent(action);
                    intent.putExtra(collectionResult, integer);
                    intent.putExtra(collectionId, 115);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
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
                    Intent intent = new Intent(action);
                    intent.putExtra(collectionResult, integer);
                    intent.putExtra(collectionId, 118);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void linkInListAddInTheBeginning(Integer collectionSize) {
        Single.fromCallable(() -> {
            LinkedList<Integer> list = createLinkedList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.addFirst(500000);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    Intent intent = new Intent(action);
                    intent.putExtra(collectionResult, integer);
                    intent.putExtra(collectionId, 101);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void linkInListAddInTheMiddle(Integer collectionSize) {
        Single.fromCallable(() -> {
            LinkedList<Integer> list = createLinkedList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.add(list.size() / 2, 500000);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    Intent intent = new Intent(action);
                    intent.putExtra(collectionResult, integer);
                    intent.putExtra(collectionId, 104);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void linkInListAddInTheEnd(Integer collectionSize) {
        Single.fromCallable(() -> {
            LinkedList<Integer> list = createLinkedList(collectionSize);
            long startTime = System.currentTimeMillis();
            list.addLast(500000);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    Intent intent = new Intent(action);
                    intent.putExtra(collectionResult, integer);
                    intent.putExtra(collectionId, 107);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
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
                    Intent intent = new Intent(action);
                    intent.putExtra(collectionResult, integer);
                    intent.putExtra(collectionId, 110);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
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
                    Intent intent = new Intent(action);
                    intent.putExtra(collectionResult, integer);
                    intent.putExtra(collectionId, 113);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
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
                    Intent intent = new Intent(action);
                    intent.putExtra(collectionResult, integer);
                    intent.putExtra(collectionId, 116);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
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
                    Intent intent = new Intent(action);
                    intent.putExtra(collectionResult, integer);
                    intent.putExtra(collectionId, 119);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void copyOnWriteAddInTheBeginning(Integer collectionSize) {
        Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> list = createCopyOnWrite(collectionSize);
            long startTime = System.currentTimeMillis();
            list.add(0, 500000);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    Intent intent = new Intent(action);
                    intent.putExtra(collectionResult, integer);
                    intent.putExtra(collectionId, 102);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void copyOnWriteAddInTheMiddle(Integer collectionSize) {
        Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> list = createCopyOnWrite(collectionSize);
            long startTime = System.currentTimeMillis();
            list.add(list.size() / 2, 500000);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    Intent intent = new Intent(action);
                    intent.putExtra(collectionResult, integer);
                    intent.putExtra(collectionId, 105);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void copyOnWriteAddInTheEnd(Integer collectionSize) {
        Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> list = createCopyOnWrite(collectionSize);
            long startTime = System.currentTimeMillis();
            list.add(500000);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    Intent intent = new Intent(action);
                    intent.putExtra(collectionResult, integer);
                    intent.putExtra(collectionId, 108);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
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
                    Intent intent = new Intent(action);
                    intent.putExtra(collectionResult, integer);
                    intent.putExtra(collectionId, 111);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
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
                    Intent intent = new Intent(action);
                    intent.putExtra(collectionResult, integer);
                    intent.putExtra(collectionId, 114);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
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
                    Intent intent = new Intent(action);
                    intent.putExtra(collectionResult, integer);
                    intent.putExtra(collectionId, 117);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
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
                    Intent intent = new Intent(action);
                    intent.putExtra(collectionResult, integer);
                    intent.putExtra(collectionId, 120);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    public void treeMapAddingNew(Integer mapsSize) {
        Single.fromCallable(() -> {
            TreeMap<Integer, Integer> map = createTreeMap(mapsSize);
            long startTime = System.currentTimeMillis();
            map.put(map.size() + 1, 500000);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    Intent intent = new Intent(action);
                    intent.putExtra(mapResult, integer);
                    intent.putExtra(mapId, 121);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
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
                    Intent intent = new Intent(action);
                    intent.putExtra(mapResult, integer);
                    intent.putExtra(mapId, 123);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
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
                    Intent intent = new Intent(action);
                    intent.putExtra(mapResult, integer);
                    intent.putExtra(mapId, 125);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    public void hashMapAddingNew(Integer mapsSize) {
        Single.fromCallable(() -> {
            HashMap<Integer, Integer> map = createHashMap(mapsSize);
            long startTime = System.currentTimeMillis();
            map.put(map.size() + 1, 500000);
            long endTime = System.currentTimeMillis();
            return timeResult(endTime, startTime);
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    Intent intent = new Intent(action);
                    intent.putExtra(mapResult, integer);
                    intent.putExtra(mapId, 122);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
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
                    Intent intent = new Intent(action);
                    intent.putExtra(mapResult, integer);
                    intent.putExtra(mapId, 124);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
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
                    Intent intent = new Intent(action);
                    intent.putExtra(mapResult, integer);
                    intent.putExtra(mapId, 126);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }
}
