package com.example.zhenghangxia.fatebook.listener;

import android.os.Handler;

import com.turing.androidsdk.TTSListener;

import static com.example.zhenghangxia.fatebook.activity.RobotActivity.MSG_RECOGNIZE_START;

/**
 * Created by zhenghangxia on 17-7-17.
 *
 *  小云机器人文字转语音监听器
 *
 */

public class MyTTSListener implements TTSListener {

    public MyTTSListener(Handler mHandler) {
        this.mHandler = mHandler;
    }

    private Handler mHandler;

    @Override
    public void onSpeechStart() {

    }

    @Override
    public void onSpeechProgressChanged() {

    }

    @Override
    public void onSpeechPause() {

    }

    @Override
    public void onSpeechFinish() {
        mHandler.sendEmptyMessage(MSG_RECOGNIZE_START);
    }

    @Override
    public void onSpeechError(int i) {
        mHandler.sendEmptyMessage(MSG_RECOGNIZE_START);
    }

    @Override
    public void onSpeechCancel() {

    }
}
