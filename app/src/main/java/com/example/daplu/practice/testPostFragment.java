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

public class testPostFragment extends Fragment {

    private Button btn;
    private View view;

    private ListView listView;
    private ListAdapter listAdapter;

    public String[][] data = {
            {"我想去看瀑布", "美國 / 尼加拉瓜", "12/10"},
            {"我想去看瀑布", "美國 / 尼加拉瓜", "12/10"},
            {"我想去看瀑布", "美國 / 尼加拉瓜", "12/10"},
            {"我想去看瀑布", "美國 / 尼加拉瓜", "12/10"},
            {"我想去看瀑布", "美國 / 尼加拉瓜", "12/10"}
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.test_post_fragment, null);

        //將資料轉換成<key,value>的型態
        List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        for (int i=0;i < data.length;i++){
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("title", data[i][0]);
            item.put("place", data[i][1]);
            item.put("date", data[i][2]);
            items.add(item);
        }

        //帶入對應資料
        SimpleAdapter adapter = new SimpleAdapter(
                getActivity(),
                items,
                R.layout.test_post_list_style,
                new String[]{"title", "place", "date"},
                new int[]{R.id.title, R.id.place, R.id.date}
        );

        ListView listView = (ListView) view.findViewById(R.id.post2_list);
        listView.setAdapter(adapter);
        return view;
    }
}
