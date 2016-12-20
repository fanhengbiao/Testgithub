package com.example.butterKnife;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @InjectView(R.id.tv_text)
    TextView tvText;
    @InjectView(R.id.btn_ok)
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);


    }

    @OnClick({R.id.tv_text, R.id.btn_ok})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_text:
                break;
            case R.id.btn_ok:
                break;
        }
    }
}
