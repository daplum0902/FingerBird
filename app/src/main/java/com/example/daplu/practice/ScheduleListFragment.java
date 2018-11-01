package com.example.daplu.practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScheduleListFragment extends Fragment {
    private Button btn;
    private View view;
    private ImageButton Backschedule;

    private ListView listView;

    public String[][] data = {
            {"9:00", "台南火車站", "11號公車", "30分鐘"},
            {"11:00", "奇美博物館", "88號公車", "30分鐘"},
            {"12:00", "某間餐廳", "走路", "10分鐘"},
            {"15:00", "台南火車站", "11號公車", "30分鐘"},
            {"17:00", "台南大飯店", "走路", "15分鐘"},
            {"17:00", "台南大飯店", "走路", "15分鐘"},
            {"17:00", "台南大飯店", "走路", "15分鐘"},
            {"17:00", "台南大飯店", "走路", "15分鐘"}
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.schedule_main, null);
        ListView listView = (ListView) view.findViewById(R.id.schedule_list);

        View header_view = getLayoutInflater().inflate(R.layout.schedule_header_view, null);
        View footer_view = getLayoutInflater().inflate(R.layout.schedule_footer_view, null);

        listView.addHeaderView(header_view);
        listView.addFooterView(footer_view);





        //將資料轉換成<key,value>的型態
        List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        for (int i=0;i < data.length;i++){
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("arrive_time", data[i][0]);
            item.put("destination", data[i][1]);
            item.put("trans_name", data[i][2]);
            item.put("totaltime", data[i][3]);
            items.add(item);
        }

        //帶入對應資料
        SimpleAdapter adapter = new SimpleAdapter(
                getActivity(),
                items,
                R.layout.schedule_list_layout,
                new String[]{"arrive_time", "destination", "trans_name", "totaltime"},
                new int[]{R.id.arrive_time, R.id.destination, R.id.trans_name, R.id.totaltime}
        );

        listView.setAdapter(adapter);


        Backschedule = view.findViewById(R.id.Backschedule);
        Backschedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);


            }
        });


        return view;
    }

    public void Backschedule(View view){
        Intent intent = new Intent(getActivity(),MainActivity.class);
        startActivity(intent);


    }


}
