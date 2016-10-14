package com.https.aa.testgithub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String results = HttpUtil.get("https://testapi.xmcrtech.com:6677/Notes/Location/CN-FJ-XM-LFXTD/?format=json");
                    Log.e("ceshi",""+results);
                }catch (Exception e){
                }
            }
        }).start();



    }
}
