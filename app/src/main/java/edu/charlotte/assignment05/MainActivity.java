package edu.charlotte.assignment05;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import edu.charlotte.assignment05.fragments.ProfileFragment;
import edu.charlotte.assignment05.fragments.SelectIncomeFragment;
import edu.charlotte.assignment05.fragments.SelectLivingStatusFragment;
import edu.charlotte.assignment05.fragments.SelectRoleFragment;
import edu.charlotte.assignment05.fragments.WelcomeFragment;
import edu.charlotte.assignment05.fragments.CreateUserFragment;

public class MainActivity extends AppCompatActivity implements WelcomeFragment.OnFragmentInteractionListener,
        CreateUserFragment.CreateUserListener,
        SelectRoleFragment.SelectRoleListener,
        SelectIncomeFragment.SelectIncomeListener,
        SelectLivingStatusFragment.SelectLivingStatusListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Launch WelcomeFragment when app starts
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new WelcomeFragment()).commit();
        }
    }

    @Override
    public void onStartClicked() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new CreateUserFragment(), "CreateUser").addToBackStack(null).commit();
    }

    @Override
    public void openRoleFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new SelectRoleFragment()).addToBackStack(null).commit();
    }

    @Override
    public void openIncomeFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new SelectIncomeFragment()).addToBackStack(null).commit();
    }

    @Override
    public void openLivingStatusFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new SelectLivingStatusFragment()).addToBackStack(null).commit();
    }

    @Override
    public void createUserAndOpenProfile(User user) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", user);

        ProfileFragment profileFragment = new ProfileFragment();
        profileFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, profileFragment).addToBackStack(null).commit();
    }

    @Override
    public void submitRole(String role) {

        CreateUserFragment fragment =
                (CreateUserFragment) getSupportFragmentManager()
                        .findFragmentByTag("CreateUser");

        if (fragment != null) {
            fragment.setRole(role);
        }

        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelRole() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void submitIncome(String income) {

        CreateUserFragment fragment =
                (CreateUserFragment) getSupportFragmentManager()
                        .findFragmentByTag("CreateUser");

        if (fragment != null) {
            fragment.setIncome(income);
        }

        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelIncome() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void submitLivingStatus(String livingStatus) {

        CreateUserFragment fragment =
                (CreateUserFragment) getSupportFragmentManager()
                        .findFragmentByTag("CreateUser");

        if (fragment != null) {
            fragment.setLivingStatus(livingStatus);
        }

        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelLivingStatus() {
        getSupportFragmentManager().popBackStack();
    }
}