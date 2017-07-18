package com.example.zhenghangxia.fatebook.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.activity.AddBillActivity;
import com.example.zhenghangxia.fatebook.adapter.AccountAdapter;
import com.example.zhenghangxia.fatebook.bean.AccountBean;
import com.example.zhenghangxia.fatebook.fragment.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhenghangxia on 17-7-5.
 *
 *  记账界面
 *
 */

public class AccountFragment extends BaseFragment implements View.OnClickListener {
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
        if (getView() != null) {
            initData();

            initToolBarTitle(getResources().getString(R.string.main_nav_account));

            ImageButton mIBAdd = (ImageButton) getView().findViewById(R.id.ib_add);

            mListView = (ListView) getView().findViewById(R.id.lv_account_list);

            mTVYear = (TextView) getView().findViewById(R.id.tv_year);

            mSpinner = (Spinner) getView().findViewById(R.id.spinner);

            // 添加头布局
            mListView.addHeaderView(View.inflate(getActivity(), R.layout.header_list_account, null));
            // 添加尾布局
            mListView.addFooterView(View.inflate(getActivity(), R.layout.footer_list, null));
            // 设置标题栏图标
            mIBAdd.setImageDrawable(getResources().getDrawable(R.mipmap.icon_add));
            // 设置页面显示日期
//            mTVYear.setText(DateAndTimeUtil.getYear() + " 年");
//            mSpinner.setSelection(DateAndTimeUtil.getMonth());

            // 设置ListView 适配器
            AccountAdapter adapter = new AccountAdapter(getActivity(), mList);
            mListView.setAdapter(adapter);

            mIBAdd.setOnClickListener(this);

        }
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

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ib_add:

                Intent intent = new Intent(getActivity(), AddBillActivity.class);
                startActivity(intent);

                break;
        }

    }
}
