package com.example.zhenghangxia.fatebook.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.bean.PlanBean;

import java.util.List;

/**
 * Created by zhenghangxia on 17-7-5.
 *
 *      规划页面列表适配器
 *
 */

public class PlanAdapter extends ArrayAdapter {

    private final Context mContext;
    private List<PlanBean> mList;

    public PlanAdapter(Context context, List<PlanBean> mList) {
        super(context, 0, mList);
        this.mContext = context;
        this.mList = mList;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PlanBean bean = (PlanBean) getItem(position);
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list,parent,false);
            holder = new ViewHolder();
            holder.mTextTime = (TextView) convertView.findViewById(R.id.tv_list_item_time);
            holder.mTextContent = (TextView) convertView.findViewById(R.id.tv_list_item_content);
            holder.mRatingBar = (RatingBar) convertView.findViewById(R.id.ratingBar);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (bean != null) {
            holder.mTextTime.setText(bean.getTime());
            holder.mTextContent.setText(bean.getContent());
            holder.mRatingBar.setRating(bean.getStar());
        }
        return convertView;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    public class ViewHolder {

        TextView mTextTime;
        TextView mTextContent;
        RatingBar mRatingBar;
    }

}
