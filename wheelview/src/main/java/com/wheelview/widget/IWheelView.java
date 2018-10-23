package com.wheelview.widget;

import com.wheelview.widget.adapters.WheelViewAdapter;

/**
 * Created by Aislli on 2018/10/23 0023.
 */
public interface IWheelView {
    WheelViewAdapter getViewAdapter();

    boolean isCyclic();

    void setCurrentItem(int index, boolean animated);

    void setCurrentItem(int index);

    int getCurrentItem();
}
