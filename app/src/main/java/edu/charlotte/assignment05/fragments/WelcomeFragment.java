package edu.charlotte.assignment05.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.charlotte.assignment05.R;

public class WelcomeFragment extends Fragment {
    private OnFragmentInteractionListener listener;

    public interface OnFragmentInteractionListener {
        void onStartClicked();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(
                    context.toString()
                            + " must implement OnFragmentInteractionListener"
            );
        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        return inflater.inflate(
                R.layout.fragment_welcome,
                container,
                false
        );
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        Button startButton = view.findViewById(R.id.buttonStart);

        startButton.setOnClickListener(v -> {
            listener.onStartClicked();
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}