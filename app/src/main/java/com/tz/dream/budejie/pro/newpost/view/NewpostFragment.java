package com.tz.dream.budejie.pro.newpost.view;

import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.tz.dream.budejie.R;
import com.tz.dream.budejie.pro.base.view.BaseFragment;
import com.tz.dream.budejie.pro.newpost.view.adapter.NewpostAdapter;
import com.tz.dream.budejie.pro.newpost.view.navigation.NewpostNavigationBuilder;
import com.tz.dream.budejie.utils.ToastUtil;

import java.util.Arrays;

/**
 *created by Administrator
 */
public class NewpostFragment extends BaseFragment{

    private TabLayout tab_newpost;
    private ViewPager vp_newpost;

    @Override
    public int getContentView() {
        return R.layout.fragment_newpost;
    }

    @Override
    public void initContentView(View viewContent) {
        initToolBar(viewContent);
        this.tab_newpost = (TabLayout) viewContent.findViewById(R.id.tab_essence);
        this.vp_newpost = (ViewPager) viewContent.findViewById(R.id.vp_essence);

    }

    private void initToolBar(View viewContent){
        NewpostNavigationBuilder builder = new NewpostNavigationBuilder(getContext());
        builder.setTitleIcon(R.drawable.main_essence_title)
                .setLeftIcon(R.drawable.main_newpost_audit_btn_selector)
                .setLeftIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast(getContext(),"点击了");
                    }
                });
        builder.createAndBind((ViewGroup) viewContent);
    }

    @Override
    public void initData() {
        String[] titles = getResources().getStringArray(R.array.newpost_video_tab);
        NewpostAdapter adapter =
                new NewpostAdapter(getFragmentManager(), Arrays.asList(titles));
        this.vp_newpost.setAdapter(adapter);
        this.tab_newpost.setupWithViewPager(this.vp_newpost);
    }

}
