package com.wenger.collectionsandmaps.mapsCalculation;

import static org.junit.Assert.*;

import com.wenger.collectionsandmaps.BaseItem;
import com.wenger.collectionsandmaps.HeaderItem;
import com.wenger.collectionsandmaps.IMapsRepository;
import com.wenger.collectionsandmaps.MapsRepository;
import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.ResultItem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MapsCalculationPresenterTest {

    private IMapsView viewMock;
    private IMapsRepository repository;
    private MapsCalculationPresenter presenter;
    private ResultItem resultItem;
    private CompositeDisposable disposables;
    private int numberOfInvocations;
    private int TIMEOUT = 1000;
    private int MAPS_SIZE = 1;

    @Before
    public void setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
        viewMock = Mockito.mock(IMapsView.class);
        repository = new MapsRepository();
        presenter = new MapsCalculationPresenter(viewMock, repository);
    }

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
        List<BaseItem> createDefaultList = presenter.createDefaultList();
        assertTrue(defaultItems.size() == createDefaultList.size());
    }

    @Test
    public void mapsCalculationTest() {
        numberOfInvocations = 6;
        resultItem = Mockito.mock(ResultItem.class);
        Mockito.doNothing().when(viewMock).onMapsItemReceived(ArgumentMatchers.any(resultItem.getClass()));
        presenter.createDefaultList();
        presenter.mapsCalculation(MAPS_SIZE);
        Mockito.verify(viewMock, Mockito.timeout(TIMEOUT).times(numberOfInvocations))
                .onMapsItemReceived(ArgumentMatchers.any(resultItem.getClass()));
    }

    @Test
    public void updateItemTestSuccess() {
        int mapsResult = 1;
        int mapsId = 121;
        numberOfInvocations = 1;
        resultItem = Mockito.mock(ResultItem.class);
        Mockito.doNothing().when(viewMock).onMapsItemReceived(ArgumentMatchers.any(resultItem.getClass()));
        presenter.createDefaultList();
        presenter.updateItem(mapsResult, mapsId);
        Mockito.verify(viewMock, Mockito.times(numberOfInvocations))
                .onMapsItemReceived(ArgumentMatchers.any(resultItem.getClass()));
    }

    @Test
    public void updateItemTestFail() {
        int mapsResult = 1;
        int mapsId = 150;
        numberOfInvocations = 0;
        resultItem = Mockito.mock(ResultItem.class);
        Mockito.doNothing().when(viewMock).onMapsItemReceived(ArgumentMatchers.any(resultItem.getClass()));
        presenter.createDefaultList();
        presenter.updateItem(mapsResult, mapsId);
        Mockito.verify(viewMock, Mockito.times(numberOfInvocations))
                .onMapsItemReceived(ArgumentMatchers.any(resultItem.getClass()));
    }

    @Test
    public void stopTest() {
        disposables = new CompositeDisposable();
        presenter.createDefaultList();
        presenter.mapsCalculation(MAPS_SIZE);
        presenter.stop();
        Assert.assertEquals(0, disposables.size());
    }
}