package com.example.daplu.practice;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class testPostDetailUpFragment extends Fragment {
    private TextView name;
    private SharedPreferences prf;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.test_post_detail_up, container, false);
        name = view.findViewById(R.id.name);
        prf = getActivity().getSharedPreferences("user_details",Context.MODE_PRIVATE);
        if(prf.getString("name",null)!=null) {
            name.setText(prf.getString("name", null));
        }else{
            name.setText(prf.getString("email", null));
        }

        return view;
    }
}
