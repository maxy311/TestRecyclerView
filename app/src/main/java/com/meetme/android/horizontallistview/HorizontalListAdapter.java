package com.meetme.android.horizontallistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wutian.maxy.testrecyclerview.R;

import java.util.List;

import static com.wutian.maxy.testrecyclerview.R.id.textView;

/**
 * Created by Maxy on 2017/4/23.
 */

public class HorizontalListAdapter extends BaseAdapter {
    private List<Integer> mItems;
    private LayoutInflater mInflater;
    public HorizontalListAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }
        @Override
    public int getCount() {
        if (mItems == null)
        return 0;
        return   mItems.size();
    }


    @Override
    public Object getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mItems.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyHolder holder = null;
        if (view == null) {
            holder = new MyHolder();
            view = mInflater.inflate(R.layout.item_view, viewGroup, false);
            holder.mTextView = (TextView) view.findViewById(textView);

            view.setTag(holder);
        } else
         holder = (MyHolder) view.getTag();

        holder.mTextView.setText(mItems.get(i) + "");
        return view;
    }

    public void setItems(List<Integer> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    public class MyHolder {
       TextView mTextView;
    }
}
