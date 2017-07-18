package com.example.zhenghangxia.fatebook.activity;

import android.widget.ImageButton;

import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.activity.base.BaseActivity;

/**
 * Created by zhenghangxia on 17-7-14.
 *
 *
 */

public class WritePlanActivity extends BaseActivity {
    @Override
    protected int getLayout() {
        return R.layout.activity_write_plan;
    }

    @Override
    protected void initView() {
        initToolBar();
        ImageButton imageButton = (ImageButton) findViewById(R.id.ib_add);
        imageButton.setImageDrawable(getResources().getDrawable(R.mipmap.icon_submit));
    }
}
