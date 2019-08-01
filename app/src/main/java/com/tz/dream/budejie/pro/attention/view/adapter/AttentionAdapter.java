package com.tz.dream.budejie.pro.attention.view.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.tz.dream.budejie.pro.attention.view.AttentionListFragment;
import com.tz.dream.budejie.pro.attention.view.AttentionSubscriptionFragment;

import java.util.List;


/**
 * 关注适配器-初始化ViewPager,加载Fragment
 *created by Administrator
 */
public class AttentionAdapter extends FragmentStatePagerAdapter {

    public static final String TAB_TAG = "@dream@";

    private List<String> mTitles;

    public AttentionAdapter(FragmentManager fm, List<String> titles) {
        super(fm);
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            AttentionSubscriptionFragment fragment = new AttentionSubscriptionFragment();
            String[] title = mTitles.get(position).split(TAB_TAG);
            fragment.setType(Integer.parseInt(title[1]));
            fragment.setTitle(title[0]);
            return fragment;
        }
        AttentionListFragment fragment = new AttentionListFragment();
        String[] title = mTitles.get(position).split(TAB_TAG);
        fragment.setType(Integer.parseInt(title[1]));
        fragment.setTitle(title[0]);
        return fragment;
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position).split(TAB_TAG)[0];
    }
}
