package com.tz.dream.budejie.pro.mine.model;

import android.content.Context;

import com.tz.dream.budejie.http.impl.RequestParam;
import com.tz.dream.budejie.http.impl.SystemHttpCommand;
import com.tz.dream.budejie.http.utils.HttpTask;
import com.tz.dream.budejie.http.utils.HttpUtils;
import com.tz.dream.budejie.pro.base.model.BaseModel;

/**
 * Created by Dream on 16/5/29.
 */
public class LoginModel extends BaseModel{
    public LoginModel(Context context) {
        super(context);
    }

    public void login(String username, String password, HttpUtils.OnHttpResultListener onHttpResultListener){
        RequestParam requestParam = new RequestParam();
        requestParam.put("username",username);
        requestParam.put("password",password);
        HttpTask httpTask = new HttpTask("http://192.168.57.1:8080/Dream/LoginServlet",requestParam,new SystemHttpCommand(),onHttpResultListener);
        httpTask.execute();
    }

}
