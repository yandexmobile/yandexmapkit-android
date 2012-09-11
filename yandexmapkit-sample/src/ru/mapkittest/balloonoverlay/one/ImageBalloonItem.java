package ru.mapkittest.balloonoverlay.one;



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
    protected TextView textView;
    Context mContext;

    public ImageBalloonItem(Context context, GeoPoint geoPoint) {
        super(context, geoPoint);
        mContext = context;
    }

    @Override
    public void inflateView(Context context){

        LayoutInflater inflater = LayoutInflater.from( context );
        model = (ViewGroup)inflater.inflate(R.layout.balloon_image_layout, null);
        imageView = (ImageView)model.findViewById( R.id.balloon_image_view1 );
        textView = (TextView)model.findViewById( R.id.balloon_text_view1 );
        setText(textView.getText());
    }

    public void setImageId(int imageId){
        if (imageView != null){
            imageView.setImageResource( imageId );
            setChange(true);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        if (imageView != null){
            imageView.setImageBitmap(bitmap);
            setChange(true);
        }
    }

    public void setOnViewClickListener(){
        setOnBalloonViewClickListener(R.id.balloon_image_view1, this);
        setOnBalloonViewClickListener(R.id.balloon_text_view1, this);
    }

    @Override
    public void onBalloonViewClick(BalloonItem item, View view) {
        // TODO Auto-generated method stub
        AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
        switch (view.getId()) {
        case R.id.balloon_image_view1:
            dialog.setTitle("Click image");
            break;
        case R.id.balloon_text_view1:
            dialog.setTitle("Click text");
            break;    
        }
        dialog.show();

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