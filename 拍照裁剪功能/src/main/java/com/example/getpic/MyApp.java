package com.example.getpic;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

/**
 * Created by fanhengbiao on 16-11-10.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
