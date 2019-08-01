package com.tz.dream.budejie.pro.attention.view;

import android.view.View;

import com.tz.dream.budejie.R;
import com.tz.dream.budejie.pro.base.view.BaseFragment;


/**
 * 关注列表
 * Created by Dream on 16/5/29.
 */
public class AttentionListFragment extends BaseFragment{


    private int mType = 0;
    private String mTitle;

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setType(int type) {
        this.mType = type;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_attention_list;
    }

    @Override
    public void initContentView(View contentView) {

    }

    @Override
    public void initData() {

    }
}
