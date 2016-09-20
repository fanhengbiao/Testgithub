package com.android.main;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.slideandDrg.Menu;
import com.android.slideandDrg.MenuItem;
import com.android.slideandDrg.R;
import com.android.slideandDrg.SlideAndDragListView;

import java.util.ArrayList;

import static com.android.slideandDrg.R.id.textView;

/**
 * 拖拽,左滑菜单的listivw
 * 需要注意的是,listview的适配器要做复用
 */
public class MainActivity extends AppCompatActivity implements SlideAndDragListView.OnListItemLongClickListener,
        SlideAndDragListView.OnDragListener, SlideAndDragListView.OnSlideListener,
        SlideAndDragListView.OnListItemClickListener, SlideAndDragListView.OnMenuItemClickListener {
    ArrayList<String> list = new ArrayList<>();
    private Menu mMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 50; i++) {
            list.add("list" + i);
        }
        initMenu();
        SlideAndDragListView SlideAndDragListView = (SlideAndDragListView) findViewById(R.id.draglistview);
        SlideAndDragListView.setMenu(mMenu);
        adapter adapter = new adapter();
        SlideAndDragListView.setAdapter(adapter);
        SlideAndDragListView.setOnListItemLongClickListener(this);
        SlideAndDragListView.setOnDragListener(MainActivity.this, list);
        SlideAndDragListView.setOnListItemClickListener(this);
        SlideAndDragListView.setOnSlideListener(this);
        SlideAndDragListView.setOnMenuItemClickListener(this);
        SlideAndDragListView.setlongendrag(true);

    }

    /**
     * 创建菜单项
     */
    private void initMenu() {
        mMenu =new Menu((int) getResources().getDimension(R.dimen.slv_item_bg_btn_width), new ColorDrawable(Color.WHITE), true);
        MenuItem menuItemDel = new MenuItem.Builder().setWidth((int) getResources().getDimension(R.dimen.slv_item_bg_btn_width_img))
                .setBackground(new ColorDrawable(Color.RED))
                .setDirection(MenuItem.DIRECTION_RIGHT)
                .setIcon(getResources().getDrawable(R.drawable.locationsettings_delcustomers))
                .setTextSize(15)
                .build();
        mMenu.addItem(menuItemDel);


    }

    /**
     * listview长按事件
     *
     * @param view
     * @param position
     */
    @Override
    public void onListItemLongClick(View view, int position) {
        LogUtil.printD("onListItemLongClick", "" + position);
    }

    /*
    listview点击事件
    * */
    @Override
    public void onListItemClick(View v, int position) {
        LogUtil.printD("onListItemClick", "" + position);

    }

    @Override
    public void onSlideOpen(View view, View parentView, int position, int direction) {
        LogUtil.printD("onSlideOpen", "" + position);
    }

    @Override
    public void onSlideClose(View view, View parentView, int position, int direction) {
        LogUtil.printD("onSlideClose", "" + position);
    }

    /**
     * 菜单的点击事件
     *
     * @param v
     * @param itemPosition   第几个item
     * @param buttonPosition 第几个button
     * @param direction      方向
     * @return
     */
    @Override
    public boolean onMenuItemClick(View v, int itemPosition, int buttonPosition, int direction) {
        switch (direction) {
            case MenuItem.DIRECTION_RIGHT:
                switch (buttonPosition) {
                    case 1:
                        return true;
                    case 0:

                        return true;
                }
        }

        return false;
    }

    /**
     * 拖拽开始
     *
     * @param position
     */
    @Override
    public void onDragViewStart(int position) {
        LogUtil.printD("onDragViewStart", "" + position);
    }

    /**
     * 拖拽中
     *
     * @param position
     */
    @Override
    public void onDragViewMoving(int position) {
        LogUtil.printD("onDragViewMoving", "" + position);
    }

    /**
     * 拖拽结束
     *
     * @param position
     */
    @Override
    public void onDragViewDown(int position) {
        LogUtil.printD("onDragViewDown", "" + position);
    }


    private class adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            HoldView holdView=null;
            if (convertView==null){
                 holdView=new HoldView();
                 convertView = getLayoutInflater().inflate(R.layout.item, null);
                holdView. textView = (TextView) convertView.findViewById(textView);
                convertView.setTag(holdView);
            }else {
                 holdView = (HoldView) convertView.getTag();
            }
            holdView.textView.setText(list.get(position));
            return convertView;
        }
        class  HoldView {
            TextView textView;
        }
    }
}
