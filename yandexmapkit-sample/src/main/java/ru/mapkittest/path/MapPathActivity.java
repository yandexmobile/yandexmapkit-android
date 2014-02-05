package ru.mapkittest.path;


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
public class MapPathActivity extends Activity {
    /** Called when the activity is first created. */
    MapController mMapController;
    LinearLayout mView;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.sample12_head);

        setContentView(R.layout.sample);

        final MapView mapView = (MapView) findViewById(R.id.map);
        mapView.showBuiltInScreenButtons(true);

        mMapController = mapView.getMapController();
        
        OverlayRect overlayRect = new OverlayRect(mMapController);
        
        mMapController.getOverlayManager().addOverlay(overlayRect);
        
    }
    
}