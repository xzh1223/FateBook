package com.example.zhenghangxia.fatebook.fragment;

import android.view.View;
import android.widget.ListView;

import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.adapter.AccountAdapter;
import com.example.zhenghangxia.fatebook.fragment.base.BaseFragment;
import com.example.zhenghangxia.fatebook.bean.AccountBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhenghangxia on 17-7-5.
 *
 *  记账界面
 *
 */

public class AccountFragment extends BaseFragment {
    private ListView mListView;
    private List<AccountBean> mList = new ArrayList<>();

    @Override
    protected int getLayout() {
        return R.layout.fragment_account;
    }

    @Override
    protected void initView() {
        initToolBarTitle("记账");

        mListView = (ListView) getView().findViewById(R.id.lv_account_list);
        // 添加头布局
        mListView.addHeaderView(View.inflate(getActivity(), R.layout.header_list_account, null));
        // 添加尾布局
        mListView.addFooterView(View.inflate(getActivity(), R.layout.footer_list, null));

        initData();
        initListView();

    }

    /**
     *  初始化 ListView
     */
    private void initListView() {

        AccountAdapter adapter = new AccountAdapter(getActivity(), mList);

        mListView.setAdapter(adapter);

    }

    /**
     *  初始化数据
     */
    private void initData() {

        for (int i = 0; i < 16; i++) {
            AccountBean bean = new AccountBean();
            bean.setTime("2017-07-12 17:16:00");
            bean.setImgSrc(R.mipmap.icon_food);
            bean.setNumber(-12);
            bean.setTypeContent("午餐");
            mList.add(bean);
        }

    }
}
