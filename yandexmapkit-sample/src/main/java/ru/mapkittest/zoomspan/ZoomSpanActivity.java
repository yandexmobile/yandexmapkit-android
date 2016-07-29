package ru.mapkittest.zoomspan;



import java.util.List;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import ru.mapkittest.R;
import ru.yandex.yandexmapkit.MapController;
import ru.yandex.yandexmapkit.MapView;
import ru.yandex.yandexmapkit.OverlayManager;
import ru.yandex.yandexmapkit.map.MapEvent;
import ru.yandex.yandexmapkit.map.OnMapListener;
import ru.yandex.yandexmapkit.overlay.Overlay;
import ru.yandex.yandexmapkit.overlay.OverlayItem;
import ru.yandex.yandexmapkit.overlay.balloon.BalloonItem;
import ru.yandex.yandexmapkit.overlay.balloon.BalloonRender;
import ru.yandex.yandexmapkit.utils.GeoPoint;

/**
 * ZoomSpanActivity.java
 *
 * This file is a part of the Yandex Map Kit.
 *
 * Version for Android © 2012 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.ru/mapkit/
 *
 */
public class ZoomSpanActivity extends Activity {
    /** Called when the activity is first created. */
    MapController mMapController;
    OverlayManager mOverlayManager;
    Overlay mOverlay;
    
    private static final String TAG = "ZoomSpanActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.sample14_head);

        setContentView(R.layout.sample6);

        MapView mapView = (MapView) findViewById(R.id.map);

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
        mOverlay = new Overlay(mMapController);

        // Create an object for the layer
        final OverlayItem kremlin = new OverlayItem(new GeoPoint(55.752004 , 37.617017), res.getDrawable(R.drawable.shop));
        // Create a balloon model for the object
        BalloonItem balloonKremlin = new BalloonItem(this,kremlin.getGeoPoint());
        balloonKremlin.setText(getString(R.string.kremlin));
//        // Add the balloon model to the object
        kremlin.setBalloonItem(balloonKremlin);
        // Add the object to the layer
        mOverlay.addOverlayItem(kremlin);

        // Create an object for the layer
        final OverlayItem berlin = new OverlayItem(new GeoPoint(52.492497 , 13.426505), res.getDrawable(R.drawable.shop));
        // Create the balloon model for the object
        BalloonItem balloonBerlin = new BalloonItem(this,berlin.getGeoPoint());
        balloonBerlin.setText(getString(R.string.berlin));
        // Add the balloon model to the object
        berlin.setBalloonItem(balloonBerlin);
        // Add the object to the layer
        mOverlay.addOverlayItem(berlin);
        
        final OverlayItem omsk = new OverlayItem(new GeoPoint(54.981492 , 73.363598), res.getDrawable(R.drawable.shop));
        // Create the balloon model for the object
        BalloonItem balloonOmsk = new BalloonItem(this,omsk.getGeoPoint());
        balloonOmsk.setText(getString(R.string.omsk));
        // Add the balloon model to the object
        omsk.setBalloonItem(balloonOmsk);
        // Add the object to the layer
        mOverlay.addOverlayItem(omsk);

        // Add the layer to the map
        mOverlayManager.addOverlay(mOverlay);
        
        
        LinearLayout ll = (LinearLayout)findViewById(R.id.lay);


        Button btn = new Button(this);
        btn.setText("Two");
        btn.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        btn.setGravity(Gravity.CENTER);
        btn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                setZoomSpan(2);
            }
        });

        ll.addView(btn);
        
        btn = new Button(this);
        btn.setText("All");
        btn.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        btn.setGravity(Gravity.CENTER);
        btn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                setZoomSpan(mOverlay.getOverlayItems().size());
            }
        });

        ll.addView(btn);
        
    }
    
    
    private void setZoomSpan(int count){
        List<OverlayItem> list = mOverlay.getOverlayItems();
        double maxLat, minLat, maxLon, minLon;
        maxLat = maxLon = Double.MIN_VALUE;
        minLat = minLon = Double.MAX_VALUE;
        for (int i = 0; i < count; i++){
            GeoPoint geoPoint = list.get(i).getGeoPoint();
            double lat = geoPoint.getLat();
            double lon = geoPoint.getLon();

            maxLat = Math.max(lat, maxLat);
            minLat = Math.min(lat, minLat);
            maxLon = Math.max(lon, maxLon);
            minLon = Math.min(lon, minLon);
        }
        mMapController.setZoomToSpan(maxLat - minLat, maxLon - minLon);
        mMapController.setPositionAnimationTo(new GeoPoint((maxLat + minLat)/2, (maxLon + minLon)/2));
    }

}