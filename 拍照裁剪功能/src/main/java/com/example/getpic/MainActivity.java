package com.example.getpic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONObject;

import java.io.File;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity implements YImagePicker.OnImagePickedListener {

    private ImageView iv;
    private YImagePicker imagePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.iv);
        imagePicker = new YImagePicker(this, this);
    }

    public void btn(View view) {
        imagePicker.startImagePickFromCamera();
    }

    public void btn_tuk(View view) {
        imagePicker.startImagePickFromPicture();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        imagePicker.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onImagePicked(Bitmap bitmap, int requestCode, Intent data, Uri originalUri, String path) {
        Log.d("onImagePicked", new File(path) + ".." + originalUri);
        imagePicker.startImageCrop(path);
        final HashMap<String, String> map = new HashMap<>();
        map.put("Token", "aa082d7c-3078-45b4-8af0-24dedf38ddc1");
        map.put("UserId", "aa082d7c-3078-45b4-8af0-24dedf38ddc1");
        final HashMap<String, String> headMap = new HashMap<>();
        headMap.put("x-username", "15880268606");
        headMap.put("x-password", "12345678");
        headMap.put("Content-Type", "multiparty/form-data");
        headMap.put("X-INTERCOM-CKEY", "11e244c40789448ca66d6293ff1fe78a");
        OkHttpClient client=new OkHttpClient().newBuilder().sslSocketFactory(CreateSSLsO()).hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        }).build();

        AndroidNetworking.upload("https://testapi.xmcrtech.com/user/image?format=json")
                .addMultipartFile("", new File(path))
                .addQueryParameter(map)
                .addHeaders(headMap)
                .setOkHttpClient(client)
                .setPriority(Priority.IMMEDIATE)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("成功", response.toString());
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("失败", anError.toString());
                    }
                });
    }

    @Override
    public void onImageCroped(Bitmap bm) {
        iv.setImageBitmap(bm);
    }

    @Override
    public void onPickFail(Exception e) {

    }
    private static SSLSocketFactory CreateSSLsO(){
          SSLSocketFactory socketFactory=null;
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            try {
                sc.init(null,new TrustManager[]{new TrustAllManageer()},new SecureRandom());
                socketFactory = sc.getSocketFactory();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return socketFactory;
    }
    private static class TrustAllManageer implements X509TrustManager{

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
}
