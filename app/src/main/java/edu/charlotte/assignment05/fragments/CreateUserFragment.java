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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import edu.charlotte.assignment05.R;
import edu.charlotte.assignment05.User;

public class CreateUserFragment extends Fragment {

    private CreateUserListener listener;
    private EditText nameEditText;
    private EditText emailEditText;
    private TextView roleTextView;
    private TextView incomeTextView;
    private TextView livingStatusTextView;

    private String role = "";
    private String income = "";
    private String livingStatus = "";

    public interface CreateUserListener {
        void openRoleFragment();
        void openIncomeFragment();
        void openLivingStatusFragment();
        void createUserAndOpenProfile(User user);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof CreateUserListener) {
            listener = (CreateUserListener) context;
        } else {
            throw new RuntimeException(
                    context.toString()
                            + " must implement CreateUserListener"
            );
        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        return inflater.inflate(
                R.layout.fragment_create_user,
                container,
                false
        );
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        nameEditText = view.findViewById(R.id.editTextName);
        emailEditText = view.findViewById(R.id.editTextEmail);
        roleTextView = view.findViewById(R.id.textViewRole);
        incomeTextView = view.findViewById(R.id.textViewIncome);
        livingStatusTextView = view.findViewById(R.id.textViewStatus);

        if (!role.isEmpty()) {
            roleTextView.setText(role);
        }

        if (!income.isEmpty()) {
            incomeTextView.setText(income);
        }

        if (!livingStatus.isEmpty()) {
            livingStatusTextView.setText(livingStatus);
        }

        Button selectRoleButton = view.findViewById(R.id.buttonSelectRole);
        Button selectIncomeButton = view.findViewById(R.id.buttonSelectIncome);
        Button selectLivingStatusButton = view.findViewById(R.id.buttonSelectStatus);
        Button selectNext = view.findViewById(R.id.buttonNext);

        selectRoleButton.setOnClickListener(v -> {
            listener.openRoleFragment();
        });

        selectIncomeButton.setOnClickListener(v -> {
            listener.openIncomeFragment();
        });

        selectLivingStatusButton.setOnClickListener(v -> {
            listener.openLivingStatusFragment();
        });

        selectNext.setOnClickListener(v -> {

            String name = nameEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();

            if (name.isEmpty()) {
                Toast.makeText(
                        requireContext(),
                        "Name is required",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            if (email.isEmpty()) {
                Toast.makeText(
                        requireContext(),
                        "Email is required",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            if (role.isEmpty()) {
                Toast.makeText(
                        requireContext(),
                        "Role is required",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            if (income.isEmpty()) {
                Toast.makeText(
                        requireContext(),
                        "Income is required",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            if (livingStatus.isEmpty()) {
                Toast.makeText(
                        requireContext(),
                        "Living Status is required",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            User user = new User(
                    name,
                    email,
                    role,
                    income,
                    livingStatus
            );

            listener.createUserAndOpenProfile(user);
        });
    }

    public void setRole(String role) {
        this.role = role;
        roleTextView.setText(role);
    }

    public void setIncome(String income) {
        this.income = income;
        incomeTextView.setText(income);
    }

    public void setLivingStatus(String livingStatus) {
        this.livingStatus = livingStatus;
        livingStatusTextView.setText(livingStatus);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}