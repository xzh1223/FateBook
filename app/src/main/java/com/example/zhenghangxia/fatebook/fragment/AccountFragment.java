package com.example.zhenghangxia.fatebook.fragment;

import android.content.Intent;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.activity.AddBillActivity;
import com.example.zhenghangxia.fatebook.adapter.AccountAdapter;
import com.example.zhenghangxia.fatebook.bean.AccountBean;
import com.example.zhenghangxia.fatebook.dbmanager.DBManager;
import com.example.zhenghangxia.fatebook.dialog.MyDatePickerDialog;
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

public class AccountFragment extends BaseFragment implements View.OnClickListener {
    private ListView mListView;
    private List<AccountBean> mList = new ArrayList<>();
    private TextView mTVYear;
    private AccountAdapter mAdapter;
    private TextView mTVMonth;
    private MyDatePickerDialog myDatePickerDialog;
    private int mMonth;
    private int mYear;
    private double mPayTotalMoney = 0;
    private double mIncomeTotalMoney = 0;
    private TextView mTVPayNum;
    private TextView mTVIncomeNum;

    @Override
    protected int getLayout() {
        return R.layout.fragment_account;
    }

    @Override
    protected void initView() {
        if (getView() != null) {

            initToolBarTitle(getResources().getString(R.string.main_nav_account));

            ImageButton mIBAdd = (ImageButton) getView().findViewById(R.id.ib_add);

            mListView = (ListView) getView().findViewById(R.id.lv_account_list);

            // 添加头布局
            mListView.addHeaderView(View.inflate(getActivity(), R.layout.header_list_account, null));
            // 添加尾布局
            mListView.addFooterView(View.inflate(getActivity(), R.layout.footer_list, null));

            LinearLayout mLLTime = (LinearLayout) getView().findViewById(R.id.ll_time);
            mTVYear = (TextView) getView().findViewById(R.id.tv_year);
            mTVMonth = (TextView) getView().findViewById(R.id.tv_month);
            mTVPayNum = (TextView) getView().findViewById(R.id.tv_pay_num);
            mTVIncomeNum = (TextView) getView().findViewById(R.id.tv_income_num);

            // 设置标题栏图标
            mIBAdd.setImageDrawable(getResources().getDrawable(R.mipmap.icon_add));
            // 设置页面显示日期
            mTVYear.setText(DateAndTimeUtil.getYear() + " 年");
            mTVMonth.setText(DateAndTimeUtil.getMonth() + " 月");

            mIBAdd.setOnClickListener(this);
            mLLTime.setOnClickListener(this);

            mYear = DateAndTimeUtil.getYear();
            mMonth = DateAndTimeUtil.getMonth();

        }
    }


    /**
     *  初始化数据
     */
    private void initData() {
        // 从数据库中读取数据
        AccountBean bean = new AccountBean();
        bean.setYear(mYear);
        bean.setMonth(mMonth);
        mList = DBManager.queryAccountBeanList(bean);
        mAdapter = new AccountAdapter(getActivity(), mList);
        mListView.setAdapter(mAdapter);

        totalMoney();

    }

    /**
     *  计算月总额
     */
    private void totalMoney() {
        mTVPayNum.setText("0");
        mTVIncomeNum.setText("0");
        for (int i = 0; i < mList.size(); i++) {
            AccountBean accountBean = mList.get(i);
            if ("支出".equals(accountBean.getType())) {
                mPayTotalMoney += Double.parseDouble(accountBean.getNumber());
                mTVPayNum.setText(mPayTotalMoney+"");
            } else if ("收入".equals(accountBean.getType())){
                mIncomeTotalMoney += Double.parseDouble(accountBean.getNumber());
                mTVIncomeNum.setText(mIncomeTotalMoney+"");
            }
        }

        mPayTotalMoney = mIncomeTotalMoney = 0;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ib_add:

                Intent intent = new Intent(getActivity(), AddBillActivity.class);
                startActivity(intent);

                break;
            case R.id.ll_time:

                changeDate();

                break;
        }

    }

    /**
     *  切换时间
     */
    private void changeDate() {

        myDatePickerDialog = new MyDatePickerDialog(getActivity(),
                android.R.style.Theme_Holo_Light_Dialog_NoActionBar,
                new MyDatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view,int year,int monthOfYear,int dayOfMonth){
                        mYear = year;
                        mMonth = monthOfYear+1;
                        mTVYear.setText(year + " 年");
                        mTVMonth.setText((monthOfYear + 1) + "月");
                        initData();
                    }
                }, DateAndTimeUtil.getYear(), DateAndTimeUtil.getMonth(), DateAndTimeUtil.getDay());
        myDatePickerDialog.myShow();

        // 将对话框的大小按屏幕大小的百分比设置
        WindowManager windowManager = getActivity().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = myDatePickerDialog.getWindow().getAttributes();
        lp.width = (int)(display.getWidth() * 0.8); //设置宽度
        myDatePickerDialog.getWindow().setAttributes(lp);

        // 去掉显示日  只显示年月
        ((ViewGroup)((ViewGroup) myDatePickerDialog.getDatePicker()
                .getChildAt(0)).getChildAt(0)).getChildAt(2).setVisibility(View.GONE);

    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

}
