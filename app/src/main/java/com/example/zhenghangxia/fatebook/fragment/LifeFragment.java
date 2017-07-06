package com.example.zhenghangxia.fatebook.fragment;

import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.base.BaseFragment;

/**
 * Created by zhenghangxia on 17-7-5.
 */

public class LifeFragment extends BaseFragment {
    @Override
    protected int getLayout() {
        return R.layout.fragment_life;
    }

    @Override
    protected void initView() {
        initToolBarTitle("生活");
    }
}
