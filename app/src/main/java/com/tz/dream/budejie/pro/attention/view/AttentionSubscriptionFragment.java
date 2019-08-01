package com.tz.dream.budejie.pro.attention.view;

import android.view.View;
import android.widget.ListView;

import com.tz.dream.budejie.R;
import com.tz.dream.budejie.bean.AttentionSubscriptionBean;
import com.tz.dream.budejie.pro.attention.presenter.AttentionSubscriptionPresenter;
import com.tz.dream.budejie.pro.attention.view.adapter.AttentionSubscriptionAdapter;
import com.tz.dream.budejie.pro.base.presenter.BasePresenter;
import com.tz.dream.budejie.pro.base.view.BaseFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * 订阅列表
 * Created by Dream on 16/5/29.
 */
public class AttentionSubscriptionFragment extends BaseFragment<AttentionSubscriptionPresenter>{

    private int mType = 0;
    private String mTitle;

    private AttentionSubscriptionAdapter subscriptionAdapter;
    private List<AttentionSubscriptionBean> subscriptionBeanList = new ArrayList<>();

    @Override
    public AttentionSubscriptionPresenter bindPresenter() {
        return new AttentionSubscriptionPresenter(getContext());
    }

    public void setType(int mType) {
        this.mType = mType;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_attention_subscription;
    }

    @Override
    public void initContentView(View contentView) {
        ListView lv_attention = (ListView) contentView.findViewById(R.id.lv_attention);
        subscriptionAdapter = new AttentionSubscriptionAdapter(getContext(),subscriptionBeanList);
        lv_attention.setAdapter(subscriptionAdapter);
    }

    @Override
    public void initData() {
        loadData(1);
    }

    private void loadData(int mType){
        getPresenter().getAttentionSubscriptionList(mType, new BasePresenter.OnUIThreadListener<List<AttentionSubscriptionBean>>() {
            @Override
            public void onResult(List<AttentionSubscriptionBean> result) {
                if (result != null){
                    //刷新适配器
                    subscriptionBeanList.addAll(result);
                    subscriptionAdapter.notifyDataSetChanged();
                }
            }
        });
    }

}
