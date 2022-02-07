package com.wenger.collectionsandmaps.collectionCalculation;

import static org.junit.Assert.assertTrue;

import com.wenger.collectionsandmaps.BaseItem;
import com.wenger.collectionsandmaps.HeaderItem;
import com.wenger.collectionsandmaps.ICollectionRepository;
import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.ResultItem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

@RunWith(JUnit4.class)
public class CollectionCalculationPresenterTest {

    ICollectionRepository collectionRepository;
    CalculationCollectionsFragment collectionsFragment;
    private int COLLECTION_SIZE = 1000000;


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

        CollectionCalculationPresenter presenter = new CollectionCalculationPresenter(collectionsFragment,
                collectionRepository);
        assertTrue(defaultList.size() == presenter.createDefaultList().size());
    }

    @Test
    public void addInTheBeginningTest() {
        CollectionCalculationPresenter presenterMock = Mockito.mock(CollectionCalculationPresenter.class);
        Mockito.doCallRealMethod().when(presenterMock).collectionCalculation(Mockito.anyInt());
        presenterMock.collectionCalculation(COLLECTION_SIZE);
        Mockito.verify(presenterMock).collectionCalculation(COLLECTION_SIZE);
    }


}