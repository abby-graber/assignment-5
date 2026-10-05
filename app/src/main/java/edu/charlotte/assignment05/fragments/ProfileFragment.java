package edu.charlotte.assignment05.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.charlotte.assignment05.R;
import edu.charlotte.assignment05.User;

public class ProfileFragment extends Fragment {

    private User user;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            user = (User) getArguments().getSerializable("user");
        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        return inflater.inflate(
                R.layout.fragment_profile,
                container,
                false
        );
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        TextView nameTextView =
                view.findViewById(R.id.textViewName);

        TextView emailTextView =
                view.findViewById(R.id.textViewEmail);

        TextView roleTextView =
                view.findViewById(R.id.textViewRole);

        TextView incomeTextView =
                view.findViewById(R.id.textViewIncome);

        TextView livingStatusTextView =
                view.findViewById(R.id.textViewStatus);

        nameTextView.setText(user.getName());
        emailTextView.setText(user.getEmail());
        roleTextView.setText(user.getRole());
        incomeTextView.setText(user.getIncome());
        livingStatusTextView.setText(user.getStatus());
    }
}