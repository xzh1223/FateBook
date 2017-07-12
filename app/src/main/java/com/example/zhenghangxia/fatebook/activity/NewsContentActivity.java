package com.example.zhenghangxia.fatebook.activity;

import android.widget.TextView;

import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.base.BaseActivity;
import com.zzhoujay.richtext.RichText;

public class NewsContentActivity extends BaseActivity {

    private TextView mTitle;
    private TextView mTime;
    private TextView mContent;
    private String time;
    private String content;
    private String title;

    @Override
    protected int getLayout() {
        return R.layout.activity_news_content;
    }

    @Override
    protected void initView() {

        initToolBar();

        mTitle = (TextView) findViewById(R.id.tv_news_title);
        mTime = (TextView) findViewById(R.id.tv_news_time);
        mContent = (TextView) findViewById(R.id.tv_news_content);

        initData();

        setView();
    }

    private void setView() {

        mTitle.setText(title);
        mTime.setText(time);
        // 使用富文本解析器显示数据
        RichText.from(content).into(mContent);
    }

    private void initData() {

        time = getIntent().getStringExtra("time");
        content = getIntent().getStringExtra("content");
        title = getIntent().getStringExtra("title");

    }
}
