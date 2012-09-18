package ru.mapkittest.balloonoverlay;



import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import ru.mapkittest.R;
import ru.yandex.yandexmapkit.*;
import ru.yandex.yandexmapkit.overlay.Overlay;
import ru.yandex.yandexmapkit.overlay.OverlayItem;
import ru.yandex.yandexmapkit.overlay.balloon.BalloonItem;
import ru.yandex.yandexmapkit.overlay.balloon.OnBalloonListener;
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
public class BalloonOverlayActivity extends Activity implements OnBalloonListener {
    /** Called when the activity is first created. */
    MapController mMapController;
    OverlayManager mOverlayManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.sample2_head);

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
        OverlayItem kremlin = new OverlayItem(new GeoPoint(55.752004 , 37.617017), res.getDrawable(R.drawable.kreml));
        // Create a balloon model for the object
        BalloonItem balloonKremlin = new BalloonItem(this,kremlin.getGeoPoint());
        balloonKremlin.setText("Московский Кремль. Здесь можно ещё много о чём написать.");        
        //
        balloonKremlin.setOnBalloonListener(this);
        //        // Add the balloon model to the object
        kremlin.setBalloonItem(balloonKremlin);
        // Add the object to the layer
        overlay.addOverlayItem(kremlin);


        // Create an object for the layer
        OverlayItem yandex = new OverlayItem(new GeoPoint(55.734029 , 37.588499), res.getDrawable(R.drawable.shop));
        // Create the balloon model for the object
        BalloonItem balloonYandex = new BalloonItem(this, yandex.getGeoPoint());
        balloonYandex.setText("yandex");
        balloonYandex.setOnBalloonListener(this);
        // Add the balloon model to the object
        yandex.setBalloonItem(balloonYandex);
        // Add the object to the layer
        overlay.addOverlayItem(yandex);

        // Add the layer to the map
        mOverlayManager.addOverlay(overlay);

    }


    @Override
    public void onBalloonViewClick(BalloonItem balloonItem, View view)  {
        OverlayItem item = balloonItem.getOverlayItem();

        Intent intent = new Intent().setClass(this, InfoActivity.class);
        if (balloonItem.getText() != null){
            intent.putExtra(InfoActivity.ID_INFO, balloonItem.getText());
        }else{
            intent.putExtra(InfoActivity.ID_INFO, "Яндекс");
        }
        startActivity(intent);
    }

    @Override
    public void onBalloonShow(BalloonItem balloonItem) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onBalloonHide(BalloonItem balloonItem) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onBalloonAnimationStart(BalloonItem balloonItem) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onBalloonAnimationEnd(BalloonItem balloonItem) {
        // TODO Auto-generated method stub

    }


}