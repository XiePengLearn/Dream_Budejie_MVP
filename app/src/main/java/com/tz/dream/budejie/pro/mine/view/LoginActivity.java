package com.tz.dream.budejie.pro.mine.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.tz.dream.budejie.R;
import com.tz.dream.budejie.bean.UserBean;
import com.tz.dream.budejie.mvp.presenter.impl.MvpBasePresenter;
import com.tz.dream.budejie.pro.base.presenter.BasePresenter;
import com.tz.dream.budejie.pro.base.view.BaseActivtiy;
import com.tz.dream.budejie.pro.mine.presenter.LoginPresenter;
import com.tz.dream.budejie.pro.mine.view.navigation.LoginNavigationBuilder;
import com.tz.dream.budejie.utils.ToastUtil;

/**
 * Created by Dream on 16/5/29.
 */
public class LoginActivity extends BaseActivtiy implements View.OnClickListener{

    private LoginPresenter loginPresenter;


    private EditText et_phone;
    private EditText et_password;

    @Override
    public MvpBasePresenter bindPresenter() {
        loginPresenter = new LoginPresenter(this);
        return loginPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initToolBar();
        initView();
    }

    private void initToolBar(){
        LinearLayout ll_login = (LinearLayout) findViewById(R.id.ll_login);
        LoginNavigationBuilder builder = new LoginNavigationBuilder(this);
        builder.setLeftIcon(R.drawable.login_close_selector)
                .setTitle(R.string.login_and_register_text)
                .setLeftIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
        builder.createAndBind(ll_login);
    }

    private void initView(){
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_password = (EditText) findViewById(R.id.et_password);

        findViewById(R.id.bt_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        loginPresenter.login(et_phone.getText().toString(),
                et_password.getText().toString(),
                new BasePresenter.OnUIThreadListener<UserBean>() {
            @Override
            public void onResult(UserBean result) {
                if (result == null){
                    ToastUtil.showToast(LoginActivity.this,"登录失败!");
                }else {
                    ToastUtil.showToast(LoginActivity.this,"登录成功!");
                }
            }
        });
    }
}
