package ru.mapkittest.balloonoverlay.two;



import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ru.mapkittest.R;
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
public class ImageBalloonItem extends BalloonItem implements OnBalloonListener{

    protected ImageView imageView;
    Context mContext;

    public ImageBalloonItem(Context context, GeoPoint geoPoint) {
        super(context, geoPoint);
        mContext = context;
    }

    @Override
    public void inflateView(Context context){

        LayoutInflater inflater = LayoutInflater.from( context );
        model = (ViewGroup)inflater.inflate(R.layout.balloon_images_layout, null);
    }

    
    public void setOnViewClickListener(){
        setOnBalloonViewClickListener(R.id.balloon_images_view1, this);
        setOnBalloonViewClickListener(R.id.balloon_images_view2, this);
        setOnBalloonViewClickListener(R.id.balloon_images_view3, this);
        setOnBalloonViewClickListener(R.id.balloon_images_view4, this);
    }

    @Override
    public void onBalloonViewClick(BalloonItem item, View view) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
        dialog.setTitle((String)view.getTag());
        dialog.show();
    }

    @Override
    public void onBalloonShow(BalloonItem balloonItem) {
    }

    @Override
    public void onBalloonHide(BalloonItem balloonItem) {

    }

    @Override
    public void onBalloonAnimationStart(BalloonItem balloonItem) {

    }

    @Override
    public void onBalloonAnimationEnd(BalloonItem balloonItem) {
    }
}