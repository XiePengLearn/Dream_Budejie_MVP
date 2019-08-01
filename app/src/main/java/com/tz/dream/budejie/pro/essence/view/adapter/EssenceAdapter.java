package com.tz.dream.budejie.pro.essence.view.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.tz.dream.budejie.pro.essence.view.EssenceVideoFragment;

import java.util.List;


/**
 *created by Administrator
 */
public class EssenceAdapter extends FragmentStatePagerAdapter {

    public static final String TAB_TAG = "@dream@";

    private List<String> mTitles;

    public EssenceAdapter(FragmentManager fm, List<String> titles) {
        super(fm);
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        EssenceVideoFragment fragment = new EssenceVideoFragment();
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
