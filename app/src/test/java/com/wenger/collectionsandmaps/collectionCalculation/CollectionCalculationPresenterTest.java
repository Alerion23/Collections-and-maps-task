package com.wenger.collectionsandmaps.collectionCalculation;

import com.wenger.collectionsandmaps.BaseItem;
import com.wenger.collectionsandmaps.CollectionRepository;
import com.wenger.collectionsandmaps.HeaderItem;
import com.wenger.collectionsandmaps.ICollectionRepository;
import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.ResultItem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@RunWith(JUnit4.class)
public class CollectionCalculationPresenterTest {

    private ICollectionView viewMock;
    private ICollectionRepository repository;
    private CollectionCalculationPresenter presenter;
    private ResultItem resultItem;
    private CompositeDisposable disposables;
    private int numberOfInvocations;
    private int TIMEOUT = 1000;
    private int COLLECTION_SIZE = 1;

    @Before
    public void setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
        repository = new CollectionRepository();
        viewMock = Mockito.mock(ICollectionView.class);
        presenter = new CollectionCalculationPresenter(viewMock, repository);
    }

    @Test
    public void testCreateDefaultList() {

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
        List<BaseItem> defaultList = Arrays.asList(
                new HeaderItem(addITheBeginningCollectionHeader),
                new ResultItem(-1, arrayListTitle, CollectionCalculationPresenter.COLLECTION_ID_100),
                new ResultItem(-1, linkedListTitle, CollectionCalculationPresenter.COLLECTION_ID_101),
                new ResultItem(-1, copyOnWriteTitle, CollectionCalculationPresenter.COLLECTION_ID_102),
                new HeaderItem(addInTheMiddleCollectionHeader),
                new ResultItem(-1, arrayListTitle, CollectionCalculationPresenter.COLLECTION_ID_103),
                new ResultItem(-1, linkedListTitle, CollectionCalculationPresenter.COLLECTION_ID_104),
                new ResultItem(-1, copyOnWriteTitle, CollectionCalculationPresenter.COLLECTION_ID_105),
                new HeaderItem(addInTheEndCollectionHeader),
                new ResultItem(-1, arrayListTitle, CollectionCalculationPresenter.COLLECTION_ID_106),
                new ResultItem(-1, linkedListTitle, CollectionCalculationPresenter.COLLECTION_ID_107),
                new ResultItem(-1, copyOnWriteTitle, CollectionCalculationPresenter.COLLECTION_ID_108),
                new HeaderItem(searchByValueCollectionHeader),
                new ResultItem(-1, arrayListTitle, CollectionCalculationPresenter.COLLECTION_ID_109),
                new ResultItem(-1, linkedListTitle, CollectionCalculationPresenter.COLLECTION_ID_110),
                new ResultItem(-1, copyOnWriteTitle, CollectionCalculationPresenter.COLLECTION_ID_111),
                new HeaderItem(removeInTheBeginningCollectionHeader),
                new ResultItem(-1, arrayListTitle, CollectionCalculationPresenter.COLLECTION_ID_112),
                new ResultItem(-1, linkedListTitle, CollectionCalculationPresenter.COLLECTION_ID_113),
                new ResultItem(-1, copyOnWriteTitle, CollectionCalculationPresenter.COLLECTION_ID_114),
                new HeaderItem(removeInTheMiddleCollectionHeader),
                new ResultItem(-1, arrayListTitle, CollectionCalculationPresenter.COLLECTION_ID_115),
                new ResultItem(-1, linkedListTitle, CollectionCalculationPresenter.COLLECTION_ID_116),
                new ResultItem(-1, copyOnWriteTitle, CollectionCalculationPresenter.COLLECTION_ID_117),
                new HeaderItem(removeInTheEndCollectionHeader),
                new ResultItem(-1, arrayListTitle, CollectionCalculationPresenter.COLLECTION_ID_118),
                new ResultItem(-1, linkedListTitle, CollectionCalculationPresenter.COLLECTION_ID_119),
                new ResultItem(-1, copyOnWriteTitle, CollectionCalculationPresenter.COLLECTION_ID_120));

        List<BaseItem> createDefaultList = presenter.createDefaultList();
        Assert.assertTrue(defaultList.size() == createDefaultList.size());
    }

    @Test
    public void collectionCalculationTest() {
        numberOfInvocations = 21;
        resultItem = Mockito.mock(ResultItem.class);
        Mockito.doNothing().when(viewMock).onCollectionItemReceived(ArgumentMatchers.any(resultItem.getClass()));
        presenter.createDefaultList();
        presenter.collectionCalculation(COLLECTION_SIZE);
        Mockito.verify(viewMock, Mockito.timeout(TIMEOUT).times(numberOfInvocations))
                .onCollectionItemReceived(ArgumentMatchers.any(resultItem.getClass()));
    }

    @Test
    public void updateItemTestSuccess() {
        int collectionResult = 1;
        int collectionId = 100;
        numberOfInvocations = 1;
        resultItem = Mockito.mock(ResultItem.class);
        Mockito.doNothing().when(viewMock).onCollectionItemReceived(ArgumentMatchers.any(resultItem.getClass()));
        presenter.createDefaultList();
        presenter.updateItem(collectionResult, collectionId);
        Mockito.verify(viewMock, Mockito.times(numberOfInvocations))
                .onCollectionItemReceived(ArgumentMatchers.any(resultItem.getClass()));
    }

    @Test
    public void updateItemTestFail() {
        int collectionResult = 1;
        int collectionId = 150;
        numberOfInvocations = 0;
        resultItem = Mockito.mock(ResultItem.class);
        Mockito.doNothing().when(viewMock).onCollectionItemReceived(ArgumentMatchers.any(resultItem.getClass()));
        presenter.createDefaultList();
        presenter.updateItem(collectionResult, collectionId);
        Mockito.verify(viewMock, Mockito.times(numberOfInvocations))
                .onCollectionItemReceived(ArgumentMatchers.any(resultItem.getClass()));
    }

    @Test
    public void stopTest() {
        disposables = new CompositeDisposable();
        presenter.createDefaultList();
        presenter.collectionCalculation(COLLECTION_SIZE);
        presenter.stop();
        Assert.assertEquals(0, disposables.size());
    }
}