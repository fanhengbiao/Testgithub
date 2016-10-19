package com.example.getpic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements  YImagePicker.OnImagePickedListener{

    private ImageView iv;
    private YImagePicker imagePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.iv);
        imagePicker = new YImagePicker(this,this);
    }

    public void btn(View view) {
        imagePicker.startImagePickFromCamera();
    }
    public void btn_tuk(View view) {
        imagePicker.startImagePickFromPicture();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        imagePicker.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onImagePicked(Bitmap bitmap, int requestCode, Intent data, Uri originalUri, String path) {
        imagePicker.startImageCrop(path);
    }

    @Override
    public void onImageCroped(Bitmap bm) {
        iv.setImageBitmap(bm);
    }

    @Override
    public void onPickFail(Exception e) {

    }
}
