package com.example.zhenghangxia.fatebook.fragment;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.adapter.AccountAdapter;
import com.example.zhenghangxia.fatebook.bean.AccountBean;
import com.example.zhenghangxia.fatebook.fragment.base.BaseFragment;
import com.example.zhenghangxia.fatebook.utils.DateAndTimeUtil;

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
    private Spinner mSpinner;
    private TextView mTVYear;

    @Override
    protected int getLayout() {
        return R.layout.fragment_account;
    }

    @Override
    protected void initView() {
        initToolBarTitle(getResources().getString(R.string.main_nav_account));

        ImageButton mIBAdd = (ImageButton) getView().findViewById(R.id.ib_add);
        mIBAdd.setImageDrawable(getResources().getDrawable(R.mipmap.icon_add));

        mListView = (ListView) getView().findViewById(R.id.lv_account_list);
        // 添加头布局
        mListView.addHeaderView(View.inflate(getActivity(), R.layout.header_list_account, null));
        // 添加尾布局
        mListView.addFooterView(View.inflate(getActivity(), R.layout.footer_list, null));

        mTVYear = (TextView) getView().findViewById(R.id.tv_year);
        mTVYear.setText(DateAndTimeUtil.year + " 年");
        mSpinner = (Spinner) getView().findViewById(R.id.spinner);
        mSpinner.setSelection(DateAndTimeUtil.month);

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
