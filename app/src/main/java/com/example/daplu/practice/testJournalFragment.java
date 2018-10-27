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

public class testJournalFragment extends Fragment {

    private Button btn;
    private View view;

    private ListView listView;
    private ListAdapter listAdapter;

    public String[][] data = {
            {"毛毛", "原住民的日常","台灣 / 屏東"},
            {"阿俊", "我的夜生活","台灣 / 高雄"},
            {"阿龍", "夜衝大高雄","台灣 / 高雄"},
            {"阿梅", "撿雞蛋日常","台灣 / 台南"},
            {"阿天", "一起去天兵公園","世界 / 天兵"}
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.test_journal_fragment, null);

        //將資料轉換成<key,value>的型態
        List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        for (int i=0;i < data.length;i++){
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("poster_name", data[i][0]);
            item.put("journal_title", data[i][1]);
            item.put("journal_place", data[i][2]);
            items.add(item);
        }

        //帶入對應資料
        SimpleAdapter adapter = new SimpleAdapter(
                getActivity(),
                items,
                R.layout.test_journal_list_style,
                new String[]{"poster_name", "journal_title","journal_place"},
                new int[]{R.id.poster_name, R.id.journal_title, R.id.journal_place}
        );

        ListView listView = (ListView) view.findViewById(R.id.post_j_list);
        listView.setAdapter(adapter);
        return view;
    }
}
