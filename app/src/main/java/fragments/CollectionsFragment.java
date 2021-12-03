package fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.databinding.FragmentCollectionsBinding;

public class CollectionsFragment extends Fragment {
    public CollectionsFragment() {
        super(R.layout.fragment_collections);
    }

    private FragmentCollectionsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentCollectionsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onCalculateCLickListener();
        setupBackPress();
    }

    private void setupBackPress() {
        if (getActivity() != null) {
            getActivity().getOnBackPressedDispatcher().addCallback(
                    new OnBackPressedCallback(true) {
                        @Override
                        public void handleOnBackPressed() {
                            getChildFragmentManager().popBackStack();
                        }
                    }
            );
        }
    }

    private void onCalculateCLickListener() {
        binding.calculateCollection.setOnClickListener(v -> {
            String editText = binding.typeCollectionSize.getText().toString();
            if (!(editText.isEmpty())) {
                CalculationCollectionsFragment fragment =
                        CalculationCollectionsFragment.newInstance(Integer.parseInt(editText));
//                CalculationCollectionsFragment fragment =
//                        CalculationCollectionsFragment.newInstance(Integer.parseInt(editText));
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.inner_collection_fragment_container, fragment, null)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}