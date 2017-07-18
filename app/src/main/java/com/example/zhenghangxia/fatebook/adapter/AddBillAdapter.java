package com.example.zhenghangxia.fatebook.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.bean.AccountStyleBean;

import java.util.List;

/**
 * Created by zhenghangxia on 17-7-18.
 *
 *
 */

public class AddBillAdapter extends BaseAdapter {

    private final List<AccountStyleBean> mList;
    private final Context mContext;
    private int selectorPosition;

    public AddBillAdapter(Context mContext, List<AccountStyleBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        AccountStyleBean bean = mList.get(position);
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_add_bill_grid,parent,false);
            holder = new ViewHolder();
            holder.styleIcon = (ImageView) convertView.findViewById(R.id.iv_style_icon);
            holder.styleName = (TextView) convertView.findViewById(R.id.tv_style_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (bean != null) {
            holder.styleName.setText(bean.getStyleName());
            Glide.with(mContext).load(bean.getStyleId()).into(holder.styleIcon);
        }

        if (selectorPosition == position) {
//            convertView.setBackground(mContext.getResources().getDrawable(R.drawable.circle_bg));
            holder.styleIcon.setBackground(mContext.getDrawable(R.drawable.circle_bg));
            holder.styleName.setTextColor(mContext.getColor(R.color.md_blue_400));
        } else {
//            convertView.setBackgroundColor(mContext.getColor(R.color.md_white_1000));
            holder.styleIcon.setBackgroundColor(Color.WHITE);
            holder.styleName.setTextColor(mContext.getColor(R.color.md_grey_400));
        }

        return convertView;
    }

    protected class ViewHolder {

        private TextView styleName;
        private ImageView styleIcon;

    }

    public void changeState(int pos) {
        selectorPosition = pos;
        notifyDataSetChanged();

    }

}
