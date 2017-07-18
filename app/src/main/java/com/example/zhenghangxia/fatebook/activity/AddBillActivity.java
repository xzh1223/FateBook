package com.example.zhenghangxia.fatebook.activity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.activity.base.BaseActivity;
import com.example.zhenghangxia.fatebook.adapter.AddBillAdapter;
import com.example.zhenghangxia.fatebook.bean.AccountStyleBean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by zhenghangxia on 17-7-18.
 *
 *
 */
public class AddBillActivity extends BaseActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    private TextView mTVTime;
    private TextView mTVStyle;
    private GridView mGVStyle;
    private List<AccountStyleBean> mData;
    private AddBillAdapter mAdapter;
    public int selectorPosition = 0;
    private EditText mETMoney;
    private EditText mETRemark;

    @Override
    protected int getLayout() {
        return R.layout.activity_add_bill;
    }

    @Override
    protected void initView() {

        initData();

        initToolBar();

        ImageButton mIBAdd = (ImageButton) findViewById(R.id.ib_add);
        TextView mTVTitle = (TextView) findViewById(R.id.tv_header_title);
        mTVTime = (TextView) findViewById(R.id.tv_time);
        mTVStyle = (TextView) findViewById(R.id.tv_style);
        mGVStyle = (GridView) findViewById(R.id.gv_style);
        mETMoney = (EditText) findViewById(R.id.et_money);
        mETRemark = (EditText) findViewById(R.id.et_remark);

        mIBAdd.setImageDrawable(getResources().getDrawable(R.mipmap.icon_submit));
        mTVTitle.setText(getResources().getString(R.string.add_a_bill));
        mETMoney.setInputType(EditorInfo.TYPE_CLASS_PHONE);

        mAdapter = new AddBillAdapter(this, mData);
        mGVStyle.setAdapter(mAdapter);

        mIBAdd.setOnClickListener(this);
        mGVStyle.setOnItemClickListener(this);
        mTVTime.setOnClickListener(this);
        mTVStyle.setOnClickListener(this);

    }

    private void initData() {

        mData = new ArrayList<>();
        mData.add(new AccountStyleBean(R.mipmap.icon_food, "餐饮"));
        mData.add(new AccountStyleBean(R.mipmap.icon_shopping, "购物"));
        mData.add(new AccountStyleBean(R.mipmap.icon_apparel, "服饰"));
        mData.add(new AccountStyleBean(R.mipmap.icon_traffic, "交通"));
        mData.add(new AccountStyleBean(R.mipmap.icon_social, "社交"));
        mData.add(new AccountStyleBean(R.mipmap.icon_entertainment, "娱乐"));
        mData.add(new AccountStyleBean(R.mipmap.icon_communication, "通讯"));
        mData.add(new AccountStyleBean(R.mipmap.icon_snacks, "零食"));
        mData.add(new AccountStyleBean(R.mipmap.icon_beauty, "美容"));
        mData.add(new AccountStyleBean(R.mipmap.icon_sport, "运动"));
        mData.add(new AccountStyleBean(R.mipmap.icon_travel, "旅行"));
        mData.add(new AccountStyleBean(R.mipmap.icon_books, "书籍"));
        mData.add(new AccountStyleBean(R.mipmap.icon_office, "办公"));
        mData.add(new AccountStyleBean(R.mipmap.icon_housing, "住房"));
        mData.add(new AccountStyleBean(R.mipmap.icon_gift, "礼物"));
        mData.add(new AccountStyleBean(R.mipmap.icon_medical_care, "医疗"));
        mData.add(new AccountStyleBean(R.mipmap.icon_digital, "数码"));

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mAdapter.changeState(position);
        selectorPosition = position;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_add:

                break;
            case R.id.tv_time:

                datePickerDialog();

                break;
            case R.id.tv_style:

                stylePickerDialog();

                break;
        }
    }

    /**
     *  方式选择器
     */
    private void stylePickerDialog() {

        final String[] items = getResources().getStringArray(R.array.style);
        new AlertDialog.Builder(this).setTitle(getResources().getString(R.string.select))
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String s = items[i];
                        mTVStyle.setText(s);
                    }
                }).show();

    }

    /**
     *  日期选择器
     */
    private void datePickerDialog() {

        Calendar c = Calendar.getInstance();
        new DatePickerDialog(AddBillActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                mTVTime.setText((month + 1) + "-" + day);
            }
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH) ).show();

    }



}
