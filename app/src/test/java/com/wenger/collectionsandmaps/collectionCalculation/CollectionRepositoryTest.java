package com.wenger.collectionsandmaps.collectionCalculation;

import static org.junit.Assert.*;

import androidx.annotation.MainThread;

import com.wenger.collectionsandmaps.CollectionRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@RunWith(JUnit4.class)
public class CollectionRepositoryTest {

    private int COLLECTION_SIZE = 1000000;
    private int result;

    @Test
    public void arrayListAddInTheBeginning() {
        int expectedValue = 3;
        CollectionRepository repository = new CollectionRepository();
        repository.arrayListAddInTheBeginning(COLLECTION_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void arrayListAddInTheMiddle() {
        int expectedValue = 1;
        CollectionRepository repository = new CollectionRepository();
        repository.arrayListAddInTheMiddle(COLLECTION_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void arrayListAddInTheEnd() {
        int expectedValue = 0;
        CollectionRepository repository = new CollectionRepository();
        repository.arrayListAddInTheEnd(COLLECTION_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void arrayListSearchBy() {
        int expectedValue = 22;
        CollectionRepository repository = new CollectionRepository();
        repository.arrayListSearchBy(COLLECTION_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void arrayListRemoveInTheBeginning() {
        int expectedValue = 1;
        CollectionRepository repository = new CollectionRepository();
        repository.arrayListRemoveInTheBeginning(COLLECTION_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void arrayListRemoveInTheMiddle() {
        int expectedValue = 0;
        CollectionRepository repository = new CollectionRepository();
        repository.arrayListRemoveInTheMiddle(COLLECTION_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void arrayListRemoveInTheEnd() {
        int expectedValue = 0;
        CollectionRepository repository = new CollectionRepository();
        repository.arrayListRemoveInTheEnd(COLLECTION_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void linkInListAddInTheBeginning() {
        int expectedValue = 0;
        CollectionRepository repository = new CollectionRepository();
        repository.linkInListAddInTheBeginning(COLLECTION_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void linkInListAddInTheMiddle() {
        int expectedValue = 7;
        CollectionRepository repository = new CollectionRepository();
        repository.linkInListAddInTheMiddle(COLLECTION_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void linkInListAddInTheEnd() {
        int expectedValue = 0;
        CollectionRepository repository = new CollectionRepository();
        repository.linkInListAddInTheEnd(COLLECTION_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void linkInListSearByValue() {
        int expectedValue = 0;
        CollectionRepository repository = new CollectionRepository();
        repository.linkInListSearByValue(COLLECTION_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void linkInListRemoveInTheBeginning() {
        int expectedValue = 0;
        CollectionRepository repository = new CollectionRepository();
        repository.linkInListRemoveInTheBeginning(COLLECTION_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void linkInListRemoveInTheMiddle() {
        int expectedValue = 5;
        CollectionRepository repository = new CollectionRepository();
        repository.linkInListAddInTheMiddle(COLLECTION_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void linkInListRemoveInTheEnd() {
        int expectedValue = 0;
        CollectionRepository repository = new CollectionRepository();
        repository.linkInListRemoveInTheEnd(COLLECTION_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void copyOnWriteAddInTheBeginning() {
        int expectedValue = 3;
        CollectionRepository repository = new CollectionRepository();
        repository.copyOnWriteAddInTheBeginning(COLLECTION_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void copyOnWriteAddInTheMiddle() {
        int expectedValue = 1;
        CollectionRepository repository = new CollectionRepository();
        repository.copyOnWriteAddInTheMiddle(COLLECTION_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void copyOnWriteAddInTheEnd() {
        int expectedValue = 0;
        CollectionRepository repository = new CollectionRepository();
        repository.copyOnWriteAddInTheEnd(COLLECTION_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void copyOnWriteSearchByValue() {
        int expectedValue = 20;
        CollectionRepository repository = new CollectionRepository();
        repository.copyOnWriteSearchByValue(COLLECTION_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void copyOnWriteRemovingInTheBeginning() {
        int expectedValue = 1;
        CollectionRepository repository = new CollectionRepository();
        repository.copyOnWriteRemovingInTheBeginning(COLLECTION_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void copyOnWriteRemovingInTheMiddle() {
        int expectedValue = 1;
        CollectionRepository repository = new CollectionRepository();
        repository.copyOnWriteRemovingInTheMiddle(COLLECTION_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void copyOnWriteRemovingInTheEnd() {
        int expectedValue = 0;
        CollectionRepository repository = new CollectionRepository();
        repository.copyOnWriteRemovingInTheEnd(COLLECTION_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }
}