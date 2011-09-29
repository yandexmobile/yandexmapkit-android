package ru.mapkittest.defaultoverlay;



import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import ru.mapkittest.R;
import ru.yandex.yandexmapkit.MapController;
import ru.yandex.yandexmapkit.MapView;
import ru.yandex.yandexmapkit.OverlayManager;
import ru.yandex.yandexmapkit.overlay.Overlay;
import ru.yandex.yandexmapkit.overlay.OverlayItem;
import ru.yandex.yandexmapkit.overlay.balloon.BalloonItem;
import ru.yandex.yandexmapkit.overlay.balloon.BalloonRender;
import ru.yandex.yandexmapkit.utils.GeoPoint;

/**
 * DefaulOverlay.java
 *
 * This file is a part of the Yandex Map Kit.
 *
 * Version for Android © 2011 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.ru/mapkit/
 *
 */
public class DefaultOverlay extends Activity {
    /** Called when the activity is first created. */
    MapController mMapController;
    OverlayManager mOverlayManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.sample1_head);

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
        Bitmap innerBitmap = BitmapFactory.decodeResource(res , R.drawable.shop);

        // Create a layer of objects for the map
        Overlay overlay = new Overlay(mMapController);

        // Create an object for the layer
        OverlayItem kremlin = new OverlayItem(new GeoPoint(55.752004 , 37.617017), innerBitmap);
        // Create a balloon model for the object
        BalloonItem balloonKremlin = new BalloonItem(kremlin.getGeoPoint(), innerBitmap);
        balloonKremlin.setAlign(BalloonRender.ALIGN_LEFT | BalloonRender.ALIGN_CENTER);
        balloonKremlin.setText(getString(R.string.kremlin));
        // Add the balloon model to the object
        kremlin.setBalloonItem(balloonKremlin);
        // Add the object to the layer
        overlay.addOverlayItem(kremlin);

        // Create an object for the layer
        OverlayItem yandex = new OverlayItem(new GeoPoint(55.734029 , 37.588499), innerBitmap);
        // Create the balloon model for the object
        BalloonItem balloonYandex = new BalloonItem(yandex.getGeoPoint(), innerBitmap);
        balloonYandex.setAlign(BalloonRender.ALIGN_RIGHT | BalloonRender.ALIGN_CENTER);
        balloonYandex.setText(getString(R.string.yandex));
        // Add the balloon model to the object
        yandex.setBalloonItem(balloonYandex);
        // Add the object to the layer
        overlay.addOverlayItem(yandex);

        // Add the layer to the map
        mOverlayManager.addOverlay(overlay);
    }

}