package ru.mapkittest.balloonoverlay.one;



import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import ru.mapkittest.R;
import ru.yandex.yandexmapkit.*;
import ru.yandex.yandexmapkit.overlay.Overlay;
import ru.yandex.yandexmapkit.overlay.OverlayItem;
import ru.yandex.yandexmapkit.utils.GeoPoint;

/**
 * BalloonOverlay.java
 *
 * This file is a part of the Yandex Map Kit.
 *
 * Version for Android © 2012 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.ru/mapkit/
 *
 */
public class BalloonOverlayActivity extends Activity  {
    /** Called when the activity is first created. */
    MapController mMapController;
    OverlayManager mOverlayManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.sample2one_head);

        setContentView(R.layout.sample);

        final MapView mapView = (MapView) findViewById(R.id.map);

        mMapController = mapView.getMapController();

        mOverlayManager = mMapController.getOverlayManager();
        // Disable determining the user's location
        mOverlayManager.getMyLocation().setEnabled(false);

        // A simple implementation of map objects
        showObject();

    }

    public void showObject(){
        // Load required resources
        Resources res = getResources();
        // Create a layer of objects for the map
        Overlay overlay = new Overlay(mMapController);

        // Create an object for the layer
        OverlayItem kremlin = new OverlayItem(new GeoPoint(55.752004 , 37.617017), res.getDrawable(R.drawable.shop));
        // Create a balloon model for the object
        ImageBalloonItem balloonKremlin = new ImageBalloonItem(this,kremlin.getGeoPoint());
//
        balloonKremlin.setOnViewClickListener();
//        // Add the balloon model to the object
        kremlin.setBalloonItem(balloonKremlin);
        // Add the object to the layer
        overlay.addOverlayItem(kremlin);


        // Add the layer to the map
        mOverlayManager.addOverlay(overlay);

    }

}