package ru.mapkittest.draggableoverlay;



import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import ru.mapkittest.R;
import ru.yandex.yandexmapkit.*;
import ru.yandex.yandexmapkit.overlay.balloon.BalloonItem;
import ru.yandex.yandexmapkit.overlay.balloon.BalloonRender;
import ru.yandex.yandexmapkit.overlay.drag.DragAndDropItem;
import ru.yandex.yandexmapkit.overlay.drag.DragAndDropOverlay;
import ru.yandex.yandexmapkit.utils.GeoPoint;

/**
 * DraggableOverlayItem.java
 *
 * This file is a part of the Yandex Map Kit.
 *
 * Version for Android © 2012 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.ru/mapkit/
 *
 */
public class DraggableOverlayActivity extends Activity {
    /** Called when the activity is first created. */
    MapController mMapController;
    OverlayManager mOverlayManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.sample4_head);

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
        // Load the required resources
        Resources res = getResources();

        float density = getResources().getDisplayMetrics().density;
        int offsetX = (int)(-7 * density);
        int offsetY = (int)(20 * density);
        
        // Create a layer of objects for the map
        DragAndDropOverlay overlay = new DragAndDropOverlay(mMapController);

        // Create an object for the layer
        DragAndDropItem drag1Item = new DragAndDropItem(new GeoPoint(55.752004 , 37.617017), res.getDrawable(R.drawable.drag1));
        // Set offsets of the image to match the balloon tail with the specified GeoPoint
        
        drag1Item.setOffsetX(offsetX);
        drag1Item.setOffsetY(offsetY);
        // Make the object draggable
        drag1Item.setDragable(true);

        // Create a balloon model for the object
        BalloonItem balloonDrar1 = new BalloonItem(this,drag1Item.getGeoPoint());
        balloonDrar1.setText(getString(R.string.drag));
        // Set the additional balloon offset
        balloonDrar1.setOffsetX(offsetX);
        // Add the balloon model to the object
        drag1Item.setBalloonItem(balloonDrar1);
        // Add the object to the layer
        overlay.addOverlayItem(drag1Item);


        // Create an object for the layer
        DragAndDropItem drag2Item = new DragAndDropItem(new GeoPoint(55.734029 , 37.588499), res.getDrawable(R.drawable.drag2));
        // Set offsets of the image to match the balloon tail with the specified GeoPoint
        drag2Item.setOffsetX(offsetX);
        drag2Item.setOffsetY(offsetY);
        // Make the object draggable
        drag2Item.setDragable(true);

        // Create the balloon model for the object
        BalloonItem balloonDrag2 = new BalloonItem(this,drag2Item.getGeoPoint());
        balloonDrag2.setText(getString(R.string.drag));
        // Set the additional balloon offset
        balloonDrag2.setOffsetX(offsetX);
        // Add the balloon model to the object
        drag2Item.setBalloonItem(balloonDrag2);
        // Add the object to the layer
        overlay.addOverlayItem(drag2Item);

        // Add the layer to the map
        mOverlayManager.addOverlay(overlay);
    }
}