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

public class testPostDetailBottomFragment extends Fragment {
    private Button btn;
    private View view;

    private ListView listView;
    private ListAdapter listAdapter;

    public String[][] data = {
            {"阿五", "我可以帶貓過去嗎"},
            {"阿加", "你喜歡羊駝嗎"},
            {"阿加", "你喜歡羊駝嗎"},
            {"阿加", "你喜歡羊駝嗎"}
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = View.inflate(getActivity(), R.layout.test_post_detail_down, null);

        //將資料轉換成<key,value>的型態
        List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        for (int i=0;i < data.length;i++){
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("ms_name", data[i][0]);
            item.put("ms_content", data[i][1]);
            items.add(item);
        }

        //帶入對應資料
        SimpleAdapter adapter = new SimpleAdapter(
                getActivity(),
                items,
                R.layout.message_list_layout,
                new String[]{"ms_name", "ms_content"},
                new int[]{R.id.ms_name, R.id.ms_content}
        );

        ListView listView = (ListView) view.findViewById(R.id.message_list);
        listView.setAdapter(adapter);
        return view;

    }
}
