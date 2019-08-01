package com.tz.dream.budejie.pro.essence.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.tz.dream.budejie.bean.PostsListBean;
import com.tz.dream.budejie.http.utils.HttpUtils;
import com.tz.dream.budejie.pro.base.model.BaseModel;
import com.tz.dream.budejie.pro.base.presenter.BasePresenter;
import com.tz.dream.budejie.pro.essence.model.EssenceVideoModel;

import java.util.List;

/**
 * MVP中的P层:处理数据返回之后的逻辑
 * 例如:数据解析等等业务逻辑
 *
 * Created by Dream on 16/5/28.
 */
public class EssenceVideoPresenter extends BasePresenter<EssenceVideoModel> {


    private int page = 0;
    private String maxtime = null;

    public EssenceVideoPresenter(Context context){
        super(context);
    }

    @Override
    public EssenceVideoModel bindModel() {
        return new EssenceVideoModel(getContext());
    }

    //定义解析方法
    public void getEssenceList(int type,
                               final boolean isDownRefresh,
                               final OnUIThreadListener<List<PostsListBean.PostList>> onUIThreadListener){
        if (isDownRefresh){
            maxtime = null;
        }
        //执行网络请求
        getModel().getEssenceList(type,page,maxtime,new HttpUtils.OnHttpResultListener(){
            @Override
            public void onResult(String result) {
                if (TextUtils.isEmpty(result)){
                    //等于空---通知UI线程---刷新UI界面
                    onUIThreadListener.onResult(null);
                }else {
                    //不等于null
                    //解析数据
                    PostsListBean postsListBean = getGson().fromJson(result,PostsListBean.class);
                    //处理分页逻辑---UI层只负责现实数据,不要做任何与网络相关的逻辑处理
                    if (postsListBean != null && postsListBean.getInfo() != null){
                        maxtime = postsListBean.getInfo().getMaxtime();
                    }
                    if (isDownRefresh){
                        page = 0;
                    }else {
                        page++;
                    }
                    //MVP架构---编程思想---属于移动架构师
                    //MVP架构适合面向对象的语言设计
                    //编程思想运用在任何的语言
                    onUIThreadListener.onResult(postsListBean.getList());
                }
            }
        });
    }



}
