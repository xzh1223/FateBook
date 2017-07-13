package com.example.zhenghangxia.fatebook.fragment;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.adapter.MyViewPagerAdapter;
import com.example.zhenghangxia.fatebook.fragment.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhenghangxia on 17-7-5.
 *
 */

public class NewsFragment extends BaseFragment implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private TextView mNews1;
    private TextView mNews2;
    private TextView mNews3;
    private TextView mNews4;
    private TextView mNews5;
    private ViewPager mViewPager;

    @Override
    protected int getLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView() {

        initToolBarTitle("新闻");
        mNews1 = (TextView) getView().findViewById(R.id.news_1);
        mNews2 = (TextView) getView().findViewById(R.id.news_2);
        mNews3 = (TextView) getView().findViewById(R.id.news_3);
        mNews4 = (TextView) getView().findViewById(R.id.news_4);
        mNews5 = (TextView) getView().findViewById(R.id.news_5);

        mViewPager = (ViewPager) getView().findViewById(R.id.viewPager);

        List<Fragment> fragments=new ArrayList<Fragment>();
        fragments.add(new ChannelFirstFragment());
        fragments.add(new ChannelSecondFragment());
        fragments.add(new ChannelThirdFragment());
        fragments.add(new ChannelForthFragment());
        fragments.add(new ChannelFifthFragment());
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getActivity().getSupportFragmentManager(), fragments);

        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(this);

        mViewPager.setCurrentItem(0);
        savedShared(0);

        mNews1.setOnClickListener(this);
        mNews2.setOnClickListener(this);
        mNews3.setOnClickListener(this);
        mNews4.setOnClickListener(this);
        mNews5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.news_1:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.news_2:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.news_3:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.news_4:
                mViewPager.setCurrentItem(3);
                break;
            case R.id.news_5:
                mViewPager.setCurrentItem(4);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        savedShared(position);

        if (position == 0) {
            mNews1.setTextColor(getResources().getColor(R.color.md_blue_400));
            mNews2.setTextColor(getResources().getColor(R.color.md_grey_400));
            mNews3.setTextColor(getResources().getColor(R.color.md_grey_400));
            mNews4.setTextColor(getResources().getColor(R.color.md_grey_400));
            mNews5.setTextColor(getResources().getColor(R.color.md_grey_400));
        } else if (position == 1) {
            mNews1.setTextColor(getResources().getColor(R.color.md_grey_400));
            mNews2.setTextColor(getResources().getColor(R.color.md_blue_400));
            mNews3.setTextColor(getResources().getColor(R.color.md_grey_400));
            mNews4.setTextColor(getResources().getColor(R.color.md_grey_400));
            mNews5.setTextColor(getResources().getColor(R.color.md_grey_400));
        } else if (position == 2) {
            mNews1.setTextColor(getResources().getColor(R.color.md_grey_400));
            mNews2.setTextColor(getResources().getColor(R.color.md_grey_400));
            mNews3.setTextColor(getResources().getColor(R.color.md_blue_400));
            mNews4.setTextColor(getResources().getColor(R.color.md_grey_400));
            mNews5.setTextColor(getResources().getColor(R.color.md_grey_400));
        } else if (position == 3) {
            mNews1.setTextColor(getResources().getColor(R.color.md_grey_400));
            mNews2.setTextColor(getResources().getColor(R.color.md_grey_400));
            mNews3.setTextColor(getResources().getColor(R.color.md_grey_400));
            mNews4.setTextColor(getResources().getColor(R.color.md_blue_400));
            mNews5.setTextColor(getResources().getColor(R.color.md_grey_400));
        } else if (position == 4) {
            mNews1.setTextColor(getResources().getColor(R.color.md_grey_400));
            mNews2.setTextColor(getResources().getColor(R.color.md_grey_400));
            mNews3.setTextColor(getResources().getColor(R.color.md_grey_400));
            mNews4.setTextColor(getResources().getColor(R.color.md_grey_400));
            mNews5.setTextColor(getResources().getColor(R.color.md_blue_400));
        }
    }

    private void savedShared(int position) {
        SharedPreferences.Editor editor = pref.edit();
        Log.e("shared外部--->",position+1+"");
        editor.putInt("position", position+1);
        editor.commit();
        Log.e("shared内部--->", pref.getInt("position",0)+"");
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
