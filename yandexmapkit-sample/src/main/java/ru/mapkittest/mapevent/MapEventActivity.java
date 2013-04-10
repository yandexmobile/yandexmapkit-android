package ru.mapkittest.mapevent;


import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import ru.mapkittest.R;
import ru.yandex.yandexmapkit.*;
import ru.yandex.yandexmapkit.map.MapEvent;
import ru.yandex.yandexmapkit.map.MapLayer;
import ru.yandex.yandexmapkit.map.OnMapListener;

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
public class MapEventActivity extends Activity implements OnMapListener{
    /** Called when the activity is first created. */
    private final int CLEAR = 1; 


    MapController mMapController;
    LinearLayout mView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.sample8_head);

        setContentView(R.layout.sample8);

        final MapView mapView = (MapView) findViewById(R.id.map);
        mapView.showBuiltInScreenButtons(true);

        mMapController = mapView.getMapController();
        // add listener
        mMapController.addMapListener(this);

        mView = (LinearLayout)findViewById(R.id.view);

    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        menu.add(1, CLEAR, 1, "CLEAR");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        if (item.getItemId() == CLEAR){
            mView.removeAllViews();
        }
        return true;
    }
    

    @Override
    public void onMapActionEvent(MapEvent event) {

        final TextView textView = new TextView(this);

        switch (event.getMsg()) {
        case MapEvent.MSG_SCALE_BEGIN:
            textView.setText("MSG_SCALE_BEGIN");
            break;
        case MapEvent.MSG_SCALE_MOVE:
            textView.setText("MSG_SCALE_MOVE");
            break;
        case MapEvent.MSG_SCALE_END:
            textView.setText("MSG_SCALE_END");
            break;

        case MapEvent.MSG_ZOOM_BEGIN:
            textView.setText("MSG_ZOOM_BEGIN");
            break;
        case MapEvent.MSG_ZOOM_MOVE:
            textView.setText("MSG_ZOOM_MOVE");
            break;
        case MapEvent.MSG_ZOOM_END:
            textView.setText("MSG_ZOOM_END");
            break;

        case MapEvent.MSG_SCROLL_BEGIN:
            textView.setText("MSG_SCROLL_BEGIN");
            break;
        case MapEvent.MSG_SCROLL_MOVE:
            textView.setText("MSG_SCROLL_MOVE");
            break;
        case MapEvent.MSG_SCROLL_END:    
            textView.setText("MSG_SCROLL_END");
            break;
        default:
            textView.setText("MSG_EMPTY");
            break;
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                mView.addView(textView);
            }
        });


    }

}