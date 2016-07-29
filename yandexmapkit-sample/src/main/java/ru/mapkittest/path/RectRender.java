package ru.mapkittest.path;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import ru.yandex.yandexmapkit.overlay.IRender;
import ru.yandex.yandexmapkit.overlay.OverlayItem;
import ru.yandex.yandexmapkit.utils.ScreenPoint;

public class RectRender implements IRender {

    @Override
    public void draw(Canvas canvas, OverlayItem item_) {
        // TODO Auto-generated method stub
        
        Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(6);
        OverlayRectItem item  = (OverlayRectItem)item_;
        Path p = new Path();
        if (item.screenPoint != null && item.screenPoint.size() > 0)
        {
            ScreenPoint screenPoint = item.screenPoint.get(0);
            p.moveTo(screenPoint.getX(), screenPoint.getY());

            for (int i = 1; i<item.screenPoint.size(); i++ ){
                screenPoint = item.screenPoint.get(i);
                p.lineTo(screenPoint.getX(), screenPoint.getY());
            }
            canvas.drawPath(p, mPaint);
        }
    }
}
