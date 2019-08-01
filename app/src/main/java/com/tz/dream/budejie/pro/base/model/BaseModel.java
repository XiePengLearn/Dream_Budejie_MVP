package com.tz.dream.budejie.pro.base.model;

import android.content.Context;

import com.tz.dream.budejie.mvp.model.MvpModel;

/**
 * Created by Dream on 16/5/28.
 */
public abstract class BaseModel implements MvpModel{

    private Context context;

    public BaseModel(Context context){
        this.context = context;
    }

    public String getServerUrl(){
        return "http://api.budejie.com";
    }

}
