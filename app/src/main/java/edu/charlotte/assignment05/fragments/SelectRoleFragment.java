
package edu.charlotte.assignment05.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.charlotte.assignment05.R;

public class SelectRoleFragment extends Fragment {

    private SelectRoleListener listener;

    public interface SelectRoleListener {
        void submitRole(String role);
        void cancelRole();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof SelectRoleListener) {
            listener = (SelectRoleListener) context;
        } else {
            throw new RuntimeException(
                    context.toString()
                            + " must implement SelectRoleListener"
            );
        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        return inflater.inflate(
                R.layout.fragment_select_role,
                container,
                false
        );
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        RadioGroup roleRadioGroup =
                view.findViewById(R.id.radioGroup);

        Button submitButton =
                view.findViewById(R.id.buttonSubmit);

        Button cancelButton =
                view.findViewById(R.id.buttonCancel);

        submitButton.setOnClickListener(v -> {

            int selectedId = roleRadioGroup.getCheckedRadioButtonId();

            if (selectedId != -1) {

                RadioButton selectedButton =
                        view.findViewById(selectedId);

                String selectedRole =
                        selectedButton.getText().toString();

                listener.submitRole(selectedRole);
            }
        });

        cancelButton.setOnClickListener(v -> {
            listener.cancelRole();
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}