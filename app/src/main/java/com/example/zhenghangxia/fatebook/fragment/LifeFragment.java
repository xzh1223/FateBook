package com.example.zhenghangxia.fatebook.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.activity.LifeContentActivity;
import com.example.zhenghangxia.fatebook.fragment.base.BaseFragment;
import com.example.zhenghangxia.fatebook.utils.ToastUtil;

/**
 * Created by zhenghangxia on 17-7-5.
 *
 *  生活页面
 *
 */

public class LifeFragment extends BaseFragment implements View.OnClickListener {

    @Override
    protected int getLayout() {
        return R.layout.fragment_life;
    }

    @Override
    protected void initView() {
        if (getView() != null) {
            RelativeLayout mRLBook = (RelativeLayout) getView().findViewById(R.id.rl_life_recommend_book);
            RelativeLayout mRLStyle = (RelativeLayout) getView().findViewById(R.id.rl_life_recommend_style);
            RelativeLayout mRLView = (RelativeLayout) getView().findViewById(R.id.rl_life_recommend_view);
            RelativeLayout mRLRobot = (RelativeLayout) getView().findViewById(R.id.rl_life_recommend_robot);
            RelativeLayout mRLLaugh = (RelativeLayout) getView().findViewById(R.id.rl_life_recommend_laugh);
            RelativeLayout mRLCookbook = (RelativeLayout) getView().findViewById(R.id.rl_life_recommend_cookbook);
            RelativeLayout mRLPosition = (RelativeLayout) getView().findViewById(R.id.rl_life_recommend_position);
            RelativeLayout mRLMessage = (RelativeLayout) getView().findViewById(R.id.rl_life_recommend_message);

            TextView mTVTime = (TextView) getView().findViewById(R.id.tv_file_time);
            TextView mTVBookName = (TextView) getView().findViewById(R.id.tv_book_name);
            TextView mTVStyleName = (TextView) getView().findViewById(R.id.tv_style_name);
            TextView mTVViewName = (TextView) getView().findViewById(R.id.tv_view_name);
            mTVTime.setText(2 + "天");
            mTVBookName.setText("解忧杂...");
            mTVStyleName.setText("渴望...");
            mTVViewName.setText("虎丘山...");

            mRLBook.setOnClickListener(this);
            mRLStyle.setOnClickListener(this);
            mRLView.setOnClickListener(this);
            mRLRobot.setOnClickListener(this);
            mRLLaugh.setOnClickListener(this);
            mRLCookbook.setOnClickListener(this);
            mRLPosition.setOnClickListener(this);
            mRLMessage.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), LifeContentActivity.class);
        switch (v.getId()) {
            case R.id.rl_life_recommend_book:
                intent.putExtra("flag", "book");
                startActivity(intent);
                break;
            case R.id.rl_life_recommend_style:
                intent.putExtra("flag", "style");
                startActivity(intent);
                break;
            case R.id.rl_life_recommend_view:
                intent.putExtra("flag", "view");
                startActivity(intent);
                break;
            case R.id.rl_life_recommend_robot:
                ToastUtil.toast(getActivity(), "Android6.0以上权限问题未解决，请耐心等待");
                break;
            case R.id.rl_life_recommend_laugh:
                intent.putExtra("flag", "laugh");
                startActivity(intent);
                break;
            case R.id.rl_life_recommend_cookbook:
                intent.putExtra("flag", "cookbook");
                startActivity(intent);
                break;
            case R.id.rl_life_recommend_position:
                ToastUtil.toast(getContext(), "暂无功能");
                break;
            case R.id.rl_life_recommend_message:
                ToastUtil.toast(getContext(), "暂无功能");
                break;
            default:
                break;
        }
    }
}