package myproject.baid.com.tab;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;




public class Fragment01 extends Fragment implements View.OnClickListener {

    private Indicator indicator;
    private TextView home_tab;
    private TextView radio_tab;
    private TextView ranking_tab;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList;
    private FragmentPagerAdapter pagerAdapter;
    private View layout_top01;
    private View layout_top02;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_fragment01, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        indicator = (Indicator) inflate.findViewById(R.id.indicator);
        home_tab = (TextView) inflate.findViewById(R.id.home_tab);
        radio_tab = (TextView) inflate.findViewById(R.id.radio_tab);
        ranking_tab = (TextView) inflate.findViewById(R.id.ranking_tab);
        viewPager = (ViewPager) inflate.findViewById(R.id.ViewPager);
        home_tab.setOnClickListener(this);
        radio_tab.setOnClickListener(this);
        ranking_tab.setOnClickListener(this);
        fragmentList = new ArrayList<>();
        fragmentList.add(new Fragment3());
        fragmentList.add(new Fragment4());
        fragmentList.add(new Fragment3());
        layout_top01 = inflate.findViewById(R.id.layout_top_01);
        layout_top02 = inflate.findViewById(R.id.layout_top_02);
        layout_top02.setVisibility(View.GONE);
        pagerAdapter = new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                indicator.scroll(position, positionOffset);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    viewPager.setAdapter(pagerAdapter);


}


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_tab:
                layout_top01.setVisibility(View.VISIBLE);
                layout_top02.setVisibility(View.GONE);
                home_tab.setTextColor(Color.WHITE);
                viewPager.setCurrentItem(0);
                break;
            case R.id.radio_tab:
                layout_top01.setVisibility(View.GONE);
                layout_top02.setVisibility(View.VISIBLE);
                radio_tab.setTextColor(Color.WHITE);
                viewPager.setCurrentItem(1);
                break;
            case R.id.ranking_tab:
                ranking_tab.setTextColor(Color.WHITE);
                viewPager.setCurrentItem(2);
                break;
        }

    }
}
