package com.example.zhenghangxia.fatebook.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.activity.base.BaseActivity;
import com.example.zhenghangxia.fatebook.utils.ToastUtil;
import com.zzhoujay.richtext.RichText;

import static com.example.zhenghangxia.fatebook.R.id.ratingBar;

/**
 * Created by zhenghangxia on 17-7-6.
 *
 *      规划内容
 */
public class PlanContentActivity extends BaseActivity {
    private TextView mTime;
    private TextView mContent;
    private TextView mThink;
    private RatingBar mRatingBar;
    private String time;
    private String content;
    private float star;
    private ImageButton mAdd;
    private EditText mETThink;
    boolean flag = true;
    private String think;
    private String remark;
    private TextView mRemark;

    @Override
    protected int getLayout() {
        return R.layout.activity_plan_content;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initView() {

        initToolBar();

        mAdd = (ImageButton) findViewById(R.id.ib_add);
        mAdd.setImageDrawable(getDrawable(R.mipmap.icon_add));
        mRemark = (TextView) findViewById(R.id.tv_plan_remark);
        mTime = (TextView) findViewById(R.id.tv_plan_time);
        mContent = (TextView) findViewById(R.id.tv_plan_content);
        mThink = (TextView) findViewById(R.id.tv_plan_think);
        mETThink = (EditText) findViewById(R.id.et_plan_think);
        mRatingBar = (RatingBar) findViewById(ratingBar);

        initData();
        setView();
        setListener();
    }

    /**
     *  设置监听事件
     */
    private void setListener() {

        mAdd.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (flag) {
                    mAdd.setImageDrawable(getDrawable(R.mipmap.icon_ok));
                    mThink.setVisibility(View.GONE);
                    mETThink.setVisibility(View.VISIBLE);
                    flag = false;
                    mRatingBar.setIsIndicator(flag);
                } else {
                    mAdd.setImageDrawable(getDrawable(R.mipmap.icon_add));
                    mETThink.setVisibility(View.GONE);
                    mThink.setVisibility(View.VISIBLE);
                    flag = true;
                    mRatingBar.setIsIndicator(flag);
                }

            }
        });

        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ToastUtil.toast(PlanContentActivity.this, rating+"");
            }
        });

    }

    /**
     *  设置数据显示
     */
    private void setView() {

        mTime.setText(time);
        mRemark.setText(remark);
        // 使用富文本解析器显示数据
        RichText.from(content).into(mContent);
        if (think == null ||think.equals("")) {

        }else {
            RichText.from(think).into(mThink);
        }
        mRatingBar.setRating(star);
        mRatingBar.setIsIndicator(true);
    }






    /**
     *  初始化数据
     */
    private void initData() {
        remark = getIntent().getStringExtra("remark");
        time = getIntent().getStringExtra("time");
        content = getIntent().getStringExtra("content");
        star = getIntent().getFloatExtra("star", 0);
        think = getIntent().getStringExtra("think");

    }

}
