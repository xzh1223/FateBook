package com.example.zhenghangxia.fatebook.fragment.base;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.activity.NewsContentActivity;
import com.example.zhenghangxia.fatebook.adapter.NewsAdapter;
import com.example.zhenghangxia.fatebook.bean.NewsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhenghangxia on 17-7-13.
 */

public abstract class NewsBasicFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private ListView mListView;

    @Override
    protected int getLayout() {
        return R.layout.fragment_news_item_list;
    }

    @Override
    protected void initView() {
        mListView = (ListView) getView().findViewById(R.id.lv_news);

        List<NewsBean> mList = new ArrayList<>();

        int num = getNumberTest();

        for (int i = 0; i < 8; i++) {

            NewsBean newsBean = new NewsBean();
            newsBean.setTitle("新闻 " + num + i);
            newsBean.setContent("新闻的内容是这个");
            newsBean.setImgSrc(R.mipmap.heng_1);
            mList.add(newsBean);
        }

        NewsAdapter mAdapter = new NewsAdapter(getActivity(), mList);

        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(this);
    }

    protected abstract int getNumberTest();

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String string = "<DIV><FONT size=3>&nbsp;&nbsp;&nbsp; 6月29日，“苏州市光电缆业商会一届十次理事会（扩大）会议暨苏州市光电缆行业诚信企业表彰授牌仪式、苏州市光电缆行业产教融合创新发展研讨会”在亨通集团顺利召开。全国首个基于产业校商合作的产教党建合作交流平台——“苏州市光电缆产教融合党建联盟”正式揭牌成立，联盟第一届委员会12家成员单位现场被授牌。</FONT></DIV>\n" +
                "<DIV><FONT size=3>&nbsp;&nbsp;&nbsp; 会上，党建联盟委员会主任、电子信息工程学院党总支书记王亚作联盟工作汇报。校党委副书记、副校长刘丹和苏州市光电缆业商会常务副会长兼秘书长钱建林共同进行现场揭牌。</FONT></DIV>\n" +
                "<DIV><FONT size=3>&nbsp;&nbsp;&nbsp; 党建联盟是在学校党委、市总商会党委的领导和指导下，由电子信息学院党总支、苏州市光电缆业商会党支部牵头筹建，联合了一批校商企的党组织，合作共建的联合党建工作创新平台。党建联盟下设委员会和管理办公室，由商、企、校三方的党组织负责人联合组成联盟委员会，每届任期三年，委员会主要成员由上级党委聘任。</FONT></DIV>\n" +
                "<DIV><FONT size=3>&nbsp;&nbsp;&nbsp; 党建联盟将坚持“党建引领校商合作、党建助推产教融合”的宗旨，按照“党委领导、行业联动、多方参与、共促发展”的原则，贯彻“资源共享、活动共办、人才共育、文化共信”的“四共”方针，做好“发展联推、服务联手、人才联育、党建联动”的“四联”服务，努力凝聚和发挥好政、商、校、企等多方党组织和党员的作用，加强产教党建资源融合，增强党建工作合力，积极构建商、校、企各类党组织和广大党员群众共同参与产教党建格局，与“苏州市光电缆行业大学”一道，促进区域经济和社会各项事业全面协调发展。</FONT></DIV>\n" +
                "<DIV><FONT size=3>&nbsp;&nbsp;&nbsp; 党建联盟的主要任务是，全面贯彻落实中央和苏州市委关于创新党建工作的要求，从宏观上指导推进商校企范围内的党建工作，坚持“产业转型发展、人才全面发展、社会和谐发展、党建创新发展”方针，以党建为纽带，汇聚各方智慧，凝聚各方合力，以群众需求和亟需解决的问题为导向，推进加盟单位之间的合作与共赢，唱响“党建也是生产力”的主旋律，共同推进苏州光电缆产教融合与校商合作，实现社会和谐稳定。</FONT></DIV>\n" +
                "<DIV align=center><IMG border=0 src=\"http://www.jssvc.edu.cn/UploadFiles/201774165610288.jpg\"></DIV>\n" +
                "<DIV align=center><FONT size=3></FONT>&nbsp;</DIV>\n" +
                "<DIV align=center><IMG border=0 src=\"http://www.jssvc.edu.cn/UploadFiles/201774165618987.jpg\"></DIV>\n" +
                "<DIV align=right><FONT size=3>（电子信息工程学院）</FONT></DIV><div></div>";
        Intent intent = new Intent(getActivity(), NewsContentActivity.class);
        intent.putExtra("title","标题");
        intent.putExtra("time","2017-07-12 17:38:00");
        intent.putExtra("content",string);
        getActivity().startActivity(intent);
    }
}
