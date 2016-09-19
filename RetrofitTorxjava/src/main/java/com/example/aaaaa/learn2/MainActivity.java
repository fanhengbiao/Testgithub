package com.example.aaaaa.learn2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import serviceUtil.HttpResultSubscriber;
import serviceUtil.PersonService;
import serviceUtil.ServiceFactory;
import serviceUtil.XxEntity;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);


    }

    public void onclick_get(View view) {
        //Get请求
        Get_Retrofit();
    }

    public void onclick_post(View view) {
         //Post请求
        Post_retrofit();
    }

    /**
     *
     */
    private void Post_retrofit() {
//        Retrofit build = new Retrofit.Builder().baseUrl("https://api.bmob.cn/1/classes/Persons/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        PersonService personService = build.create(PersonService.class);
//        Call postPersonal = personService.PostPersonal(person, "application/json",
//                    "610f2f28c712cd7d561b2db8b2682763",
//                    "f38900c935a2a1c78b121ddd1a2ee144");
//            postPersonal.enqueue(new Callback<ResponseBody>() {
//                @Override
//                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                    textView.setText("post_ok---->"+response.body().toString());
//                    Log.e("post_onResponse", "Result=" + response.body().toString());
//                }
//
//                @Override
//                public void onFailure(Call<ResponseBody> call, Throwable t) {
//                    textView.setText("post_failure----->"+t.getMessage());
//                    Log.e("post_onResponse", "Result=" + t.getMessage());
//                }
//            });


    }

    /**
     *
     */
    private void Get_Retrofit() {
//        Retrofit build = new Retrofit.Builder()
//                .baseUrl("https://api.bmob.cn/1/classes/Persons/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//        PersonService personService = build.create(PersonService.class);
        //正常用Retrofit使用
//        Call<XxEntity> personal = personService.getPersonal("application/json",
//                "610f2f28c712cd7d561b2db8b2682763",
//                "f38900c935a2a1c78b121ddd1a2ee144");
//        personal.enqueue(new Callback<XxEntity>() {
//            @Override
//            public void onResponse(Call<XxEntity> call, Response<XxEntity> response) {
//                textView.setText("get_ok--->"+response.body().getResults().size());
//                Log.e("onResponse", "Result=" + response.body().getResults().size());
//            }
//
//            @Override
//            public void onFailure(Call<XxEntity> call, Throwable t) {
//                textView.setText("get_failure---->"+t.getMessage());
//                Log.e("onResponse", "failure=" + t.getMessage());
//            }
//        });
        //跟Rxjava一起使用
//        personService.getPersonal("application/json",
//                "610f2f28c712cd7d561b2db8b2682763",
//                "f38900c935a2a1c78b121ddd1a2ee144").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
//        .subscribe(new Observer<XxEntity>() {
//            @Override
//            public void onCompleted() {
//                Toast.makeText(MainActivity.this,"completed",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                textView.setText("get_failure_rxjava---->"+ e.getMessage());
//            }
//
//            @Override
//            public void onNext(XxEntity xxEntity) {
//                textView.setText("get_ok_rxjava---->"+ xxEntity.getResults().size());
//            }
//        });
        ServiceFactory.getlintence().
                CreatClass(PersonService.class)
        .getPersonal("application/json",
                "610f2f28c712cd7d561b2db8b2682763",
                "f38900c935a2a1c78b121ddd1a2ee144")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
         .subscribe(new HttpResultSubscriber<XxEntity>() {
                    @Override
                    public void _onSuccess(XxEntity xxEntity) {
                        textView.setText("get_ok_rxjava---->"+xxEntity.getResults().size());
                    }

                    @Override
                    public void _Error(Throwable t) {
                        textView.setText("get_failure_rxjava---->"+ t.getMessage());
                    }
                });
    }
}
