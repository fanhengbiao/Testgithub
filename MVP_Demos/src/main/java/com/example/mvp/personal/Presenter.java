package com.example.mvp.personal;

import java.util.List;

/**
 * Created by fanhengbiao on 16-9-26.
 */

public class Presenter {
    public interface PersonalView {
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
