package com.example.huoq.ringtom;

import android.database.Cursor;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<RingtoneInfo> ringtoneList = getRingtoneList(1);
        findViewById(R.id.btn_h).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog_ring dialog_ring=new Dialog_ring(MainActivity.this,ringtoneList);
                dialog_ring.show();

            }
        });
    }
    public List<RingtoneInfo> getRingtoneList(int type){

        List<RingtoneInfo> resArr = new ArrayList<RingtoneInfo>();

        RingtoneManager manager = new RingtoneManager(this);

        manager.setType(type);

        Cursor cursor = manager.getCursor();

        int count = cursor.getCount();

        for(int i = 0 ; i < count ; i ++){
            RingtoneInfo info=new RingtoneInfo();
            info.setRingUrl(manager.getRingtoneUri(i)+"");
            info.setTitle(manager.getRingtone(i).getTitle(this));
            if (i==0){
                info.setClick(true);
            }else {
                info.setClick(false);
            }
            resArr.add(info);

        }
        return resArr;

    }
}
