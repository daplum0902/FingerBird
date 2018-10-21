package com.example.daplu.practice;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatRoomIndex extends Fragment {

        private Button btn;
        private View view;

        private ListView listView;
        private ListAdapter listAdapter;

        public String[][] data = {
                {"標題", "4/4"},
                {"時間", "4/5 ~ 4/6"},
                {"時間", "4/5 ~ 4/6"},{"時間", "4/5 ~ 4/6"},{"時間", "4/5 ~ 4/6"},{"時間", "4/5 ~ 4/6"},{"時間", "4/5 ~ 4/6"}
        };

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.chatroom_index, container,false);

            //將資料轉換成<key,value>的型態
            List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
            for (int i=0;i < data.length;i++){
                Map<String, Object> item = new HashMap<String, Object>();
                item.put("title", data[i][0]);
                item.put("date", data[i][1]);
                items.add(item);
            }

            //帶入對應資料
            SimpleAdapter adapter = new SimpleAdapter(
                    getActivity(),
                    items,
                    R.layout.chatroom_index_style,
                    new String[]{"title", "date"},
                    new int[]{R.id.title, R.id.date}
            );
            ListView listView = (ListView) view.findViewById(R.id.chatroom_list);
            listView.setAdapter(adapter);
            return view;
        }







}
