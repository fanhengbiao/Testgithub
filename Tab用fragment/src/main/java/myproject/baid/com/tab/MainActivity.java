package myproject.baid.com.tab;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;


public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private ImageButton image01;
    private ImageButton image02;
    private Fragment02 fragment02;
    private Fragment01 fragment01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        image01 = (ImageButton) findViewById(R.id.image01);
        image02 = (ImageButton) findViewById(R.id.image02);
        image01.setOnClickListener(this);
        image02.setOnClickListener(this);
        image01.setBackgroundResource(R.mipmap.aa);
        selector(0);


    }


    @Override
    public void onClick(View v) {
        resetImage();
        switch (v.getId()) {
            case R.id.image01:
                selector(0);
                break;
            case R.id.image02:
                selector(1);
                break;
        }
    }

    private void selector(int image) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);
        switch (image) {
            case 0:
                if (fragment01 == null) {
                    fragment01 = new Fragment01();
                    transaction.add(R.id.contonfragment, fragment01);
                } else {
                    transaction.show(fragment01);
                }
                image01.setBackgroundResource(R.mipmap.aa);
                break;
            case 1:

                if (fragment02 == null) {
                    fragment02 = new Fragment02();
                    transaction.add(R.id.contonfragment, fragment02);
                } else {
                    transaction.show(fragment02);
                }
                image02.setBackgroundResource(R.mipmap.aa);
                break;
        }
        transaction.commit();

    }

    private void hideFragment(FragmentTransaction transaction) {
        if (fragment01 != null) {
            transaction.hide(fragment01);
        }
        if (fragment02 != null) {
            transaction.hide(fragment02);
        }
    }

    private void resetImage() {
        image01.setBackgroundResource(R.mipmap.ic_launcher);
        image02.setBackgroundResource(R.mipmap.ic_launcher);
    }
}
