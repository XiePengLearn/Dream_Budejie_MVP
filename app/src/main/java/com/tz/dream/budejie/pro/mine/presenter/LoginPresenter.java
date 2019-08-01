package com.tz.dream.budejie.pro.mine.presenter;

import android.content.Context;

import com.tz.dream.budejie.bean.UserBean;
import com.tz.dream.budejie.http.utils.HttpUtils;
import com.tz.dream.budejie.pro.base.presenter.BasePresenter;
import com.tz.dream.budejie.pro.mine.model.LoginModel;

/**
 * Created by Dream on 16/5/29.
 */
public class LoginPresenter extends BasePresenter<LoginModel>{

    public LoginPresenter(Context context) {
        super(context);
    }

    @Override
    public LoginModel bindModel() {
        return new LoginModel(getContext());
    }

    public void login(String username, String password, final OnUIThreadListener<UserBean> onUIThreadListener){
        getModel().login(username, password, new HttpUtils.OnHttpResultListener() {
            @Override
            public void onResult(String result) {
                //解析model
                if (result == null){
                    onUIThreadListener.onResult(null);
                }else {
                    UserBean userBean = getGson().fromJson(result,UserBean.class);
                    onUIThreadListener.onResult(userBean);
                }
            }
        });
    }

}
