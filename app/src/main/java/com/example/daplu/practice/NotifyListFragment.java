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


public class NotifyListFragment extends Fragment {

    private Button btn;
    private View view;

    private ListView listView;
    private ListAdapter listAdapter;

    public String[] data = {"恭喜您加入一個新聊天室 !", "您的徵伴申請已通過", "請繼續編輯個人資料，以便您的夥伴更容易認識您"};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.notify, null);

        //將資料轉換成<key,value>的型態
        List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        for (int i=0;i < data.length;i++){
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("notify_top", data[i]);
            items.add(item);
        }

        //帶入對應資料
        SimpleAdapter adapter = new SimpleAdapter(
                getActivity(),
                items,
                R.layout.notify_list_layout,
                new String[]{"notify_top"},
                new int[]{R.id.notify_top}
        );

        ListView listView = (ListView) view.findViewById(R.id.notify_listView);
        listView.setAdapter(adapter);
        return view;
    }

}