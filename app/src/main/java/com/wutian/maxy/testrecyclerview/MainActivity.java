package com.wutian.maxy.testrecyclerview;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.meetme.android.horizontallistview.HorizontalListAdapter;
import com.meetme.android.horizontallistview.HorizontalListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HorizontalListView horizontalListView = (HorizontalListView)findViewById(R.id.hlvSimpleList);
        HorizontalListAdapter adapter = new HorizontalListAdapter(this);
        horizontalListView.setAdapter(adapter);
        List<Integer> items = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            items.add(i);
        }
        adapter.setItems(items);
    }
}
