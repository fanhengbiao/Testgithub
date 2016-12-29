package com.rxjva.aa.testgithub;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.AnalyticsListener;
import com.androidnetworking.interfaces.BitmapRequestListener;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.xmlpull.v1.XmlPullParser;

import java.io.File;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.rxandroidnetworking.RxAndroidNetworking;
import com.rxjva.aa.testgithub.Util;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.R.attr.path;

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
     *
     * @param view
     */
    public void onclick_get(View view) {
//        List<NameValuePair> packageParams = new LinkedList<NameValuePair>();
//        packageParams.add(new BasicNameValuePair("appid", "wx7c35ac6495868a48"));
//        packageParams.add(new BasicNameValuePair("body", "11"));
//        packageParams.add(new BasicNameValuePair("mch_id", "1359749402"));
//        packageParams.add(new BasicNameValuePair("nonce_str", UtilTool.genNonceStr()));
//        packageParams.add(new BasicNameValuePair("notify_url", "http://jy.jnoo.com/notifywxapp.php"));
//        packageParams.add(new BasicNameValuePair("out_trade_no", "1266319201201612091141281773"));
//        packageParams.add(new BasicNameValuePair("spbill_create_ip", UtilTool.getIpAddress()));
//        packageParams.add(new BasicNameValuePair("total_fee", "11"));
//        packageParams.add(new BasicNameValuePair("trade_type", "APP"));
//        String sign = UtilTool.genPackageSign(packageParams);
//        packageParams.add(new BasicNameValuePair("sign", sign));
//        String xmlstring = UtilTool.toXml(packageParams);
//       final String s;
//        try {
//              s = new String(xmlstring.toString().getBytes(), "ISO8859-1");
//            final HashMap<String,String> parmMap=new HashMap<>();
//            parmMap.put("",s);
////        RxAndroidNetworking.get("http://testapi.xmcrtech.com:6677//News/Location/Month/2015-12?format=json")
//            final HashMap<String,String> map=new HashMap<>();
//            map.put("Accept","application/json");
//            map.put("Content-type","application/json");
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
////                String result = HttpUtil.post("https://api.mch.weixin.qq.com/pay/unifiedorder", parmMap, map);
////                textView.setText("get_text" + result.toString());
//                    String url = String.format("https://api.mch.weixin.qq.com/pay/unifiedorder");
//                    byte[] buf = Util.httpPost(url, s);
//                    String content = new String(buf);
//                    Map<String, String> xml = decodeXml(content);
//                    Looper.prepare();
//                    Toast.makeText(MainActivity.this,xml.toString(),Toast.LENGTH_SHORT).show();
//                    Looper.loop();
////                    Message message=new Message();
////                    message.obj=xml;
////                    message.what=0;
////                    handler.dispatchMessage(message);
//                }
//            }).start();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

//        RxAndroidNetworking.post("http://testapi.xmcrtech.com/register?format=json&PhoneNumberCode=691665&RegisterType=1&AutoLogin=true&Password=12345678&PhoneNumber=15880268607")
////        RxAndroidNetworking.post("https://api.mch.weixin.qq.com/pay/unifiedorder")
////                .addHeaders(map)//加入头部,可以用string或者hasmap
////                .addBodyParameter(map)
////                .addPathParameter()//对url的补充
////                .addQueryParameter(parmMap)//添加需要传入的参数,可以字符串或者hasmap
////                .addQueryParameter(map)
//                .setTag("get")//做标记,可以取消任务
//
//                .build()
//                .setAnalyticsListener(new AnalyticsListener() {//这个方法可以知道用时,是否来自缓存等信息
//                    @Override
//                    public void onReceived(long timeTakenInMillis, long bytesSent, long bytesReceived, boolean isFromCache) {
//                        Log.e("onReceived", "" + timeTakenInMillis);
//                        Log.e("onReceived", "" + bytesSent);
//                        Log.e("onReceived", "" + bytesReceived);
//                        Log.e("onReceived", "" + isFromCache);
//                    }
//                })
//                .getParseObservable(new TypeToken<String>() {//实体类最好用GsonFormat制作
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("get_onError", "" + e.getMessage());
//                        textView.setText("get_onError" + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        Log.e("get_onNext", "" + s.toString());
//                        textView.setText("get_text" + s.toString());
//                    }
//                });
        RxAndroidNetworking.upload("http://jy.leejia.cn/index.php?s=/Live/Api/uploadImg/key/jnooo/vcode/9441020bd47843e473c78bb4861639cf/")
                .addMultipartFile("file", new File("http://4493bz.1985t.com/uploads/allimg/150127/4-15012G52133.jpg"))
                .setPriority(Priority.IMMEDIATE)
                .build()
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
                        textView.setText("get_onError" + e.getMessage());
                        Log.e("get_onError", "" + e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        textView.setText("get_text" + s.toString());
                        Log.e("get_onNext", "" + s.toString());
                    }
                });


    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==0){
                Map<String, String> obj = (Map<String, String>) msg.obj;
//                textView.setText("get_text" + obj.toString());
                Toast.makeText(MainActivity.this,obj.toString(),Toast.LENGTH_SHORT).show();
            }
        }
    };
    public Map<String, String> decodeXml(String content) {
        try {
            Map<String, String> xml = new HashMap<String, String>();
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(new StringReader(content));
            int event = parser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {

                String nodeName = parser.getName();
                switch (event) {
                    case XmlPullParser.START_DOCUMENT:

                        break;
                    case XmlPullParser.START_TAG:

                        if ("xml".equals(nodeName) == false) {
                            // 实例化student对象
                            xml.put(nodeName, parser.nextText());
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                }
                event = parser.next();
            }

            return xml;
        } catch (Exception e) {
        }
        return null;

    }

    /**
     * 图片下载
     *
     * @param view
     */
    public void onclick_downimage(View view) {
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
                        Log.e("ondown_image_onError", "" + error.getMessage());
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
