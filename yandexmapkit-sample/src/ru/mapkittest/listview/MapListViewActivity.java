package ru.mapkittest.listview;


import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import ru.mapkittest.R;
import ru.yandex.yandexmapkit.*;
import ru.yandex.yandexmapkit.map.MapLayer;

/**
 * MapLayers.java
 *
 * This file is a part of the Yandex Map Kit.
 *
 * Version for Android © 2012 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.ru/mapkit/
 *
 */
public class MapListViewActivity extends ListActivity {
    /** Called when the activity is first created. */

    View mView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        

        setTitle(R.string.sample10_head);
        
        mView  =  getLayoutInflater().inflate(R.layout.sample10, null);
        setListAdapter(new SlowAdapter());
    }
    
    
    private class SlowAdapter extends BaseAdapter {
        
        /**
         */
        public int getCount() {
            return 20;
        }

        /**
         */
        public Object getItem(int position) {
            return position;
        }

        /**
         */
        public long getItemId(int position) {
            return position;
        }

        /**
         */
        public View getView(int position, View convertView, ViewGroup parent) {
            if (position == 10 && mView !=null){
                return mView;
            }else{
                Button button = new Button(parent.getContext());
                button.setText("Кнопка " +  position);
                return button;
            }
        }
    }

}