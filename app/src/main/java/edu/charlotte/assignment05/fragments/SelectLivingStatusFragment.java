package edu.charlotte.assignment05.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.charlotte.assignment05.R;

public class SelectLivingStatusFragment extends Fragment {

    private SelectLivingStatusListener listener;

    // Stores the living status the user selects
    private String selectedLivingStatus = "";

    public interface SelectLivingStatusListener {
        void submitLivingStatus(String livingStatus);
        void cancelLivingStatus();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof SelectLivingStatusListener) {
            listener = (SelectLivingStatusListener) context;
        } else {
            throw new RuntimeException(
                    context.toString()
                            + " must implement SelectLivingStatusListener"
            );
        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        return inflater.inflate(
                R.layout.fragment_select_living_status,
                container,
                false
        );
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        Button homeownerButton = view.findViewById(R.id.buttonHomeowner);
        Button renterButton = view.findViewById(R.id.buttonRenter);
        Button lesseeButton = view.findViewById(R.id.buttonLessee);
        Button otherButton = view.findViewById(R.id.buttonOther);
        Button preferNotToSayButton =
                view.findViewById(R.id.buttonPreferNotToSay);
        Button cancelButton = view.findViewById(R.id.buttonCancel);

        homeownerButton.setOnClickListener(v -> {
            selectedLivingStatus = "Homeowner";
            listener.submitLivingStatus(selectedLivingStatus);
        });

        renterButton.setOnClickListener(v -> {
            selectedLivingStatus = "Renter";
            listener.submitLivingStatus(selectedLivingStatus);
        });

        lesseeButton.setOnClickListener(v -> {
            selectedLivingStatus = "Lessee";
            listener.submitLivingStatus(selectedLivingStatus);
        });

        otherButton.setOnClickListener(v -> {
            selectedLivingStatus = "Other";
            listener.submitLivingStatus(selectedLivingStatus);
        });

        preferNotToSayButton.setOnClickListener(v -> {
            selectedLivingStatus = "Prefer Not to Say";
            listener.submitLivingStatus(selectedLivingStatus);
        });

        cancelButton.setOnClickListener(v -> {
            listener.cancelLivingStatus();
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}