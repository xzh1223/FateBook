package com.example.zhenghangxia.fatebook.fragment;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhenghangxia on 17-7-5.
 */

public class AccountFragment extends BaseFragment {
    private ListView mListView;
    private List<String> mList = new ArrayList<>();

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


    }

    private void initData() {

        for (int i = 0; i < 8; i++) {
            mList.add("支出" + (i * 8));
        }

        mListView.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,mList));

    }
}
