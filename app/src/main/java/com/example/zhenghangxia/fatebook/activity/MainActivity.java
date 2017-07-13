package com.example.zhenghangxia.fatebook.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.activity.base.BaseActivity;
import com.example.zhenghangxia.fatebook.fragment.AccountFragment;
import com.example.zhenghangxia.fatebook.fragment.LifeFragment;
import com.example.zhenghangxia.fatebook.fragment.NewsFragment;
import com.example.zhenghangxia.fatebook.fragment.PlanFragment;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    private BottomNavigationBar mBottomNavigationBar;
    private FragmentTransaction mTransaction;
    private PlanFragment mPlanFragment;
    private Fragment mCurrentFragment;
    private AccountFragment mAccountFragment;
    private NewsFragment mNewsFragment;
    private LifeFragment mLifeFragment;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        // 底部导航栏
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bnb_main);
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.icon_main,"规划")
                        .setActiveColorResource(R.color.md_blue_400))
                .addItem(new BottomNavigationItem(R.mipmap.icon_work,"记账")
                        .setActiveColorResource(R.color.md_blue_400))
                .addItem(new BottomNavigationItem(R.mipmap.icon_app,"新闻")
                        .setActiveColorResource(R.color.md_blue_400))
                .addItem(new BottomNavigationItem(R.mipmap.icon_mine,"生活")
                        .setActiveColorResource(R.color.md_blue_400))
                .setFirstSelectedPosition(0)
                .initialise();
        // 设置默认页
        mTransaction = getSupportFragmentManager().beginTransaction();
        mPlanFragment = new PlanFragment();
        mTransaction.add(R.id.frame_content,mPlanFragment).commit();
        mCurrentFragment = mPlanFragment;

        // 设置导航监听器
        mBottomNavigationBar.setTabSelectedListener(this);

    }

    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 0:
                if (mPlanFragment == null)
                    mPlanFragment = new PlanFragment();
                switchFragment(mPlanFragment);
                break;

            case 1:
                if (mAccountFragment == null)
                    mAccountFragment = new AccountFragment();
                switchFragment(mAccountFragment);
                break;

            case 2:
                if (mNewsFragment == null)
                    mNewsFragment = new NewsFragment();
                switchFragment(mNewsFragment);
                break;

            case 3:
                if (mLifeFragment == null)
                    mLifeFragment = new LifeFragment();
                switchFragment(mLifeFragment);
                break;

            default:

                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    /**
     * 导航切换
     */
    private void switchFragment(Fragment fragment) {
        if (mCurrentFragment != fragment) {
            mTransaction = getSupportFragmentManager().beginTransaction();
            if (!fragment.isAdded()) {
                mTransaction.hide(mCurrentFragment).add(R.id.frame_content, fragment).commit();
            } else {
                mTransaction.hide(mCurrentFragment).show(fragment).commit();
            }
            mCurrentFragment = fragment;
        }
    }

}
