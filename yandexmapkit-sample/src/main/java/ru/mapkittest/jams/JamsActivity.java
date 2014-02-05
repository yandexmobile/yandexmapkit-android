package ru.mapkittest.jams;



import android.app.Activity;
import android.os.Bundle;
import ru.mapkittest.R;
import ru.yandex.yandexmapkit.*;

/**
 * Jams.java
 *
 * This file is a part of the Yandex Map Kit.
 *
 * Version for Android © 2012 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.ru/mapkit/
 *
 */
public class JamsActivity extends Activity {
    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.sample5_head);

        setContentView(R.layout.sample);

        final MapView mapView = (MapView) findViewById(R.id.map);
        // Disable determining the user's location
        mapView.getMapController().getOverlayManager().getMyLocation().setEnabled(false);

        mapView.getMapController().setJamsVisible(true);
    }

}