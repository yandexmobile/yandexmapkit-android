package ru.mapkittest.maphd;


import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
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
public class MapHDTilesActivity extends Activity {
    /** Called when the activity is first created. */
    MapController mMapController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.sample7_head);

        setContentView(R.layout.sample6);

        final MapView mapView = (MapView) findViewById(R.id.map);
//        mapView.showBuiltInScreenButtons(true);
        mMapController = mapView.getMapController();
        // Disable determining the user's location
        mMapController.getOverlayManager().getMyLocation().setEnabled(false);

        LinearLayout ll = (LinearLayout)findViewById(R.id.lay);


        Button btn = new Button(this);
        btn.setText("HDMode");
        btn.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        btn.setGravity(Gravity.CENTER);
        btn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                mMapController.setHDMode(!mMapController.isHDMode());
            }
        });

        ll.addView(btn);
        
        btn = new Button(this);
        btn.setText("NightMode");
        btn.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        btn.setGravity(Gravity.CENTER);
        btn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                mMapController.setNightMode(!mMapController.isNightMode());
            }
        });

        ll.addView(btn);
        
    }

}