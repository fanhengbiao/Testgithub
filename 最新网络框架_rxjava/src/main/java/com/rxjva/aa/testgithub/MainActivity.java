package com.rxjva.aa.testgithub;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.AnalyticsListener;
import com.androidnetworking.interfaces.BitmapRequestListener;
import com.google.gson.reflect.TypeToken;
import com.rxandroidnetworking.RxAndroidNetworking;

import java.util.HashMap;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    /**
     * get
     * @param view
     */
    public void  onclick_get(View view){
        HashMap<String, String> map = new HashMap<>();
        map.put("Password", "123456");
        map.put("PhoneNumber", "15880268607");
        map.put("PhoneNumberCode", "912512");
        map.put("RegisterType", "1");
        map.put("AutoLogin", "true");
//        RxAndroidNetworking.get("http://testapi.xmcrtech.com:6677//News/Location/Month/2015-12?format=json")
        RxAndroidNetworking.post("http://testapi.xmcrtech.com/register?format=json&PhoneNumberCode=691665&RegisterType=1&AutoLogin=true&Password=12345678&PhoneNumber=15880268607")
//                .addHeaders()//加入头部,可以用string或者hasmap
//                .addPathParameter()//对url的补充
//                .addQueryParameter()//添加需要传入的参数,可以字符串或者hasmap
//                .addQueryParameter(map)
                .setTag("get")//做标记,可以取消任务

                .build()
                .setAnalyticsListener(new AnalyticsListener() {//这个方法可以知道用时,是否来自缓存等信息
                    @Override
                    public void onReceived(long timeTakenInMillis, long bytesSent, long bytesReceived, boolean isFromCache) {
                        Log.e("onReceived",""+timeTakenInMillis);
                        Log.e("onReceived",""+bytesSent);
                        Log.e("onReceived",""+bytesReceived);
                        Log.e("onReceived",""+isFromCache);
                    }
                })
                .getParseObservable(new TypeToken<String>() {//实体类最好用GsonFormat制作
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("get_onError",""+e.getMessage());
                        textView.setText("get_onError"+e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("get_onNext",""+s.toString());
                        textView.setText("get_text"+s.toString());
                    }
                });


    }

    /**
     * 图片下载
     * @param view
     */
    public void onclick_downimage(View view){
        AndroidNetworking.get("http://pic44.nipic.com/20140721/11624852_001107119409_2.jpg")
                .setTag("imageRequestTag")
                .setPriority(Priority.MEDIUM)
//                .setBitmapMaxHeight(200)
//                .setBitmapMaxWidth(200)
                .setBitmapConfig(Bitmap.Config.ARGB_8888)
                .build()
                .getAsBitmap(new BitmapRequestListener() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        // do anything with bitmap
                        imageView.setImageBitmap(bitmap);
                    }
                    @Override
                    public void onError(ANError error) {
                        // handle error
                        Log.e("ondown_image_onError",""+error.getMessage());
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消进程
        AndroidNetworking.cancel("get");
    }
}
