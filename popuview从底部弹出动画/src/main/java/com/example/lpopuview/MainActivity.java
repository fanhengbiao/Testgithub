package com.example.lpopuview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;

public class MainActivity extends Activity {

    @butterknife.InjectView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butterknife.ButterKnife.inject(this);
    }

    @butterknife.OnClick(R.id.button)
    public void onClick() {
        SelectPicPopupWindow picPopupWindow = new SelectPicPopupWindow(this, null);
        picPopupWindow.showAtLocation(MainActivity.this.findViewById(R.id.button), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0); //设置layout在PopupWindow中显示的位置
    }
}
