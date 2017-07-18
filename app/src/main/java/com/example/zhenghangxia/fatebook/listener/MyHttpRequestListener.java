package com.example.zhenghangxia.fatebook.listener;

import android.os.Handler;

import com.turing.androidsdk.HttpRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.zhenghangxia.fatebook.activity.RobotActivity.MSG_SPEECH_START;

/**
 * Created by zhenghangxia on 17-7-17.
 *
 *  小云机器人网络请求监听器
 *
 */

public class MyHttpRequestListener implements HttpRequestListener {

    public MyHttpRequestListener(Handler mHandler) {
        this.mHandler = mHandler;
    }

    private Handler mHandler;

    @Override
    public void onSuccess(String result) {
        if (result != null) {
            try {
                JSONObject result_obj = new JSONObject(result);
                if (result_obj.has("text")) {
                    mHandler.obtainMessage(MSG_SPEECH_START,
                            result_obj.get("text")).sendToTarget();
                }
            } catch (JSONException e) {

            }
        }
    }

    @Override
    public void onFail(int code, String error) {
        mHandler.obtainMessage(MSG_SPEECH_START, "网络慢脑袋不灵了").sendToTarget();
    }
}
