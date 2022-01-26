package com.wenger.collectionsandmaps.collectionCalculation;

import com.wenger.collectionsandmaps.BaseItem;
import com.wenger.collectionsandmaps.HeaderItem;
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
import io.reactivex.rxjava3.schedulers.Schedulers;


public class CollectionCalculationPresenter implements ICollectionPresenter {

    private List<BaseItem> defaultItems;
    private CalculationCollectionsFragment collectionView;
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
    private final int VALUE = 500000;

    @Inject
    public CollectionCalculationPresenter(CalculationCollectionsFragment collectionView) {
        this.collectionView = collectionView;
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

    private Integer timeResult(long endTime, long startTime) {
        long timeElapsed = endTime - startTime;
        return (int) timeElapsed;
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
                    getNewItem(integer, COLLECTION_ID_100);
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
                    getNewItem(integer, COLLECTION_ID_103);
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
                    getNewItem(integer, COLLECTION_ID_106);
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
                    getNewItem(integer, COLLECTION_ID_109);
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
                    getNewItem(integer, COLLECTION_ID_112);
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
                    getNewItem(integer, COLLECTION_ID_115);
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
                    getNewItem(integer, COLLECTION_ID_118);
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
                    getNewItem(integer, COLLECTION_ID_101);
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
                    getNewItem(integer, COLLECTION_ID_104);
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
                    getNewItem(integer, COLLECTION_ID_107);
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
                    getNewItem(integer, COLLECTION_ID_110);
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
                    getNewItem(integer, COLLECTION_ID_113);
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
                    getNewItem(integer, COLLECTION_ID_116);
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
                    getNewItem(integer, COLLECTION_ID_119);
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
                    getNewItem(integer, COLLECTION_ID_102);
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
                    getNewItem(integer, COLLECTION_ID_105);
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
                    getNewItem(integer, COLLECTION_ID_108);
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
                    getNewItem(integer, COLLECTION_ID_111);
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
                    getNewItem(integer, COLLECTION_ID_114);
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
                    getNewItem(integer, COLLECTION_ID_117);
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
                    getNewItem(integer, COLLECTION_ID_120);
                });
    }

    @Override
    public void getNewItem(int resultCollection, int idCollection) {
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
