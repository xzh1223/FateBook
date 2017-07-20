package com.example.zhenghangxia.fatebook.fragment;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.activity.PlanContentActivity;
import com.example.zhenghangxia.fatebook.activity.WritePlanActivity;
import com.example.zhenghangxia.fatebook.adapter.PlanAdapter;
import com.example.zhenghangxia.fatebook.bean.PlanBean;
import com.example.zhenghangxia.fatebook.dbmanager.DBManager;
import com.example.zhenghangxia.fatebook.fragment.base.BaseFragment;
import com.example.zhenghangxia.fatebook.utils.Constants;
import com.example.zhenghangxia.fatebook.utils.ToastUtil;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import static com.example.zhenghangxia.fatebook.utils.Constants.images;
import static com.example.zhenghangxia.fatebook.utils.Constants.tips;

/**
 * Created by zhenghangxia on 17-7-5.
 *
 *  规划页面
 *
 */

public class PlanFragment extends BaseFragment implements AdapterView.OnItemClickListener,
        OnBannerListener, View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    private ListView mListView;
    private Banner mBanner;
    private Handler mHander = new Handler();
    private FloatingActionMenu mFloatMenu;
    private FloatingActionButton mWriteDaily;
    private FloatingActionButton mWriteWeekly;
    private FloatingActionButton mWriteSummary;
    private FloatingActionButton mWriteEssay;
    private List<PlanBean> mList = new ArrayList<>();
    private PlanAdapter mAdapter;
    private List titleList;
    private SwipeRefreshLayout mRefresh;

    @Override
    protected int getLayout() {
        return R.layout.fragment_plan;
    }

    @Override
    protected void initView() {

        if (getView() != null) {
            mRefresh = (SwipeRefreshLayout) getView().findViewById(R.id.srl_plan);

            mListView = (ListView) getView().findViewById(R.id.lv_plan_list);
            // 添加头布局
            mListView.addHeaderView(View.inflate(getActivity(), R.layout.header_list_plan, null));
            // 添加尾布局
            mListView.addFooterView(View.inflate(getActivity(), R.layout.footer_list, null));

            mBanner = (Banner) getView().findViewById(R.id.banner_recent);

            // 悬浮菜单按钮
            mFloatMenu = (FloatingActionMenu) getView().findViewById(R.id.fam_plan);
            mWriteDaily = (FloatingActionButton) getView().findViewById(R.id.write_daily_plan);
            mWriteWeekly = (FloatingActionButton) getView().findViewById(R.id.write_weekly_plan);
            mWriteSummary = (FloatingActionButton) getView().findViewById(R.id.write_summary_plan);
            mWriteEssay = (FloatingActionButton) getView().findViewById(R.id.write_essay_plan);

            // 设置标题栏
            initToolBarTitle(getResources().getString(R.string.main_nav_plan));

            setBannerView();

            setEvents();
        }
    }

    /**
     *  设置 Banner 轮播
     */
    private void setBannerView() {

        // 加载图片和标题内容
        List imageList = new ArrayList();
        titleList = new ArrayList();

        for (int i = 0; i < images.length; i++) {
            imageList.add(images[i]);
            titleList.add(tips[i]);
        }

        // 设置加载器
        mBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });

        // 设置相关属性
        mBanner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);//设置页码与标题
        mBanner.setDelayTime(3000);//设置轮播时间
        mBanner.setImages(imageList);//设置图片源
        mBanner.setBannerTitles(titleList);//设置标题
        mBanner.start();

    }

    /**
     *  模拟加载数据
     */
    protected void initData() {
        loadData();
    }

    /**
     *  设置事件
     */
    private void setEvents() {

        /*mRefresh.setRefreshing(true);

        mRefresh.postDelayed(new Runnable() {
            @Override
            public void run() {
                initData();
                mRefresh.setRefreshing(false);
            }
        },2000);
*/
        mRefresh.setOnRefreshListener(this);

        // 设置点击按钮外部关闭弹出
        mFloatMenu.setClosedOnTouchOutside(true);

        // listView子项点击事件监听器
        mListView.setOnItemClickListener(this);

        // banner点击事件监听器
        mBanner.setOnBannerListener(this);

        mWriteDaily.setOnClickListener(this);
        mWriteWeekly.setOnClickListener(this);
        mWriteSummary.setOnClickListener(this);
        mWriteEssay.setOnClickListener(this);

    }


    /**
     *  模拟加载数据
     */
    private void loadData() {

        /*for (int i = 0; i < 8; i++) {
            PlanBean bean = new PlanBean();
            bean.setTime("2017-07-06 11:16:00 ");
            bean.setContent("   深夜，三名小偷敦也、翔太、幸平正开着偷来的汽车逃跑。途中汽车突然抛锚" +
                    "，无奈下三人只好逃入翔太以前发现的弃屋“浪矢杂货店”里躲避，待到天亮再作打算" +
                    "。三人在店内搜索时，突然有一封信从铁卷门上的邮件投递口被投了进来。三人拆阅信件" +
                    "，发现内容是一个化名“月兔”的女性写来的烦恼咨询信。从店内留下的旧杂志" +
                    "，三人发现这家“浪矢杂货店”因为以前的店主将致函的烦恼咨询信件一一用心解答而闻名。" +
                    "敦也坚持不要理睬，而翔太和幸平则认为这种机会千载难逢，决定给那封咨询信件写回信。");
            bean.setStar(3);
            mList.add(bean);
        }*/

        mList = DBManager.queryPlanBeanList();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        PlanBean planBean = (PlanBean) mAdapter.getItem(position-1);
//        ToastUtil.toast(getActivity(),position + "");
        if (planBean != null) {
            Intent intent = new Intent(getActivity(), PlanContentActivity.class);
            intent.putExtra("time", planBean.getTime());
            intent.putExtra("content", planBean.getContent());
            intent.putExtra("star", planBean.getStar());
            intent.putExtra("remark", planBean.getRemark());
            intent.putExtra("think", planBean.getThink());
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
        }

    }

    @Override
    public void OnBannerClick(int position) {

        switch (position) {
            case 0:
                ToastUtil.toast(getActivity(),titleList.get(0).toString());
                break;
            case 1:
                ToastUtil.toast(getActivity(),titleList.get(1).toString());
                break;
            case 2:
                ToastUtil.toast(getActivity(),titleList.get(2).toString());
                break;
            case 3:
                ToastUtil.toast(getActivity(),titleList.get(3).toString());
                break;
            default:
                break;
        }

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), WritePlanActivity.class);
        switch (v.getId()) {
            case R.id.write_daily_plan:
                intent.putExtra(Constants.PLAN_INTENT_MSG, Constants.PLAN_DAY);
                startActivity(intent);
                break;
            case R.id.write_weekly_plan:
                intent.putExtra(Constants.PLAN_INTENT_MSG, Constants.PLAN_WEEK);
                startActivity(intent);
                break;
            case R.id.write_summary_plan:
                intent.putExtra(Constants.PLAN_INTENT_MSG, Constants.PLAN_SUMMARY);
                startActivity(intent);
                break;
            case R.id.write_essay_plan:
                intent.putExtra(Constants.PLAN_INTENT_MSG, Constants.PLAN_ESSAY);
                startActivity(intent);
                break;
            default:
                break;
        }

    }

    @Override
    public void onRefresh() {

        mRefresh.setRefreshing(true);

        mHander.postDelayed(new Runnable() {
            @Override
            public void run() {
                initData();
                mRefresh.setRefreshing(false);
            }
        },2000);
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
        mAdapter = new PlanAdapter(getActivity(), mList);
        mListView.setAdapter(mAdapter);
    }
}
