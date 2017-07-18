package com.example.zhenghangxia.fatebook.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.activity.base.BaseActivity;
import com.example.zhenghangxia.fatebook.adapter.RobotAdapter;
import com.example.zhenghangxia.fatebook.bean.MsgBean;
import com.example.zhenghangxia.fatebook.listener.MyHttpRequestListener;
import com.example.zhenghangxia.fatebook.listener.MyTTSListener;
import com.example.zhenghangxia.fatebook.utils.Constants;
import com.turing.androidsdk.TTSManager;
import com.turing.androidsdk.TuringManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhenghangxia on 17-7-17.
 *
 *  小云机器人
 *
 */

public class RobotActivity extends BaseActivity implements View.OnClickListener {

    private EditText mMessageSent;
    private RecyclerView mRecyclerView;
    private RobotAdapter mAdapter;
    private List<MsgBean> mList = new ArrayList<>();

    private TTSManager mTtsManager;

    /**
     * 返回结果，开始说话
     */
    public static final int MSG_SPEECH_START = 0;
    /**
     * 开始识别
     */
    public static final int MSG_RECOGNIZE_RESULT = 1;
    /**
     * 开始识别
     */
    public static final int MSG_RECOGNIZE_START = 2;
    private TuringManager mTuringManager;

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_SPEECH_START:
                    MsgBean msgBean1 = new MsgBean((String) msg.obj, MsgBean.TYPE_RECEIVED);
                    mList.add(msgBean1);
                    mAdapter.notifyItemInserted(mList.size()-1);
                    mRecyclerView.scrollToPosition(mList.size()-1);
                    // 开始语音合成
                    mTtsManager.startTTS((String) msg.obj);
                    break;
                case MSG_RECOGNIZE_RESULT:
                    mMessageSent.setText("");
                    MsgBean msgBean2 = new MsgBean((String) msg.obj, MsgBean.TYPE_SENT);
                    mList.add(msgBean2);
                    mAdapter.notifyItemInserted(mList.size()-1);
                    mRecyclerView.scrollToPosition(mList.size()-1);
                    // 发送请求
                    mTuringManager.requestTuring((String) msg.obj);
                    break;
            }
        }
    };

    @Override
    protected int getLayout() {
        return R.layout.activity_life_robot;
    }

    @Override
    protected void initView() {
        initToolBar();

        TextView title = (TextView) findViewById(R.id.tv_header_title);
        title.setText(getResources().getString(R.string.text_robot_name_life));

        init();
    }

    private void init() {
        mMessageSent = (EditText) findViewById(R.id.et_chat_message_send);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_chat_list);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new RobotAdapter(mList);
        mRecyclerView.setAdapter(mAdapter);

        ImageButton mBtnSent = (ImageButton) findViewById(R.id.btn_send);
        mBtnSent.setOnClickListener(this);

        // 实例化TTSManager(语音合成管理类)，目前只支持百度
        mTtsManager = new TTSManager(
                this,
                Constants.BD_APP_ID,
                Constants.BD_APP_SECRET);

        // 设置TTS监听器
        mTtsManager.setTTSListener(new MyTTSListener(mHandler));

        // 实例化TuringManager类
        // 第二个参数是图灵key,第三个参数是图灵secret
        mTuringManager = new TuringManager(
                this,
                Constants.TL_APP_ID,
                Constants.TL_APP_SECRET);

        // 设置网络请求监听器
        mTuringManager.setHttpRequestListener(new MyHttpRequestListener(mHandler));

        // 进入页面文字语音提示信息
        Message message = new Message();
        message.what = MSG_SPEECH_START;
        message.obj = getResources().getString(R.string.welcome_robot);
        mHandler.sendMessage(message);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send:
                String content = mMessageSent.getText().toString();
                if (!"".equals(content)) {
                    Message message = new Message();
                    message.what = MSG_RECOGNIZE_RESULT;
                    message.obj = content;
                    mHandler.sendMessage(message);
                }
                break;
        }
    }

}
