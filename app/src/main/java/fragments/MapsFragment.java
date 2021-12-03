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
import com.wenger.collectionsandmaps.databinding.FragmentMapsBinding;


public class MapsFragment extends Fragment {
    public MapsFragment() {
        super(R.layout.fragment_maps);
    }

    private FragmentMapsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMapsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onCalcMapClickListener();
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

    private void onCalcMapClickListener() {
        binding.calculateMaps.setOnClickListener(v -> {
            String editText = binding.typeMapSize.getText().toString();
            if (!(editText.isEmpty())) {
                CalculationMapsFragment fragment =
                        CalculationMapsFragment.newInstance(Integer.parseInt(editText));
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.inner_maps_fragment_container, fragment, null)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}
