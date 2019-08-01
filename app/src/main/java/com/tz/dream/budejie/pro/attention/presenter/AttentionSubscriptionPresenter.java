package com.tz.dream.budejie.pro.attention.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.tz.dream.budejie.bean.AttentionSubscriptionBean;
import com.tz.dream.budejie.http.utils.HttpUtils;
import com.tz.dream.budejie.pro.attention.model.AttentionSubscriptionModel;
import com.tz.dream.budejie.pro.base.presenter.BasePresenter;
import com.tz.dream.budejie.utils.GsonUtils;

import java.util.List;

/**
 * Created by Dream on 16/5/30.
 */
public class AttentionSubscriptionPresenter extends BasePresenter<AttentionSubscriptionModel>{

    public AttentionSubscriptionPresenter(Context context) {
        super(context);
    }

    @Override
    public AttentionSubscriptionModel bindModel() {
        return new AttentionSubscriptionModel(getContext());
    }

    public void getAttentionSubscriptionList(int type, final OnUIThreadListener<List<AttentionSubscriptionBean>> onUIThreadListener){
        getModel().getAttentionSubscriptionList(type, new HttpUtils.OnHttpResultListener() {
            @Override
            public void onResult(String result) {
                if (TextUtils.isEmpty(result)){
                    onUIThreadListener.onResult(null);
                }else {
                    List<AttentionSubscriptionBean> list = GsonUtils.getList(result,AttentionSubscriptionBean.class);
                    onUIThreadListener.onResult(list);
                }
            }
        });
    }

}
