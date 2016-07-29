package ru.mapkittest.path;

import java.util.ArrayList;

import android.graphics.drawable.Drawable;
import ru.yandex.yandexmapkit.overlay.OverlayItem;
import ru.yandex.yandexmapkit.utils.GeoPoint;
import ru.yandex.yandexmapkit.utils.ScreenPoint;

public class OverlayRectItem extends OverlayItem {

    ArrayList<GeoPoint> geoPoint = new ArrayList<GeoPoint>();
    ArrayList<ScreenPoint> screenPoint = new ArrayList<ScreenPoint>();
    
    public OverlayRectItem(GeoPoint geoPoint, Drawable drawable) {
        super(geoPoint, drawable);
        // TODO Auto-generated constructor stub
    }

    @Override
    public int compareTo(Object object) {
        int thisPriority = getPriority();
        int itemPriority = ((OverlayItem) object).getPriority();

        if (thisPriority < itemPriority) {
            return -1;
        } else if (thisPriority == itemPriority) {
            return 0;
        } else {
            return 1;
        }
    }
}
