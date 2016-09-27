package com.example.aaaaa.mvp_demos;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mvp.personal.BasePresenter;
import com.example.mvp.personal.Personal;
import com.example.mvp.personal.PersonalPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements BasePresenter.PersonalView {

//    private PersonalPresenter personalPresenter;
    private BasePresenter.TaskPresenter personalPresenter;
    private ListView mlsitview;
    private Adaperter adaperter;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mlsitview = (ListView) findViewById(R.id.listview);
        personalPresenter=new PersonalPresenter(this);
        adaperter = new Adaperter(personalPresenter.getlistPersonal());
        mlsitview.setAdapter(adaperter);
        dialog = new ProgressDialog(this);
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personalPresenter.addPersonal();
            }
        });
        findViewById(R.id.btn_del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personalPresenter.removePersonal(0);
            }
        });
    }


    @Override
    public void changlistdata() {
        adaperter.notifyDataSetChanged();
    }

    @Override
    public void DialogShow() {
        if (dialog != null) {
            dialog.show();
        }
    }

    @Override
    public void Dialogdiss() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override
    public void setpresenter(BasePresenter.TaskPresenter presenter) {
        if (presenter !=null){
            this.personalPresenter=presenter;
        }
    }

    private class Adaperter extends BaseAdapter {
        List<Personal> list;

        public Adaperter(List<Personal> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
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
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate = getLayoutInflater().inflate(R.layout.item, null);
            TextView textView = (TextView) inflate.findViewById(R.id.textView);
            textView.setText(list.get(position).getName());
            return inflate;
        }
    }
}
