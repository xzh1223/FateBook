package com.example.zhenghangxia.fatebook.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.bean.MsgBean;
import com.zzhoujay.richtext.RichText;

import java.util.List;

/**
 * Created by zhenghangxia on 17-7-4.
 */

public class RobotAdapter extends RecyclerView.Adapter<RobotAdapter.ViewHolder> {

    private final List<MsgBean> mList;

    public RobotAdapter(List<MsgBean> msgList) {
        this.mList = msgList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_robot_list,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MsgBean msgBean = mList.get(position);
        if (msgBean.getType() == MsgBean.TYPE_RECEIVED) {
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            RichText.from(msgBean.getContent()).into(holder.leftMsg);
        } else if (msgBean.getType() == MsgBean.TYPE_SENT){
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            RichText.from(msgBean.getContent()).into(holder.rightMsg);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;

        public ViewHolder(View view) {
            super(view);
            leftLayout = (LinearLayout) view.findViewById(R.id.ll_left);
            rightLayout = (LinearLayout) view.findViewById(R.id.ll_right);
            leftMsg = (TextView) view.findViewById(R.id.tv_left_msg);
            rightMsg = (TextView) view.findViewById(R.id.tv_right_msg);
        }
    }
}
