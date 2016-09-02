package com.justindoan.herome.Activities;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.justindoan.herome.Fragments.BackstoryFragment;
import com.justindoan.herome.Fragments.MainFragment;
import com.justindoan.herome.Fragments.PickPowerFragment;
import com.justindoan.herome.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener, PickPowerFragment.PickPowerInteractionListener, BackstoryFragment.BackstoryFragmentInteractionListener {

    public String POWER_HOW = "came by accident";
    public String POWER_PICKED = "flight";
    public String POWER_ACTUAL = "flight";
    public String POWER_SECONDARY = "strength";
    public String HERO_NAME = "Fly Guy";
    public int POWER_SRC = 0;
    public int POWER_SRC_SECONDARY = 0;
    public int HERO_IMG = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new MainFragment();
            manager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }


    public void loadPickPowerScreen() {

        PickPowerFragment pickPowerFragment = new PickPowerFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pickPowerFragment).addToBackStack(null).commit();
        //If you want to just add something on top of the screen, use add instead of replace

    }

    public void loadBackstoryScreen() {

        BackstoryFragment backstoryFragment = new BackstoryFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, backstoryFragment).addToBackStack(null).commit();
    }

    public void loadMainScreen() {
        MainFragment mainFragment = new MainFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mainFragment).addToBackStack(null).commit();
    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPickPowerInteractionListener(Uri uri) {

    }

    @Override
    public void onBackstoryFragmentInteractionListener(Uri uri) {

    }
}
