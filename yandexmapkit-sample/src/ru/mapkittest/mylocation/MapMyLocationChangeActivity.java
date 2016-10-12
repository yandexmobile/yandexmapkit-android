package ru.mapkittest.mylocation;


import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.LinearLayout;
import android.widget.TextView;

import ru.mapkittest.R;
import ru.yandex.yandexmapkit.MapController;
import ru.yandex.yandexmapkit.MapView;
import ru.yandex.yandexmapkit.overlay.location.MyLocationItem;
import ru.yandex.yandexmapkit.overlay.location.OnMyLocationListener;


/**
 * MapLayers.java
 * <p/>
 * This file is a part of the Yandex Map Kit.
 * <p/>
 * Version for Android © 2012 YANDEX
 * <p/>
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.ru/mapkit/
 */
public class MapMyLocationChangeActivity extends Activity implements OnMyLocationListener {
    /**
     * Called when the activity is first created.
     */
    MapController mMapController;
    LinearLayout mView;

    private static final int PERMISSIONS_CODE = 109;

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

        mView = (LinearLayout) findViewById(R.id.view);

        checkPermission();
    }

    private void checkPermission() {
        int permACL = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        int permAFL = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

        if (permACL != PackageManager.PERMISSION_GRANTED ||
                permAFL != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_CODE);
        }

    }

    @Override
    public void onMyLocationChange(MyLocationItem myLocationItem) {
        // TODO Auto-generated method stub
        final TextView textView = new TextView(this);
        textView.setText("Type " + myLocationItem.getType() + " GeoPoint [" + myLocationItem.getGeoPoint().getLat() + "," + myLocationItem.getGeoPoint().getLon() + "]");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                mView.addView(textView);

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_CODE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mMapController.getOverlayManager().getMyLocation().refreshPermission();
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}