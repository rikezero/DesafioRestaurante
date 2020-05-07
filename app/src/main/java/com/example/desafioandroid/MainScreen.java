package com.example.desafioandroid;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.desafioandroid.custom.ConfirmationDialog;
import com.example.desafioandroid.fragment.RestaurantsFragment;


public class MainScreen extends AppCompatActivity {

    final Fragment fRes = RestaurantsFragment.newInstance(new Bundle());
    FragmentManager manager = getSupportFragmentManager();
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViews();
        //setListener();
        fragLoad(fRes);


    }

    private void findViews() {
        setContentView(R.layout.activity_main_screen);
    }

    private void setListener(){

    }

    public void fragLoad(final Fragment fragment) {
        boolean fragVoltou = fragBack(fragment.getClass().getName());
        if (!fragVoltou) {
            manager.beginTransaction().replace(R.id.frame_container, fragment).addToBackStack(fragment.getClass().getName()).commit();
        }
    }

    private boolean fragBack(String fragName) {
        return manager.popBackStackImmediate(fragName, 0);
    }

    @Override
    public void onBackPressed() {
        Fragment selectedFragment = null;
        for (Fragment fragment : manager.getFragments()) {
            if(fragment.isVisible()){
                selectedFragment = fragment;
                break;
            }
            return;
        }
        if (selectedFragment instanceof RestaurantsFragment) {
            new ConfirmationDialog(context, getString(R.string.act_end_title), getString(R.string.act_end_msg),
                    getString(R.string.Answer_yes), getString(R.string.Answer_no)).show();

        }
        else{
            fragLoad(fRes);
        }
    }
}


