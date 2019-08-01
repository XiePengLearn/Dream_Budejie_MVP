package com.tz.dream.budejie.pro.essence.view.navigation;

import android.content.Context;

import com.tz.dream.budejie.R;
import com.tz.dream.budejie.pro.base.view.navigation.NavigationBuilderAdapter;

/**
 *created by Administrator
 */
public class EssenceNavigationBuilder extends NavigationBuilderAdapter{

    public EssenceNavigationBuilder(Context context){
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_essence_layout;
    }
}
