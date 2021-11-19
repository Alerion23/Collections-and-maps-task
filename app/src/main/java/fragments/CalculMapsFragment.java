package fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.wenger.collectionsandmaps.BaseItem;
import com.wenger.collectionsandmaps.HeaderItem;
import com.wenger.collectionsandmaps.MapsAdapter;
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCalcMapsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.getItemViewType(position) == MapsAdapter.VIEW_TYPE_HEADER ? 2 : 1;
            }
        });
        binding.mapRecycler.setLayoutManager(layoutManager);
        adapter = new MapsAdapter(createItemList());
        binding.mapRecycler.setAdapter(adapter);
        onClearClickListener();
    }

    private void onClearClickListener() {
        binding.clearMap.setOnClickListener(v -> getChildFragmentManager().popBackStack());
    }

    private List<BaseItem> createItemList() {
        Integer sizeMap = getArguments() != null ? getArguments().getInt("mapSize") : 0;
        List<BaseItem> itemList = Arrays.asList(new HeaderItem("Adding new"),
                new ResultItem(sizeMap, "TreeMap"),
                new ResultItem(sizeMap, "HashMap"),
                new HeaderItem("Search by key"),
                new ResultItem(sizeMap, "TreeMap"),
                new ResultItem(sizeMap, "HashMap"),
                new HeaderItem("Removing"),
                new ResultItem(sizeMap, "TreeMap"),
                new ResultItem(sizeMap, "HashMap"));
        return itemList;
    }

    public static CalculMapsFragment newInstance(Integer mapSize) {
        CalculMapsFragment fragment = new CalculMapsFragment();
        Bundle args = new Bundle();
        args.putInt("mapSize", mapSize);
        fragment.setArguments(args);
        return fragment;
    }
}
