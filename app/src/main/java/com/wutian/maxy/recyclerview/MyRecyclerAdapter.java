package com.wutian.maxy.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meetme.android.horizontallistview.HorizontalListAdapter;
import com.meetme.android.horizontallistview.HorizontalListView;
import com.wutian.maxy.testrecyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    private List<Integer> mItems;
    private LayoutInflater mInflater;
    private RecyclerView mRecyclerView;

    public MyRecyclerAdapter(Context context, List<Integer> items) {
        mItems = items;
        mInflater = LayoutInflater.from(context);
    }

    public MyRecyclerAdapter(Context context, List<Integer> integers, RecyclerView recyclerView) {
        mItems = integers;
        mInflater = LayoutInflater.from(context);
        mRecyclerView = recyclerView;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder =  new CommonViewHolder(mInflater.inflate(CommonViewHolder.getlayoutId(), parent, false));
        switch (viewType) {
            case 0:
                holder = new CommonViewHolder(mInflater.inflate(CommonViewHolder.getlayoutId(), parent, false));
                break;
            case 1:
                holder = new SpecialViewHolder(mInflater.inflate(SpecialViewHolder.getlayoutId(), parent, false), mRecyclerView);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bindView(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        protected RecyclerView mRecyclerView;
        public MyViewHolder(View itemView) {
            super(itemView);
        }

        public MyViewHolder(View itemView, RecyclerView recyclerView) {
            super(itemView);
            mRecyclerView = recyclerView;
        }
        public void bindView(int position) {

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 3)
            return 1;
        else
            return 0;
    }

    public static class CommonViewHolder extends MyViewHolder {

        private TextView mTextView;

        public CommonViewHolder(View itemView) {
            super(itemView);

            mTextView = (TextView)itemView.findViewById(R.id.adapter_text);
        }

        public static int getlayoutId() {
            return R.layout.adapter_common_view;
        }

        @Override
        public void bindView(int position) {
            super.bindView(position);

            mTextView.setText(String.valueOf(position));
        }
    }

    public static class SpecialViewHolder extends MyViewHolder {

        private HorizontalListView mListView;
        private HorizontalListAdapter mAdapter;

        public SpecialViewHolder(View inflate, RecyclerView recyclerView) {
            super(inflate, recyclerView);

            mListView = (HorizontalListView)itemView.findViewById(R.id.horizontal_list_view);
            mListView.setRecyclerView(mRecyclerView);
            mAdapter = new HorizontalListAdapter(itemView.getContext());
            mListView.setAdapter(mAdapter);

        }

        public static int getlayoutId() {
            return R.layout.adapter_special_view;
        }

        @Override
        public void bindView(int position) {
            ArrayList<Integer> items = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                items.add(i);
            }
            mAdapter.setItems(items);
        }
    }
}
