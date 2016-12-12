package com.https.aa.testgithub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
    }

    /**
     * https请求 get
     * @param view
     */
    public  void  onclick_https_get(View view){
        final HashMap<String, String> map = new HashMap<>();
        map.put("appid", "wx7c35ac6495868a48");
        map.put("mch_id", "1359749402");
        map.put("nonce_str", "5K8264ILTKCH16CQ2502SI8ZNMTM67VS");
        map.put("body", "11111");
        map.put("out_trade_no", "1266319201201612091141281773");
        map.put("total_fee", "11");
        map.put("spbill_create_ip", "192.168.0.160");
        map.put("notify_url", "http://jy.jnoo.com/notifywxapp.php");
        map.put("trade_type", "APP");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    String results = HttpUtil.get("https://testapi.xmcrtech.com:6677/Notes/Location/CN-FJ-XM-LFXTD/?format=json");
//                    String results = Util.httpPost("https://api.mch.weixin.qq.com/pay/unifiedorder",map);
//                    Log.e("ceshi",""+results);
                }catch (Exception e){
                }
            }
        }).start();



    }
}
