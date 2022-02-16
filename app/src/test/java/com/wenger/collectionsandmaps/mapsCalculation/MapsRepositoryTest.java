package com.wenger.collectionsandmaps.mapsCalculation;

import static org.junit.Assert.*;

import com.wenger.collectionsandmaps.MapsRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MapsRepositoryTest {

    private int MAPS_SIZE = 1000000;
    private int result;

    @Test
    public void treeMapAddingNew() {
        int expectedValue = 0;
        MapsRepository repository = new MapsRepository();
        repository.treeMapAddingNew(MAPS_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void treeMapSearchByKey() {
        int expectedValue = 247;
        MapsRepository repository = new MapsRepository();
        repository.treeMapSearchByKey(MAPS_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void treeMapRemove() {
        int expectedValue = 0;
        MapsRepository repository = new MapsRepository();
        repository.treeMapRemove(MAPS_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void hashMapAddingNew() {
        int expectedValue = 0;
        MapsRepository repository = new MapsRepository();
        repository.hashMapAddingNew(MAPS_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void hashMapSearchByKey() {
        int expectedValue = 190;
        MapsRepository repository = new MapsRepository();
        repository.hashMapSearchByKey(MAPS_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }

    @Test
    public void hashMapRemove() {
        int expectedValue = 0;
        MapsRepository repository = new MapsRepository();
        repository.hashMapRemove(MAPS_SIZE)
                .subscribe(integer -> {
                    result = (int) integer;
                });
        assertEquals(expectedValue, result);
    }
}