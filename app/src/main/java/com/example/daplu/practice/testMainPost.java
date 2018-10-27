package com.example.daplu.practice;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class testMainPost extends Fragment {

//    Button btn1;
//    Button btn2;
//
//    FragmentManager fm;
//    FragmentTransaction ft;
//    Fragment mCurrentFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.test_post_index, container, false);




        return view;
    }


}
