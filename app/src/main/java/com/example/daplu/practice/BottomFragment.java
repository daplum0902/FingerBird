package com.example.daplu.practice;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomFragment extends Fragment {

    private static final String Tag = "BottomFragment";
    BottomNavigationViewEx bottomNavigationViewEx;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_fragment, null);
        Log.d(Tag,"onCreate:starting.");
        bottomNavigationViewEx = (BottomNavigationViewEx)view.findViewById(R.id.BottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        //setupBottomNavigationView();

        //return inflater.inflate(R.layout.bottom_fragment, container, false);
        return view;
    }

    private void setupBottomNavigationView(){
        Log.d(Tag, "setupBottomNavigationView: setting up BottomNavigationView");



//        bottomNavigationViewEx = (BottomNavigationViewEx) getView().findViewById(R.id.BottomNavViewBar);
        //bottomNavigationViewEx = (BottomNavigationViewEx)findViewById(R.id.BottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
    }
}
