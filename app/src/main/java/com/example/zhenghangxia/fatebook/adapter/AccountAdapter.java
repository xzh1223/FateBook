package com.example.zhenghangxia.fatebook.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.bean.AccountBean;

import java.util.List;

/**
 * Created by zhenghangxia on 17-7-12.
 *
 *  记账页面列表适配器
 */

public class AccountAdapter extends ArrayAdapter {
    private final Context mContext;
    private List<AccountBean> mList;

    public AccountAdapter(Context context, List<AccountBean> mList) {
        super(context, 0, mList);
        this.mContext = context;
        this.mList = mList;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        AccountBean bean = (AccountBean) getItem(position);
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_account_list,parent,false);
            holder = new ViewHolder();
            holder.mTextTime = (TextView) convertView.findViewById(R.id.tv_list_time);
            holder.mTextNumber = (TextView) convertView.findViewById(R.id.tv_list_number);
            holder.mTextStyle = (TextView) convertView.findViewById(R.id.tv_list_style);
            holder.mImageView = (ImageView) convertView.findViewById(R.id.iv_list_style);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (bean != null) {
            holder.mTextTime.setText(bean.getYear() + " - " + bean.getMonth() + " - " + bean.getDay());
            holder.mTextStyle.setText(bean.getTypeContent());
            if ("支出".equals(bean.getType())) {
                holder.mTextNumber.setText("-" + bean.getNumber());
            } else {
                holder.mTextNumber.setText("+" + bean.getNumber());
            }
            holder.mImageView.setImageResource(bean.getImgSrc());
        }
        return convertView;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    private class ViewHolder {

        ImageView mImageView;
        TextView mTextTime;
        TextView mTextStyle;
        TextView mTextNumber;
    }
}
