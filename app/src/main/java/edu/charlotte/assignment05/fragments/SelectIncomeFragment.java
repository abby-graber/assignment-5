
package edu.charlotte.assignment05.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.widget.SeekBar;

import edu.charlotte.assignment05.R;

public class SelectIncomeFragment extends Fragment {

    private SelectIncomeListener listener;

    private String selectedIncome;

    public interface SelectIncomeListener {
        void submitIncome(String income);
        void cancelIncome();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof SelectIncomeListener) {
            listener = (SelectIncomeListener) context;
        } else {
            throw new RuntimeException(
                    context.toString()
                            + " must implement SelectIncomeListener"
            );
        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        return inflater.inflate(
                R.layout.fragment_select_income,
                container,
                false
        );
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        SeekBar incomeSlider =
                view.findViewById(R.id.seekBar);

        TextView incomeText =
                view.findViewById(R.id.textViewSeekProgress);

        Button submitButton =
                view.findViewById(R.id.buttonSubmit);

        Button cancelButton =
                view.findViewById(R.id.buttonCancel);

        // Slider goes from 0 to 4
        incomeSlider.setProgress(2);
        incomeSlider.setMax(4);

        // Set initial value
        selectedIncome = "50Kto<100K";
        incomeText.setText(selectedIncome);

        incomeSlider.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(
                            SeekBar seekBar,
                            int progress,
                            boolean fromUser) {

                        switch (progress) {
                            case 0:
                                selectedIncome = "<$25K";
                                break;

                            case 1:
                                selectedIncome = "25Kto<50K";
                                break;

                            case 2:
                                selectedIncome = "50Kto<100K";
                                break;

                            case 3:
                                selectedIncome = "100Kto<200K";
                                break;

                            case 4:
                                selectedIncome = ">$200K";
                                break;
                        }

                        incomeText.setText(selectedIncome);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );

        submitButton.setOnClickListener(v -> {
            listener.submitIncome(selectedIncome);
        });

        cancelButton.setOnClickListener(v -> {
            listener.cancelIncome();
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}