package ru.mapkittest.scrollview;


import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
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
public class MapScrollViewActivity extends Activity implements OnMapListener{
    /** Called when the activity is first created. */
    MapController mMapController;
    LinearLayout mView;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.sample9_head);

        setContentView(R.layout.sample9);

        final MapView mapView = (MapView) findViewById(R.id.map);
        mapView.showBuiltInScreenButtons(true);

        mMapController = mapView.getMapController();
        // add listener
        mMapController.addMapListener(this);

        mView = (LinearLayout)findViewById(R.id.view);
        
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