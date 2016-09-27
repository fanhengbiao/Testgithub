package com.example.mvp.personal;

import com.example.MVP.base.BaseView;

import java.util.List;

/**
 * Created by fanhengbiao on 16-9-26.
 */

public class BasePresenter {
    public interface PersonalView extends BaseView<TaskPresenter>{
        void changlistdata();

        void DialogShow();

        void Dialogdiss();
    }

    public interface TaskPresenter {
        void addPersonal();

        void removePersonal(int dex);

        List<Personal> getlistPersonal();

        int getlistSize();
    }
}
