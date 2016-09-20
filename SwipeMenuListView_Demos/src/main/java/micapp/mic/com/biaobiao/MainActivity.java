package micapp.mic.com.biaobiao;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    SwipeMenuListView mSwipeMenuListView;
    private MySwipeMenuAdapter sMAdpter;
    private Map<Integer,Boolean> map = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i =0;i<100;i++){
            if(i%2==0)
            map.put(i,false);
            else
            map.put(i,true);

        }
        mSwipeMenuListView = (SwipeMenuListView) findViewById(R.id.swipe_menu_listview);
        sMAdpter = new MySwipeMenuAdapter(this,map);
        mSwipeMenuListView.setAdapter(sMAdpter);
        mSwipeMenuListView.setMenuCreator(getMenuItenStyle());
    }
    protected SwipeMenuCreator getMenuItenStyle() {
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                deleteItem.setWidth(ScreenUtil.dip2px(MainActivity.this, 90));
                menu.addMenuItem(deleteItem);
            }
        };
        return creator;
    }

}
