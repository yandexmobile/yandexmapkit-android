package ru.mapkittest.geocode;


import android.app.Activity;
import android.os.Bundle;
import ru.mapkittest.R;
import ru.yandex.yandexmapkit.*;

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
public class MapGeoCodeActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.sample13_head);

        setContentView(R.layout.sample);

        final MapView mapView = (MapView) findViewById(R.id.map);
        mapView.showBuiltInScreenButtons(true);

        mapView.getMapController().getOverlayManager().addOverlay(new OverlayGeoCode(mapView.getMapController()));

    }
}