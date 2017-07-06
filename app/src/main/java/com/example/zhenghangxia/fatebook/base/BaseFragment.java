package com.example.zhenghangxia.fatebook.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhenghangxia.fatebook.R;

/**
 * Created by zhenghangxia on 17-7-5.
 *
 */

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayout(),container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
    }

    protected abstract int getLayout();

    protected abstract void initView();

    public void initToolBarTitle (String title) {

        TextView mTextTitle = (TextView) getView().findViewById(R.id.tv_header_title);
        mTextTitle.setText(title);

    }
}
