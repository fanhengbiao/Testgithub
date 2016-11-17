package com.example.huoq.ringtom;

import android.app.AlertDialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import static android.media.AudioManager.STREAM_RING;

/**
 * Created by fanhengbiao on 16-11-17.
 */

public class Dialog_ring extends AlertDialog{
    List<RingtoneInfo> ringtoneInfoList;
    Context context;
    private  MediaPlayer mRingerPlayer;

    public Dialog_ring(Context context, List<RingtoneInfo> ringtoneInfoList) {
        super(context);
        this.context=context;
        this.ringtoneInfoList=ringtoneInfoList;
        //生成对象不能放在getview 不然会生成太多对象,
        mRingerPlayer = new MediaPlayer();
        mRingerPlayer.setAudioStreamType(STREAM_RING);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //dialog退出时需要把播放器对象停止或者释放资源
        mRingerPlayer.stop();
        mRingerPlayer.release();
        mRingerPlayer=null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog);
        ListView Mlistview = (ListView) findViewById(R.id.listvew);
        Mlistview.setAdapter(new BaseAdater(context));
        findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private class BaseAdater extends BaseAdapter{
        Context context;
        public BaseAdater(Context context){
            this.context=context;
        }

        @Override
        public int getCount() {
            return ringtoneInfoList.size();
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
        public View getView(final int position, View convertView, ViewGroup parent) {
            View inflate = getLayoutInflater().inflate(R.layout.layout, null);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_title);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.image_position);
            textView.setText(ringtoneInfoList.get(position).getTitle());
            if (ringtoneInfoList.get(position).isClick()){
                imageView.setVisibility(View.VISIBLE);
            }else {
                imageView.setVisibility(View.GONE);
            }

            inflate.findViewById(R.id.layout).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //这里主要是为了,点击变换
                    for (RingtoneInfo info:ringtoneInfoList){
                        info.setClick(false);
                    }
                    ringtoneInfoList.get(position).setClick(true);
                    notifyDataSetChanged();
                    try {
                            ringtoneInfoList.get(position).setClick(true);
                            mRingerPlayer.reset();
                            mRingerPlayer.setDataSource(
                                    context, Uri.parse(ringtoneInfoList.get(position).getRingUrl()));
                            mRingerPlayer.prepare();
                            mRingerPlayer.start();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }
            });
            return inflate;
        }
    }
}
