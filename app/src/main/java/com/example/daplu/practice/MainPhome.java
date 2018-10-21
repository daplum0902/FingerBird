package com.example.daplu.practice;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;


public class MainPhome extends Fragment{

    private Button btn;
    private Button btn2;
    private Button btn3;
    private PhomeProfileList phomeProfileList;
    private PhomeAlbumFragment phomeAlbumFragment;
    private PhomeJournalFragment phomeJournalFragment;
    FragmentManager fm;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.phome_index, container, false);

//        setContentView(R.layout.phome_index);

        btn = (Button) view.findViewById(R.id.button);
        btn2 = (Button) view.findViewById(R.id.button2);
        btn3 = (Button) view.findViewById(R.id.button3);
        FrameLayout fl = view.findViewById(R.id.fl);




        fm = getFragmentManager();
//        fm = getSupportFragmentManager();
        Log.d("測試","111");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("編號0","被點了");
                setTabSelection(0);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("編號1","被點了");
                setTabSelection(1);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("編號2","被點了");
                setTabSelection(2);
            }
        });

        return view;
    }

    private void setTabSelection(int index){

        FragmentTransaction ft = fm.beginTransaction();
        hideFragment(ft);
        switch (index) {
            case 0:
                if(phomeProfileList==null){
                    phomeProfileList = new PhomeProfileList();
                    ft.add(R.id.fl, phomeProfileList);
                }else{
                    ft.show(phomeProfileList);
                }

                break;

            case 1:
                if(phomeAlbumFragment==null){
                    phomeAlbumFragment = new PhomeAlbumFragment();
                    ft.add(R.id.fl, phomeAlbumFragment);
                }
                ft.show(phomeAlbumFragment);
                break;

            case 2:
                if(phomeJournalFragment==null){
                    phomeJournalFragment = new PhomeJournalFragment();
                    ft.add(R.id.fl, phomeJournalFragment);
                }
                ft.show(phomeJournalFragment);
                break;
        }
        ft.commit();
    }
    //用于隐藏fragment
    private void hideFragment(FragmentTransaction ft) {
        if (phomeProfileList != null) {
            ft.hide(phomeProfileList);
            if (phomeJournalFragment != null) {
                ft.hide(phomeJournalFragment);
            }
        }if (phomeAlbumFragment != null) {
            ft.hide(phomeAlbumFragment);
            if (phomeProfileList != null) {
                ft.hide(phomeProfileList);
            }
        }
        if (phomeJournalFragment != null){
            ft.hide(phomeJournalFragment);
            if (phomeAlbumFragment != null) {
                ft.hide(phomeAlbumFragment);
            }
        }

    }
}