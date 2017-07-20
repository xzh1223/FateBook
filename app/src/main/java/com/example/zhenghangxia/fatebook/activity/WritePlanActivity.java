package com.example.zhenghangxia.fatebook.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.activity.base.BaseActivity;
import com.example.zhenghangxia.fatebook.bean.PlanBean;
import com.example.zhenghangxia.fatebook.dbmanager.DBManager;
import com.example.zhenghangxia.fatebook.utils.Constants;
import com.example.zhenghangxia.fatebook.utils.DateAndTimeUtil;
import com.example.zhenghangxia.fatebook.utils.ToastUtil;

/**
 * Created by zhenghangxia on 17-7-14.
 *
 *
 */

public class WritePlanActivity extends BaseActivity implements View.OnClickListener {
    private EditText mETRemark;
    private EditText mETContent;
    private String mType;

    @Override
    protected int getLayout() {
        return R.layout.activity_write_plan;
    }

    @Override
    protected void initView() {

        initData();

        initToolBar();

        ImageButton imageButton = (ImageButton) findViewById(R.id.ib_add);
        imageButton.setImageResource(R.mipmap.icon_submit);

        mETRemark = (EditText) findViewById(R.id.edit_remark);
        mETContent = (EditText) findViewById(R.id.edit_content);

        imageButton.setOnClickListener(this);

    }

    /**
     *  初始化数据
     */
    private void initData() {

        mType = getIntent().getStringExtra(Constants.PLAN_INTENT_MSG);

        /*if (paramString.equals(Constants.PLAN_DAY)) {

        } else if (paramString.equals(Constants.PLAN_WEEK)) {

        } else if (paramString.equals(Constants.PLAN_SUMMARY)) {

        } else if (paramString.equals(Constants.PLAN_ESSAY)) {

        }*/

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_add:

                String remarkString = mETRemark.getText().toString().trim();
                String contentString = mETContent.getText().toString().trim();
                if (remarkString.equals("") || remarkString == null) {
                    remarkString = getString(R.string.plan_details);
                }
                if (contentString.equals("") || contentString == null) {
                    ToastUtil.toast(WritePlanActivity.this, getString(R.string.plan_content_null));
                }

                PlanBean planBean = new PlanBean();
                planBean.setType(mType);
                planBean.setContent(contentString);
                planBean.setRemark(remarkString);
                planBean.setTime(DateAndTimeUtil.getTime());

                boolean result = DBManager.addPlanBean(planBean);
                if (result) {
                    finish();
                } else {
                    ToastUtil.toast(WritePlanActivity.this, getString(R.string.add_failed));
                }

                break;
        }
    }
}
