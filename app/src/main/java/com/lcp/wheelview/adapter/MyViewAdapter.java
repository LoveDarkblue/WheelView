package com.lcp.wheelview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lcp.wheelview.R;
import com.wheelview.widget.adapters.AbstractWheelAdapter;

import java.util.List;

/**
 * Created by Aislli on 2018/10/22 0022.
 */
public class MyViewAdapter extends AbstractWheelAdapter {

    private List<String> mList;

    public MyViewAdapter(List<String> mList) {
        this.mList = mList;
    }

    @Override
    public int getItemsCount() {
        if (null == mList || mList.size() <= 0) {
            return 0;
        }
        return mList.size();
    }

    @Override
    public View getItem(int index, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text, parent, false);
            holder = new ViewHolder();
            holder.tv_num = (TextView) convertView.findViewById(R.id.tv_num);
            holder.tv_title = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_num.setText(mList.get(index));
        return convertView;
    }

    private class ViewHolder {
        private TextView tv_num;
        private TextView tv_title;
    }
}
