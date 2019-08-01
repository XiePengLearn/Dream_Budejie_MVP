package com.tz.dream.budejie.pro.attention.view.navigation;

import android.content.Context;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import android.view.ViewGroup;

import com.tz.dream.budejie.R;
import com.tz.dream.budejie.pro.base.view.navigation.NavigationBuilderAdapter;


/**
 *created by Administrator
 */
public class AttentionNavigationBuilder extends NavigationBuilderAdapter{

    private ViewPager viewPager;

    public AttentionNavigationBuilder(Context context){
        super(context);
    }


    @Override
    public int getLayoutId() {
        return R.layout.toolbar_attention_layout;
    }

    public AttentionNavigationBuilder setUpWithViewPager(ViewPager viewPager){
        this.viewPager = viewPager;
        return this;
    }

    @Override
    public void createAndBind(ViewGroup parent) {
        super.createAndBind(parent);
        setImageViewStyle(R.id.iv_left,getLeftIconRes(),getLeftIconOnClickListener());
        TabLayout tab_attention = (TabLayout) findViewById(R.id.tab_attention);
        tab_attention.setupWithViewPager(viewPager);
    }
}
