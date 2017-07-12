package com.example.zhenghangxia.fatebook.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhenghangxia.fatebook.R;
import com.example.zhenghangxia.fatebook.bean.NewsBean;

import java.util.List;

/**
 * Created by zhenghangxia on 17-7-12.
 */

public class NewsAdapter extends ArrayAdapter {
    private final Context mContext;
    private List<NewsBean> mList;

    public NewsAdapter(Context context, List<NewsBean> mList) {
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
        NewsBean bean = (NewsBean) getItem(position);
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_news_list,parent,false);
            holder = new ViewHolder();
            holder.mTextTitle = (TextView) convertView.findViewById(R.id.tv_list_item_title);
            holder.mTextContent = (TextView) convertView.findViewById(R.id.tv_list_item_content);
            holder.mImageView = (ImageView) convertView.findViewById(R.id.img_list_item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (bean != null) {
            holder.mTextTitle.setText(bean.getTitle());
            holder.mTextContent.setText(
                    "深夜，三名小偷敦也、翔太、幸平正开着偷来的汽车逃跑。途中汽车突然抛锚" +
                            "，无奈下三人只好逃入翔太以前发现的弃屋“浪矢杂货店”里躲避，待到天亮再作打算" +
                            "。三人在店内搜索时，突然有一封信从铁卷门上的邮件投递口被投了进来。三人拆阅信件" +
                            "，发现内容是一个化名“月兔”的女性写来的烦恼咨询信。从店内留下的旧杂志" +
                            "，三人发现这家“浪矢杂货店”因为以前的店主将致函的烦恼咨询信件一一用心解答而闻名。" +
                            "敦也坚持不要理睬，而翔太和幸平则认为这种机会千载难逢，决定给那封咨询信件写回信。");
            Glide.with(mContext).load(bean.getImgSrc()).into(holder.mImageView);
        }
        return convertView;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    public class ViewHolder {

        TextView mTextTitle;
        TextView mTextContent;
        ImageView mImageView;
    }
}
