package CollectionCalculation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;

import com.wenger.collectionsandmaps.BaseItem;
import com.wenger.collectionsandmaps.CalculationService;

import app.MyApplication;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;
import di.DaggerAppComponent;

import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.ResultItem;
import com.wenger.collectionsandmaps.databinding.FragmentCalcCollectionsBinding;

import java.util.List;

import javax.inject.Inject;


public class CalculationCollectionsFragment extends DaggerFragment implements ICollectionView {

    private FragmentCalcCollectionsBinding binding;
    private CollectionAdapter adapter;
    private BroadcastReceiver br;
    private String key = "collectionSize";

    @Inject
    CollectionCalculationPresenter collectionPresenter;

    public CalculationCollectionsFragment() {
        super(R.layout.fragment_calc_collections);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCalcCollectionsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int collectionSize = getArguments() != null ? getArguments().getInt(key) : 0;
        adapter = new CollectionAdapter(createNamesForDefaultList());
        Intent service = new Intent(getActivity(), CalculationService.class);
        service.putExtra(key, collectionSize);
        getContext().startService(service);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.getItemViewType(position) == CollectionAdapter.VIEW_TYPE_HEADER ? 3 : 1;
            }
        });
        binding.collectionsRecycler.setLayoutManager(layoutManager);
        binding.collectionsRecycler.setAdapter(adapter);
        registerReceiver();
        onClearClickListener();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(br);
    }

    private List<BaseItem> createNamesForDefaultList() {
       String arrayList = getString(R.string.arrayList);
       String linkedList = getString(R.string.linkedList);
       String copyOnWrite = getString(R.string.copyOnWrite);
       String addITheBeginningCollection = getString(R.string.add_in_the_beginning_collection);
       String addInTheMiddleCollection = getString(R.string.add_in_the_middle_collection);
       String addInTheEndCollection = getString(R.string.add_in_the_end_collection);
       String searchByValueCollection = getString(R.string.search_by_value_collection);
       String removeInTheBeginningCollection = getString(R.string.remove_in_the_beginning_collection);
       String removeInTheMiddleCollection = getString(R.string.remove_in_the_middle_collection);
       String removeInTheEndCollection = getString(R.string.remove_in_the_end_collection);
        return collectionPresenter.createDefaultList(arrayList,linkedList,copyOnWrite,
                addITheBeginningCollection,addInTheMiddleCollection, addInTheEndCollection,
                searchByValueCollection,removeInTheBeginningCollection,removeInTheMiddleCollection,
                removeInTheEndCollection);
    }

    private void registerReceiver() {
        br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int resultCollection = intent.getExtras().getInt("result");
                int idCollection = intent.getExtras().getInt("id");
                collectionPresenter.getDataFromReceiver(resultCollection, idCollection);
            }
        };
        LocalBroadcastManager.getInstance(getContext())
                .registerReceiver(br, new IntentFilter("CollectionCalculate"));
    }

    private void onClearClickListener() {
        binding.clearCollection.setOnClickListener(v -> {
            getParentFragmentManager().popBackStack();
        });
    }


    @Override
    public void onCollectionItemReceived(ResultItem resultItem) {
        adapter.setCollectionItem(resultItem);
    }

    public static CalculationCollectionsFragment newInstance(Integer collectionSize) {
        CalculationCollectionsFragment fragment = new CalculationCollectionsFragment();
        Bundle args = new Bundle();
        args.putInt(fragment.key, collectionSize);
        fragment.setArguments(args);
        return fragment;

    }
}

