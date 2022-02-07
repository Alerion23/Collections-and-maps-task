package com.wenger.collectionsandmaps.mapsCalculation;

import static org.junit.Assert.*;

import com.wenger.collectionsandmaps.BaseItem;
import com.wenger.collectionsandmaps.HeaderItem;
import com.wenger.collectionsandmaps.IMapsRepository;
import com.wenger.collectionsandmaps.MapsRepository;
import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.ResultItem;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MapsCalculationPresenterTest {

    private CalculationMapsFragment fragment;
    private IMapsRepository repository;

    @Test
    public void createDefaultList() {
        int treeMapTitle = R.string.treeMap;
        int hashMapTitle = R.string.hashMap;
        int addingNewHeader = R.string.adding_new_map;
        int searchByKeyHeader = R.string.search_by_key_map;
        int removingHeader = R.string.removing_map;
        List<BaseItem> defaultItems = Arrays.asList(
                new HeaderItem(addingNewHeader),
                new ResultItem(-1, treeMapTitle, MapsCalculationPresenter.MAPS_ID_121),
                new ResultItem(-1, hashMapTitle, MapsCalculationPresenter.MAPS_ID_122),
                new HeaderItem(searchByKeyHeader),
                new ResultItem(-1, treeMapTitle, MapsCalculationPresenter.MAPS_ID_123),
                new ResultItem(-1, hashMapTitle, MapsCalculationPresenter.MAPS_ID_124),
                new HeaderItem(removingHeader),
                new ResultItem(-1, treeMapTitle, MapsCalculationPresenter.MAPS_ID_125),
                new ResultItem(-1, hashMapTitle, MapsCalculationPresenter.MAPS_ID_126));
        MapsCalculationPresenter presenter = new MapsCalculationPresenter(fragment, repository);
        assertEquals(defaultItems.size(), presenter.createDefaultList().size());
    }

    @Test
    public void mapsCalculation() {
    }

    @Test
    public void updateItem() {
    }
}