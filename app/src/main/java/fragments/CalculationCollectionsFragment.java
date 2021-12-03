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
import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.ResultItem;
import com.wenger.collectionsandmaps.databinding.FragmentCalcCollectionsBinding;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class CalculationCollectionsFragment extends Fragment {

    private FragmentCalcCollectionsBinding binding;
    private CollectionAdapter adapter;
    private BroadcastReceiver br;
    private List<BaseItem> defaultItems;
    private String arrayList;
    private String linkedList;
    private String copyOnWrite;


    public CalculationCollectionsFragment() {
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
        createDefaultList();
        int collectionSize = getArguments() != null ? getArguments().getInt("collectionSize") : 0;
        Intent service = new Intent(getActivity(), CalculationService.class);
        service.putExtra("collectionSize", collectionSize);
        getContext().startService(service);
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
        registerReceiver();
        onClearClickListener();
    }

    private List<BaseItem> createDefaultList() {
        arrayList = getActivity().getString(R.string.arrayList);
        linkedList = getActivity().getString(R.string.linkedList);
        copyOnWrite = getActivity().getString(R.string.copyOnWrite);
        defaultItems = Arrays.asList(new HeaderItem(getActivity().getString(R.string.add_in_the_beginning_collection)),
                new ResultItem(-1, arrayList, 100),
                new ResultItem(-1, linkedList, 101),
                new ResultItem(-1, copyOnWrite, 102),
                new HeaderItem(getActivity().getString(R.string.add_in_the_middle_collection)),
                new ResultItem(-1, arrayList, 103),
                new ResultItem(-1, linkedList, 104),
                new ResultItem(-1, copyOnWrite, 105),
                new HeaderItem(getActivity().getString(R.string.add_in_the_end_collection)),
                new ResultItem(-1, arrayList, 106),
                new ResultItem(-1, linkedList, 107),
                new ResultItem(-1, copyOnWrite, 108),
                new HeaderItem(getActivity().getString(R.string.search_by_value_collection)),
                new ResultItem(-1, arrayList, 109),
                new ResultItem(-1, linkedList, 110),
                new ResultItem(-1, copyOnWrite, 111),
                new HeaderItem(getActivity().getString(R.string.remove_in_the_beginning_collection)),
                new ResultItem(-1, arrayList, 112),
                new ResultItem(-1, linkedList, 113),
                new ResultItem(-1, copyOnWrite, 114),
                new HeaderItem(getActivity().getString(R.string.remove_in_the_middle_collection)),
                new ResultItem(-1, arrayList, 115),
                new ResultItem(-1, linkedList, 116),
                new ResultItem(-1, copyOnWrite, 117),
                new HeaderItem(getActivity().getString(R.string.remove_in_the_end_collection)),
                new ResultItem(-1, arrayList, 118),
                new ResultItem(-1, linkedList, 119),
                new ResultItem(-1, copyOnWrite, 120));
        return defaultItems;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(br);
    }

    private void registerReceiver() {
        br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int resultCollection = intent.getExtras().getInt("result");
                int idCollection = intent.getExtras().getInt("id");
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

    public static CalculationCollectionsFragment newInstance(Integer collectionSize) {
        CalculationCollectionsFragment fragment = new CalculationCollectionsFragment();
        Bundle args = new Bundle();
        args.putInt("collectionSize", collectionSize);
        fragment.setArguments(args);
        return fragment;

    }
}

