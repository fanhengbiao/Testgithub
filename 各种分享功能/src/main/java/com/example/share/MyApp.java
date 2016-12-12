package com.example.share;

import android.app.Application;

import cn.sharesdk.framework.ShareSDK;

/**
 * Created by Administrator on 2016/12/5.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ShareSDK.initSDK(this);
    }
}
