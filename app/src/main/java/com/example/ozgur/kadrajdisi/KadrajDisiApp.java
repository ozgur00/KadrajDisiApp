package com.example.ozgur.kadrajdisi;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by ozgur on 06.03.2018.
 */

public class KadrajDisiApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                                        .setDefaultFontPath(getString(R.string.font_name))
                                        .setFontAttrId(R.attr.fontPath)
                                        .build());
    }
}
