package com.wutian.maxy.testrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.wutian.maxy.recyclerview.MyRecycler;
import com.wutian.maxy.recyclerview.MyRecyclerAdapter;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private MyRecycler mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mRecyclerView = (MyRecycler) findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Integer> items = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            items.add(i);
        }
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(this, items, mRecyclerView);
        mRecyclerView.setAdapter(adapter);
    }
}
