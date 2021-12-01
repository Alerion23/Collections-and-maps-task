package fragments;

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
import com.wenger.collectionsandmaps.CollectionAdapter;
import com.wenger.collectionsandmaps.HeaderItem;
import com.wenger.collectionsandmaps.MyBroadcastReceiver;
import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.ResultItem;
import com.wenger.collectionsandmaps.databinding.FragmentCalcCollectionsBinding;

import java.util.Arrays;
import java.util.List;


public class CalculCollectionsFragment extends Fragment {

    private FragmentCalcCollectionsBinding binding;
    private CollectionAdapter adapter;
    MyBroadcastReceiver br;

    List<BaseItem> defaultItems = Arrays.asList(new HeaderItem("Adding in the beginning"),
            new ResultItem(-1, "ArrayList", 100),
            new ResultItem(-1, "LinkedList", 101),
            new ResultItem(-1, "CopyOnWrite", 102),
            new HeaderItem("Adding in the middle"),
            new ResultItem(-1, "ArrayList", 103),
            new ResultItem(-1, "LinkedList", 104),
            new ResultItem(-1, "CopyOnWrite", 105),
            new HeaderItem("Adding in the end"),
            new ResultItem(-1, "ArrayList", 106),
            new ResultItem(-1, "LinkedList", 107),
            new ResultItem(-1, "CopyOnWrite", 108),
            new HeaderItem("Search by value"),
            new ResultItem(-1, "ArrayList", 109),
            new ResultItem(-1, "LinkedList", 110),
            new ResultItem(-1, "CopyOnWrite", 111),
            new HeaderItem("Removing in the beginning"),
            new ResultItem(-1, "ArrayList", 112),
            new ResultItem(-1, "LinkedList", 113),
            new ResultItem(-1, "CopyOnWrite", 114),
            new HeaderItem("Removing in the middle"),
            new ResultItem(-1, "ArrayList", 115),
            new ResultItem(-1, "LinkedList", 116),
            new ResultItem(-1, "CopyOnWrite", 117),
            new HeaderItem("Removing in the end"),
            new ResultItem(-1, "ArrayList", 118),
            new ResultItem(-1, "LinkedList", 119),
            new ResultItem(-1, "CopyOnWrite", 120));

    public CalculCollectionsFragment() {
        super(R.layout.fragment_calc_collections);
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
        Integer collectionSize = getArguments() != null ? getArguments().getInt("collectionSize") : 0;
        Intent service = new Intent(getActivity(), CalculationService.class);
        service.putExtra("collectionSize", collectionSize);
        getContext().startService(service);
        registerReceiver();
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.getItemViewType(position) == CollectionAdapter.VIEW_TYPE_HEADER ? 3 : 1;
            }
        });
        binding.collectionsRecycler.setLayoutManager(layoutManager);
        adapter = new CollectionAdapter(defaultItems);
        binding.collectionsRecycler.setAdapter(adapter);
        onClearClickListener();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(br);
    }

    private void registerReceiver() {
        br = new MyBroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Integer resultCollection = intent.getExtras().getInt("result");
                Integer idCollection = intent.getExtras().getInt("id");
                for (int i = 0; i < defaultItems.size(); i++) {
                    BaseItem item = defaultItems.get(i);
                    if (item instanceof ResultItem && ((ResultItem) item).getId() == idCollection) {
                        defaultItems.set(i, new ResultItem(resultCollection,
                                ((ResultItem) item).getTitle(), ((ResultItem) item).getId()));

                    }
                }
                onCollectionItemsReceived(defaultItems);
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

    public void onCollectionItemsReceived(List<BaseItem> resultItems) {
        adapter.setCollectionItems(resultItems);
    }

    public static CalculCollectionsFragment newInstance(Integer collectionSize) {
        CalculCollectionsFragment fragment = new CalculCollectionsFragment();
        Bundle args = new Bundle();
        args.putInt("collectionSize", collectionSize);
        fragment.setArguments(args);
        return fragment;

    }
}

