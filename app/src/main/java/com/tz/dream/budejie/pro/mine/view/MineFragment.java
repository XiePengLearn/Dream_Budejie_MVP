package com.tz.dream.budejie.pro.mine.view;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import com.tz.dream.budejie.R;
import com.tz.dream.budejie.pro.base.view.BaseFragment;
import com.tz.dream.budejie.pro.base.view.item.DefaultItemBuilder;
import com.tz.dream.budejie.pro.essence.view.navigation.EssenceNavigationBuilder;
import com.tz.dream.budejie.pro.mine.view.navigation.MineNavigationBuilder;
import com.tz.dream.budejie.utils.ToastUtil;

/**
 *created by Administrator
 */
public class MineFragment extends BaseFragment{


    @Override
    public int getContentView() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initContentView(View viewContent) {
        initToolBar(viewContent);
        initItem(viewContent);
    }

    private void initToolBar(View viewContent){
        MineNavigationBuilder builder = new MineNavigationBuilder(getContext());
        //遇到了问题:方法的顺序要写对
        builder.setModelRes(R.drawable.main_mine_night_model_selector)
                .setModelOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .setTitle(R.string.main_mine_title_text)
                .setRightIcon(R.drawable.main_mine_setting_selector)
                .setRightIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast(getContext(),"点击了");
                    }
                });
        builder.createAndBind((ViewGroup) viewContent);
    }


    private void initItem(View viewContent){
        DefaultItemBuilder builder = new DefaultItemBuilder(getContext());
        builder.setLeftIcon(R.drawable.login_unlogin_header)
                .setLeftText(R.string.login_login_text)
                .setRightIcon(R.drawable.item_jiantou)
                .setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getActivity(),LoginActivity.class));
                    }
                });
        builder.buildAndBind((ViewGroup) viewContent);
    }

}
