package com.rxjva.aa.testgithub;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

/**
 * Created by fanhengbiao on 16-10-9.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化
        AndroidNetworking.initialize(this);
    }
}
