package com.lcp.wheelview;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.lcp.wheelview.adapter.MyGroupViewAdapter;
import com.lcp.wheelview.adapter.MyViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private WheelView2 wheelview, wheelview0;
    private long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wheelview0 = (WheelView2) findViewById(R.id.wheelview0);
        wheelview0.setFocusDrawable(getResources().getDrawable(R.mipmap.channel_buttom_06));
        wheelview0.setSelectDrawable(getResources().getDrawable(R.mipmap.channel_buttom_07));

        wheelview = (WheelView2) findViewById(R.id.wheelview);
        wheelview.setCyclic(true);
        wheelview.setFocusDrawable(getResources().getDrawable(R.mipmap.channel_buttom_06));
        wheelview.setSelectDrawable(getResources().getDrawable(R.mipmap.channel_buttom_07));
        initData();
    }

    private void initData() {
        ArrayList<String> strings3 = new ArrayList<>();
        strings3.add("全部频道");
        strings3.add("国内频道");
        strings3.add("国际频道");
        wheelview0.setViewAdapter(new MyGroupViewAdapter(strings3));

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            strings.add("" + i);
        }
        wheelview.setViewAdapter(new MyViewAdapter(strings));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
            return changeWheelView(1);
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_UP) {
            return changeWheelView(-1);
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 改变item
     * @param index 滚动几个item
     * @return
    */
    private boolean changeWheelView(int index) {
        WheelView2 focusedWheel = getFocusedWheel();
        if (null == focusedWheel) {
            return false;
        }
        if (SystemClock.uptimeMillis() - startTime < 100) {
            focusedWheel.setCurrentItem(focusedWheel.getCurrentItem() + index);
        } else {
            focusedWheel.setCurrentItem(focusedWheel.getCurrentItem() + index, true);
        }
        startTime = SystemClock.uptimeMillis();
        return true;
    }

    private WheelView2 getFocusedWheel(){
        if (wheelview0.isFocused()) {
            return wheelview0;
        } else if (wheelview.isFocused()) {
            return wheelview;
        }else {
            return null;
        }
    }
}
