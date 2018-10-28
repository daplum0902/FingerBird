package com.example.daplu.practice;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity
implements MainPhome.OnFragmentInteractionListener,testMainPost.OnFragmentInteractionListener,ChatRoomIndex.OnFragmentInteractionListener
{
    private BottomNavigationViewEx bottomNavigationViewEx;
    private MainPhome mainPhome;
    private testMainPost testMainPost;
    private ChatRoomIndex chatRoomIndex;
    private Fragment[] fragments;
    private int lastfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();

    }

    private void initFragment() {
        mainPhome = new MainPhome();
        testMainPost = new testMainPost();
        chatRoomIndex = new ChatRoomIndex();
        fragments = new Fragment[]{mainPhome,testMainPost,mainPhome,chatRoomIndex,chatRoomIndex};
        lastfragment = 0;
        getSupportFragmentManager().beginTransaction().replace(R.id.mainview,mainPhome).show(mainPhome).commit();




        bottomNavigationViewEx = (BottomNavigationViewEx)findViewById(R.id.BottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);

        bottomNavigationViewEx.setOnNavigationItemSelectedListener(changeFragment);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener changeFragment= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId())
            {
                case R.id.home:
                {
                    if(lastfragment!=0)
                    {
                        switchFragment(lastfragment,0);
                        lastfragment=0;

                    }

                    return true;
                }
                case R.id.Post:
                {
                    if(lastfragment!=1)
                    {
                        switchFragment(lastfragment,1);
                        lastfragment=1;

                    }

                    return true;
                }
                case R.id.Schedule:
                {
                    if(lastfragment!=2)
                    {
                        switchFragment(lastfragment,2);
                        lastfragment=2;

                    }

                    return true;
                }

                case R.id.Chat:
                {
                    if(lastfragment!=3)
                    {
                        switchFragment(lastfragment,3);
                        lastfragment=3;

                    }

                    return true;
                }
                case R.id.Notice:
                {
                    if(lastfragment!=4)
                    {
                        switchFragment(lastfragment,4);
                        lastfragment=4;

                    }

                    return true;
                }


            }


            return false;
        }
    };
    //切换Fragment
    private void switchFragment(int lastfragment,int index)
    {
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
        if(fragments[index].isAdded()==false)
        {
            transaction.add(R.id.mainview,fragments[index]);


        }
        transaction.show(fragments[index]).commitAllowingStateLoss();


    }

    private void setupBottomNavigationView(){

        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

