package ru.mapkittest.mylocation;


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
import ru.yandex.yandexmapkit.overlay.location.MyLocationItem;
import ru.yandex.yandexmapkit.overlay.location.OnMyLocationListener;

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
public class MapMyLocationChangeActivity extends Activity implements OnMyLocationListener{
    /** Called when the activity is first created. */
    MapController mMapController;
    LinearLayout mView;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.sample11_head);

        setContentView(R.layout.sample8);

        final MapView mapView = (MapView) findViewById(R.id.map);
        mapView.showBuiltInScreenButtons(true);

        mMapController = mapView.getMapController();
        // add listener
        mMapController.getOverlayManager().getMyLocation().addMyLocationListener(this);

        mView = (LinearLayout)findViewById(R.id.view);
        
    }
    
    @Override
    public void onMyLocationChange(MyLocationItem myLocationItem) {
        // TODO Auto-generated method stub
        final TextView textView = new TextView(this);
        textView.setText("Type " + myLocationItem.getType()+" GeoPoint ["+myLocationItem.getGeoPoint().getLat()+","+myLocationItem.getGeoPoint().getLon()+"]");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                mView.addView(textView);
            }
        });

        
    }

}