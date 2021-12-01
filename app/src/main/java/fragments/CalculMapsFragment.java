package fragments;

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
import com.wenger.collectionsandmaps.HeaderItem;
import com.wenger.collectionsandmaps.MapsAdapter;
import com.wenger.collectionsandmaps.MyBroadcastReceiver;
import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.ResultItem;
import com.wenger.collectionsandmaps.databinding.FragmentCalcMapsBinding;

import java.util.Arrays;
import java.util.List;

public class CalculMapsFragment extends Fragment {
    public CalculMapsFragment() {
        super(R.layout.fragment_calc_maps);
    }

    private FragmentCalcMapsBinding binding;
    MapsAdapter adapter;
    MyBroadcastReceiver br;

    List<BaseItem> defaultItems = Arrays.asList(new HeaderItem("Adding new"),
            new ResultItem(-1, "TreeMap", 121),
            new ResultItem(-1, "HashMap", 122),
            new HeaderItem("Search by key"),
            new ResultItem(-1, "TreeMap", 123),
            new ResultItem(-1, "HashMap", 124),
            new HeaderItem("Removing"),
            new ResultItem(-1, "TreeMap", 125),
            new ResultItem(-1, "HashMap", 126));

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCalcMapsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Integer mapSize = getArguments() != null ? getArguments().getInt("mapsSize") : 0;
        Intent service = new Intent(getActivity(), CalculationService.class);
        service.putExtra("mapSize", mapSize);
        getContext().startService(service);
        registerReceiver();
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.getItemViewType(position) == MapsAdapter.VIEW_TYPE_HEADER ? 2 : 1;
            }
        });
        binding.mapRecycler.setLayoutManager(layoutManager);
        adapter = new MapsAdapter(defaultItems);
        binding.mapRecycler.setAdapter(adapter);
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
                Integer resultMaps = intent.getExtras().getInt("resultMaps");
                Integer idMaps = intent.getExtras().getInt("idMaps");
                for (int y = 0; y < defaultItems.size(); y++) {
                    BaseItem item = defaultItems.get(y);
                    if (item instanceof ResultItem && ((ResultItem) item).getId() == idMaps) {
                        defaultItems.set(y, new ResultItem( resultMaps,
                                ((ResultItem) item).getTitle(), ((ResultItem) item).getId()));
                    }
                }
                onMapsItemsReceived(defaultItems);
            }
        };
        LocalBroadcastManager.getInstance(getContext())
                .registerReceiver(br, new IntentFilter("CollectionCalculate"));
    }

    private void onClearClickListener() {
        binding.clearMap.setOnClickListener(v -> {
            getParentFragmentManager().popBackStack();
        });
    }

    public void onMapsItemsReceived(List<BaseItem> itemList) {
        adapter.setMapsItems(itemList);
    }

    public static CalculMapsFragment newInstance(Integer mapSize) {
        CalculMapsFragment fragment = new CalculMapsFragment();
        Bundle args = new Bundle();
        args.putInt("mapsSize", mapSize);
        fragment.setArguments(args);
        return fragment;
    }
}
