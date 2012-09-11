package ru.mapkittest.geocode;



import android.app.AlertDialog;
import ru.yandex.yandexmapkit.MapController;
import ru.yandex.yandexmapkit.map.GeoCode;
import ru.yandex.yandexmapkit.map.GeoCodeListener;
import ru.yandex.yandexmapkit.overlay.Overlay;
import ru.yandex.yandexmapkit.utils.ScreenPoint;

public class OverlayGeoCode extends Overlay implements GeoCodeListener{

     
    public OverlayGeoCode(MapController mapController) {
        super(mapController);
      
    }

    @Override
    public boolean onSingleTapUp(float x, float y) {
        getMapController().getDownloader().getGeoCode(this, getMapController().getGeoPoint(new ScreenPoint(x, y)));
        return true;
    }

    @Override
    public boolean onFinishGeoCode(final GeoCode geoCode) {
        if (geoCode != null){
            getMapController().getMapView().post(new Runnable() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    AlertDialog.Builder dialog = new AlertDialog.Builder( getMapController().getContext());
                    dialog.setTitle(geoCode.getDisplayName());
                    dialog.show();
                }
            });
        }
        return true;
    }

}
