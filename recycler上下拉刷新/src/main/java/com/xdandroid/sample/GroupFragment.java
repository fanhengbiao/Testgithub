package com.xdandroid.sample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xdandroid.sample.adapter.GroupRVAdapter;
import com.xdandroid.sample.bean.SampleBean;
import com.xdandroid.sample.bean.Title;
import com.xdandroid.simplerecyclerview.Group;
import com.xdandroid.simplerecyclerview.SimpleRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GroupFragment extends Fragment {

    SimpleRecyclerView mRecyclerView;
    GroupRVAdapter mAdapter;
    List<Group<Title, SampleBean>> mGroupList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_group, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = (SimpleRecyclerView) view.findViewById(R.id.recycler_view);
        setupRecyclerView();
        initData();
    }

    void setupRecyclerView() {
        mAdapter = new GroupRVAdapter();
        GridLayoutManager gridLM = new GridLayoutManager(getActivity(), 3);
        gridLM.setSpanSizeLookup(mAdapter.getSpanSizeLookup(3));
        mRecyclerView.setLayoutManager(gridLM);
        mRecyclerView.setAdapter(mAdapter);
    }

    void initData() {
        for (int i = 0; i < 20; i++) {
            Title title = new Title("TopTitle " + i);
            List<SampleBean> sampleBeanList = new ArrayList<>();
            for (int j = 0; j <= i % 5; j++) sampleBeanList.add(new SampleBean(SampleBean.TYPE_TEXT, "unused", "Item " + j, null, 0));
            mGroupList.add(new Group<>(title, sampleBeanList));
        }
        mAdapter.setList(mGroupList);
    }
}
