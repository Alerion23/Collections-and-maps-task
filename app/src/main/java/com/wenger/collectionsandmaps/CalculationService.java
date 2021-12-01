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
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Integer collectionSize = intent.getExtras().getInt("collectionSize");
        Integer mapsSize = intent.getExtras().getInt("mapSize");
        if (collectionSize != 0) {
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
        if (mapsSize != 0) {
            treeMapAddingNew(mapsSize);
            hashMapAddingNew(mapsSize);
            treeMapSearchByKey(mapsSize);
            hashMapSearchByKey(mapsSize);
            treeMapRemove(mapsSize);
            hashMapRemove(mapsSize);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    private void arrayListAddInTheBeginning(Integer collectionSize) {
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
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("result", integer);
                    intent.putExtra("id", 100);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });

    }


    private void arrayListAddInTheMiddle(Integer collectionSize) {
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
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("result", integer);
                    intent.putExtra("id", 103);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });

    }

    private void arrayListAddInTheEnd(Integer collectionSize) {
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
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("result", integer);
                    intent.putExtra("id", 106);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void arrayListSearchBy(Integer collectionSize) {
        Single.fromCallable(() -> {
            ArrayList<Integer> size = new ArrayList<>();
            for (int i = 0; i < collectionSize; i++) {
                size.add(i);
            }
            long startTime = System.currentTimeMillis();
            for (int y = 0; y < collectionSize; y++) {
                if (size.get(y) == 500000) {
                    Integer result = size.get(y);
                }
            }
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("result", integer);
                    intent.putExtra("id", 109);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void arrayListRemoveInTheBeginning(Integer collectionSize) {
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
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("result", integer);
                    intent.putExtra("id", 112);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void arrayListRemoveInTheMiddle(Integer collectionSize) {
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
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("result", integer);
                    intent.putExtra("id", 115);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void arrayListRemoveInTheEnd(Integer collectionSize) {
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
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("result", integer);
                    intent.putExtra("id", 118);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void linkInListAddInTheBeginning(Integer collectionSize) {
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
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("result", integer);
                    intent.putExtra("id", 101);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void linkInListAddInTheMiddle(Integer collectionSize) {
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
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("result", integer);
                    intent.putExtra("id", 104);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void linkInListAddInTheEnd(Integer collectionSize) {
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
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("result", integer);
                    intent.putExtra("id", 107);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void linkInListSearByValue(Integer collectionSize) {
        Single.fromCallable(() -> {
            LinkedList<Integer> size = new LinkedList<>();
            Integer value = 500000;
            for (int i = 0; i < collectionSize; i++) {
                size.add(i);
            }
            long startTime = System.currentTimeMillis();
            for (int y = 0; y < collectionSize; y++) {
                if (value.equals(size.get(y))) {
                    Integer result = size.get(y);
                }
            }
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("result", integer);
                    intent.putExtra("id", 110);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void linkInListRemoveInTheBeginning(Integer collectionSize) {
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
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("result", integer);
                    intent.putExtra("id", 113);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void linkInListRemoveInTheMiddle(Integer collectionSize) {
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
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("result", integer);
                    intent.putExtra("id", 116);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void linkInListRemoveInTheEnd(Integer collectionSize) {
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
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("result", integer);
                    intent.putExtra("id", 119);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void copyOnWriteAddInTheBeginning(Integer collectionSize) {
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
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("result", integer);
                    intent.putExtra("id", 102);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void copyOnWriteAddInTheMiddle(Integer collectionSize) {
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
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("result", integer);
                    intent.putExtra("id", 105);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void copyOnWriteAddInTheEnd(Integer collectionSize) {
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
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("result", integer);
                    intent.putExtra("id", 108);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void copyOnWriteSearchByValue(Integer collectionSize) {
        Single.fromCallable(() -> {
            CopyOnWriteArrayList<Integer> size = new CopyOnWriteArrayList<>();
            Integer value = 500000;
            for (int i = 0; i < collectionSize; i++) {
                size.add(i);
            }
            long startTime = System.currentTimeMillis();
            for (int y = 0; y < collectionSize; y++) {
                if (value.equals(size.get(y))) {
                    Integer result = size.get(y);
                }
            }
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("result", integer);
                    intent.putExtra("id", 111);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void copyOnWriteRemovingInTheBeginning(Integer collectionSize) {
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
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("result", integer);
                    intent.putExtra("id", 114);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void copyOnWriteRemovingInTheMiddle(Integer collectionSize) {
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
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("result", integer);
                    intent.putExtra("id", 117);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    private void copyOnWriteRemovingInTheEnd(Integer collectionSize) {
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
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("result", integer);
                    intent.putExtra("id", 120);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    public void treeMapAddingNew(Integer mapsSize) {
        Single.fromCallable(() -> {
            TreeMap<Integer, Integer> size = new TreeMap();
            for (int i = 0, y = 0; i < mapsSize; i++, y++) {
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
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("resultMaps", integer);
                    intent.putExtra("idMaps", 121);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    public void treeMapSearchByKey(Integer mapsSize) {
        Single.fromCallable(() -> {
            TreeMap<Integer, Integer> size = new TreeMap<>();
            for (int i = 0, y = 0; i < mapsSize; i++, y++) {
                size.put(y, i);
            }
            long startTime = System.currentTimeMillis();
            for (int z = 0; z < mapsSize; z++) {
                if (size.get(z) == 500) {
                    Integer result = size.get(z);
                }
            }
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("resultMaps", integer);
                    intent.putExtra("idMaps", 123);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    public void treeMapRemove(Integer mapsSize) {
        Single.fromCallable(() -> {
            TreeMap<Integer, Integer> size = new TreeMap<>();
            for (int i = 0, y = 0; i < mapsSize; i++, y++) {
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
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("resultMaps", integer);
                    intent.putExtra("idMaps", 125);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    public void hashMapAddingNew(Integer mapsSize) {
        Single.fromCallable(() -> {
            HashMap<Integer, Integer> size = new HashMap();
            for (int i = 0, y = 0; i < mapsSize; i++, y++) {
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
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("resultMaps", integer);
                    intent.putExtra("idMaps", 122);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    public void hashMapSearchByKey(Integer mapsSize) {
        Single.fromCallable(() -> {
            HashMap<Integer, Integer> size = new HashMap<>();
            Integer key = 500;
            for (int i = 0, y = 0; i < mapsSize; i++, y++) {
                size.put(y, i);
            }
            long startTime = System.currentTimeMillis();
            for (int z = 0; z < mapsSize; z++) {
                if (key.equals(size.get(z))) {
                    Integer result = size.get(z);
                }
            }
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            return (int) timeElapsed;
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("resultMaps", integer);
                    intent.putExtra("idMaps", 124);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }

    public void hashMapRemove(Integer mapsSize) {
        Single.fromCallable(() -> {
            HashMap<Integer, Integer> size = new HashMap<>();
            for (int i = 0, y = 0; i < mapsSize; i++, y++) {
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
                .subscribe(integer -> {
                    Intent intent = new Intent("CollectionCalculate");
                    intent.putExtra("resultMaps", integer);
                    intent.putExtra("idMaps", 126);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                });
    }
}
