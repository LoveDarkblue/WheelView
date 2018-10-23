package com.lcp.wheelview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lcp.wheelview.R;
import com.wheelview.widget.adapters.AbstractWheelAdapter;

import java.util.List;

/**
 * Created by Aislli on 2018/10/22 0022.
 */
public class MyGroupViewAdapter extends AbstractWheelAdapter {

    private List<String> mList;

    public MyGroupViewAdapter(List<String> mList) {
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_live_group, parent, false);
            holder = new ViewHolder();
            holder.ilg_btn = (Button) convertView.findViewById(R.id.ilg_btn);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.ilg_btn.setText(mList.get(index));
        return convertView;
    }

    private class ViewHolder {
        private Button ilg_btn;
    }
}
