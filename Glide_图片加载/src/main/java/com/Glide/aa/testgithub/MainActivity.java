package com.Glide.aa.testgithub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Glide.with(this)
                .load("http://g.hiphotos.baidu.com/image/pic/item/0df3d7ca7bcb0a46bc0b4d3d6963f6246b60af8d.jpg")
                .placeholder(R.mipmap.ic_launcher)//还没加载出来默认的图片
                .error(R.mipmap.ic_launcher)//加载失败的图片
                .bitmapTransform(new GlideRoundTransform(this,15))
                .diskCacheStrategy(DiskCacheStrategy.ALL)// 缓存所有版本的图像（默认行为）
                .into(imageView);
        //模糊效果
//        Glide.with(StopPushActivity.this)
//                .load("")
//                .crossFade(1000)
//                .bitmapTransform(new BlurTransformation(this,23,4)) // “23”：设置模糊度(在0.0到25.0之间)，默认”25";"4":图片缩放比例,默认“1”。
//                .into(imageGround);
    }
}
