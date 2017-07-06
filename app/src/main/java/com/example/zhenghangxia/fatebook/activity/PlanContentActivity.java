package com.example.zhenghangxia.fatebook.activity;

import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.base.BaseActivity;
import com.example.zhenghangxia.fatebook.utils.ToastUtil;
import com.zzhoujay.richtext.RichText;

/**
 * Created by zhenghangxia on 17-7-6.
 *
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

    @Override
    protected int getLayout() {
        return R.layout.activity_plan_content;
    }

    @Override
    protected void initView() {

        initToolBar();

        mAdd = (ImageButton) findViewById(R.id.ib_add);
        mTime = (TextView) findViewById(R.id.tv_plan_time);
        mContent = (TextView) findViewById(R.id.tv_plan_content);
        mThink = (TextView) findViewById(R.id.tv_plan_think);
        mRatingBar = (RatingBar) findViewById(R.id.ratingBar);

        initData();
        setView();
        setListener();
    }

    private void setListener() {

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.toast(PlanContentActivity.this,"暂无效果");
            }
        });

    }

    private void setView() {

        mTime.setText(time);

        // 使用富文本解析器显示数据
        RichText.from(content).into(mContent);
        RichText.from("东野圭吾写过很多揭露人性丑恶的推理小说，但是同时也彰显人性的善意。" +
                "《解忧杂货店》中，浪矢爷爷几乎就是东野的化身。东野圭吾收到的咨询信，" +
                "不一定真的有时间一封一封回复，但是他通过小说回答了很多问题，比如浪矢爷爷说：“" +
                "这么多年咨询信看下来，逐渐明白，很多时候，咨询的人心里已经有了答案，" +
                "来咨询只是想确认自己的决定是对的。”浪矢爷爷总是很认真地回复别人的问题，哪怕是恶作剧。" +
                "他说：“我不但要写回信，而且要好好思考再写。人的心声是绝对不能无视的。”临死之前，" +
                "他收到了很多感谢信，他很谦虚地说：“像我这样的糟老头子，怎么可能有左右别人的力量？" +
                "如果说我的回答起了作用，是因为他们自己很努力。如果自己不想积极认真地生活，" +
                "不管得到什么样的回答都没用。”").into(mThink);

//        mContent.setText(content);
       /* mThink.setText("东野圭吾写过很多揭露人性丑恶的推理小说，但是同时也彰显人性的善意。" +
                "《解忧杂货店》中，浪矢爷爷几乎就是东野的化身。东野圭吾收到的咨询信，" +
                "不一定真的有时间一封一封回复，但是他通过小说回答了很多问题，比如浪矢爷爷说：“" +
                "这么多年咨询信看下来，逐渐明白，很多时候，咨询的人心里已经有了答案，" +
                "来咨询只是想确认自己的决定是对的。”浪矢爷爷总是很认真地回复别人的问题，哪怕是恶作剧。" +
                "他说：“我不但要写回信，而且要好好思考再写。人的心声是绝对不能无视的。”临死之前，" +
                "他收到了很多感谢信，他很谦虚地说：“像我这样的糟老头子，怎么可能有左右别人的力量？" +
                "如果说我的回答起了作用，是因为他们自己很努力。如果自己不想积极认真地生活，" +
                "不管得到什么样的回答都没用。”");*/
        mRatingBar.setRating(star);
    }

    private void initData() {

        time = getIntent().getStringExtra("time");
        content = getIntent().getStringExtra("content");
        star = getIntent().getFloatExtra("star", 0);

    }

}
