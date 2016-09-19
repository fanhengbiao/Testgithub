package com.example.aaaaa.mvp_demos;

import java.util.List;

/**
 * Created by fanhengbiao on 16-9-9.
 */

public interface TaskPresenter {
    void addPersonal();
    void removePersonal(int dex);
    List<Personal> getlistPersonal();
    int getlistSize();
}
