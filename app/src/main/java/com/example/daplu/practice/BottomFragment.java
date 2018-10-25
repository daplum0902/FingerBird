package com.example.daplu.practice;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomFragment extends AppCompatActivity {

    private static final String Tag = "BottomFragment";
    BottomNavigationViewEx bottomNavigationViewEx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(Tag,"onCreate:starting.");
        bottomNavigationViewEx = (BottomNavigationViewEx)findViewById(R.id.BottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        //setupBottomNavigationView();

        //return inflater.inflate(R.layout.bottom_fragment, container, false);
    }

    private void setupBottomNavigationView(){
        Log.d(Tag, "setupBottomNavigationView: setting up BottomNavigationView");



//        bottomNavigationViewEx = (BottomNavigationViewEx) getView().findViewById(R.id.BottomNavViewBar);
        //bottomNavigationViewEx = (BottomNavigationViewEx)findViewById(R.id.BottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
    }
}
