package ru.mapkittest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * YandexMapKitSample.java: Main activity
 *
 * This file is a part of the Yandex Map Kit.
 *
 * Version for Android © 2012 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.ru/mapkit/
 *
 */
public class YandexMapKitSampleActivity extends ListActivity {

    public final String MAPKIT = "yandex.intent.category.MAPKIT";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.app_name_head);

        setListAdapter(new SimpleAdapter(this, getData(),
                R.layout.item, new String[] { "title" , "info" },
                new int[] { R.id.head , R.id.info}));
        getListView().setTextFilterEnabled(true);
    }

    protected List<Map<String, Object>> getData() {
        List<Map<String, Object>> myData = new ArrayList<Map<String, Object>>();

        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(MAPKIT);
//        mainIntent.addCategory(Intent.CATEGORY_DEFAULT);

        PackageManager pm = getPackageManager();
        List<ResolveInfo> list = pm.queryIntentActivities(mainIntent, 0);

        if (null == list)
            return myData;

        String[] prefixPath = null ;

        int len = list.size();

        for (int i = 0; i < len; i++) {
            ResolveInfo info = list.get(i);
            CharSequence labelSeq = info.loadLabel(pm);

            String label = labelSeq != null
            ? labelSeq.toString()
                    : info.activityInfo.name;

            String labAdd = label;
            String infoAdd = "";
            prefixPath = label.split("/");

            if (prefixPath.length > 1){
                labAdd = prefixPath[0];
                infoAdd = prefixPath[1];
            }
            addItem(myData, labAdd, infoAdd, activityIntent(
                    info.activityInfo.applicationInfo.packageName,
                    info.activityInfo.name));
        }

        return myData;
    }

    protected Intent activityIntent(String pkg, String componentName) {
        Intent result = new Intent();
        result.setClassName(pkg, componentName);
        return result;
    }

    protected void addItem(List<Map<String,Object>> data, String name, String info,  Intent intent) {
        Map<String, Object> temp = new HashMap<String, Object>();
        temp.put("title", name);
        temp.put("info", info);
        temp.put("intent", intent);
        data.add(temp);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Map map = (Map) l.getItemAtPosition(position);
        Intent intent = (Intent) map.get("intent");
        startActivity(intent);
    }
}
