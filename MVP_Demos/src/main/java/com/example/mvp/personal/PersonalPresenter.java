package com.example.mvp.personal;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanhengbiao on 16-9-9.实现类,数据都是在这边操作,数据也在这边统一操作
 */

public class PersonalPresenter implements Presenter.TaskPresenter {
    ArrayList<Personal> personalArrayList=new ArrayList<>();
    Presenter.PersonalView personalView;

    public PersonalPresenter(Presenter.PersonalView personalView) {
        this.personalView = personalView;

    }

    @Override
    public void addPersonal() {
        Personal personal = new Personal("xiaofan", "37");
        personalArrayList.add(personal);
        personalView.DialogShow();
        handler.postDelayed(runnable, 2000);

    }

    @Override
    public void removePersonal(int dex) {
        if (personalArrayList.size()>0){
            personalArrayList.remove(dex);
        }
        //显示对话框 2秒后就关闭,做个假象
        personalView.DialogShow();
        handler.postDelayed(runnable, 2000);
    }

    @Override
    public List<Personal> getlistPersonal() {
        return personalArrayList;
    }

    @Override
    public int getlistSize() {
        return personalArrayList.size();
    }

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //对话框关闭,并刷新列表
            personalView.Dialogdiss();
            personalView.changlistdata();
        }
    };
}
