package group3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.violethsu.maple.R;

public class Explore_PostActivity extends MainActivity {
    private Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explore_pa_main);
        getSupportActionBar().show();
        fragment=new Explore_PA_PostFragment();
        changeFragment(fragment);

    }

    public void changeFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.postactivitycontainer, fragment);
        fragmentTransaction.commit();
    }
}