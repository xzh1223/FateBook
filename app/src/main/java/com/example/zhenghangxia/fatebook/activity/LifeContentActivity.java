package com.example.zhenghangxia.fatebook.activity;

import android.widget.TextView;

import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.activity.base.BaseActivity;
import com.example.zhenghangxia.fatebook.utils.ToastUtil;
import com.zzhoujay.richtext.RichText;

/**
 * Created by zhenghangxia on 17-7-14.
 *
 *      生活内容界面
 *
 */

public class LifeContentActivity extends BaseActivity {
    private TextView mTitle;
    private TextView mRemark;
    private TextView mContent;

    @Override
    protected int getLayout() {
        return R.layout.activity_life_content;
    }

    @Override
    protected void initView() {
        initToolBar();

        mTitle = (TextView) findViewById(R.id.tv_life_title);
        mRemark = (TextView) findViewById(R.id.tv_life_remark);
        mContent = (TextView) findViewById(R.id.tv_file_content);

        initData();
    }

    private void initData() {

        String flag = getIntent().getStringExtra("flag");
        ToastUtil.toast(this, flag);
        String string = "<div class=\"para\" label-module=\"para\">东野圭吾写过很多揭露人性丑恶的推理小说，但是同时也彰显人性的善意。《解忧杂货店》中，浪矢爷爷几乎就是东野的化身。东野圭吾收到的咨询信，不一定真的有时间一封一封回复，但是他通过小说回答了很多问题，比如浪矢爷爷说：“这么多年咨询信看下来，逐渐明白，很多时候，咨询的人心里已经有了答案，来咨询只是想确认自己的决定是对的。”浪矢爷爷总是很认真地回复别人的问题，哪怕是恶作剧。他说：“我不但要写回信，而且要好好思考再写。人的心声是绝对不能无视的。”临死之前，他收到了很多感谢信，他很谦虚地说：“像我这样的糟老头子，怎么可能有左右别人的力量？如果说我的回答起了作用，是因为他们自己很努力。如果自己不想积极认真地生活，不管得到什么样的回答都没用。”</div>\n" +
                "<div class=\"para\" label-module=\"para\">所有的回答都非常温馨、主流，以爱和家庭为核心。比如说，劝说运动员放弃训练去陪伴得了绝症的男朋友；父亲欠了债，即使逃亡，也应该一家人在一起；父母要竭尽全力给孩子幸福。新经典文化的外国文学总编辑黎遥说：“作者用温柔的笔触抚慰人们内心中的种种烦恼，每一个情节无不让人为之动情”。编剧史航说《解忧杂货店》利用时空扭转，歪打正着。三个抢劫犯回答时劝说来信人别这么干，结果写信人以为是在受考验，因为时光倒错，一切都得以成全。评论家止庵也说《解忧杂货店》运用了超现实因素，但是用得非常克制，充分利用了误解，唤起内心的善。最终咨询人是按照自己的内心做出的选择，由此可见东野虽然是畅销书作家，但是他确实对人心和人与人之间的关系，有着深刻的理解。<sup>[8]</sup><a class=\"sup-anchor\" name=\"ref_[8]_19087569\">&nbsp;</a>\n" +
                "</div>\n" +
                "<div class=\"para\" label-module=\"para\">一个已经废弃了的杂货店，可以收到来自几十年前的信件，这本身是可以解释的。但是，进入这个房间的人看了信件，回复的信件竟然也可以被几十年前的人看到，这就有些勉强了。而小说家用浪矢杂货店老板的死来虚化时间，让时间成为三维空间里的时间。三个小偷中的敦也最不相信时间可以穿越，所以，在小说的结尾，作者就让敦也走出杂货店，往信箱里投了一张白纸。他想试一下这张白纸会不会真的被送到过去。</div>\n" +
                "<div class=\"para\" label-module=\"para\">果然，他投进信箱的白纸条正好在浪矢贵之陪父亲回到杂货店那天晚上被发现，敦也收到了老人家的回信。那封信穿过时间的隧道，深情而又充满力量，劝慰他说：“如果把来找我咨询的人比喻成迷途的羔羊，通常他们手上都有地图，却没有去看，或是不知道自己目前的位置。但我相信你不属于这两种情况。你的地图是一张白纸，所以即使想决定目的地，也不知道路在哪里……换个角度来看，正因为是一张白纸，才可以随心所欲地描绘地图。一切全在你自己。我衷心祈祷你可以相信自己，无悔地燃烧自己的人生。”这段话是如此的心灵鸡汤，却又如此的动人。最终三个小偷也从解忧杂货店获得了人生的答案。<sup>[11]</sup><a class=\"sup-anchor\" name=\"ref_[11]_19087569\">&nbsp;</a>\n" +
                "</div>\n" +
                "<div class=\"para\" label-module=\"para\">一丝善念促使小偷以“浪矢杂货店”的名义回信——尽管行文粗鲁、错别字很多，但是他们和当年的店主浪矢爷爷一样，是真心诚意对待这些来信的。少年抢劫犯在回复过去人的来信中，也救赎了自己。这些看似不相干的人物之间又有着千丝万缕的联系，无意中相互影响。<sup>[8]</sup><a class=\"sup-anchor\" name=\"ref_[8]_19087569\">&nbsp;</a>\n" +
                "</div>\n" +
                "<div class=\"para\" label-module=\"para\">东野圭吾写出了沟通的微妙，现实生活的逻辑有时候是复杂的，甚至是一个悖论。三个小偷用个人的经历证实了：当事人的理解并不忠于帮助她的人的初衷，有时候甚至是相反的。这大概也是心理学上一个通常的原理。<sup>[11]</sup><a class=\"sup-anchor\" name=\"ref_[11]_19087569\">&nbsp;</a>\n" +
                "</div>";
        mTitle.setText("解忧杂货店");
        mRemark.setText("东野圭吾");
        RichText.from(string).into(mContent);

    }
}
