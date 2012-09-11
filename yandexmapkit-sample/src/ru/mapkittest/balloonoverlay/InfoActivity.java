package ru.mapkittest.balloonoverlay;

import ru.mapkittest.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * InfoActivity.java
 *
 * This file is a part of the Yandex Map Kit.
 *
 * Version for Android © 2012 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.ru/mapkit/
 *
 */
public class InfoActivity extends Activity {
    public final static String ID_INFO =  "info";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        String info = getIntent().getStringExtra(ID_INFO);

        setContentView(R.layout.info);

        if (info!= null){
            TextView text = (TextView)findViewById(R.id.info);
            text.setText(info);
        }

    }
}
