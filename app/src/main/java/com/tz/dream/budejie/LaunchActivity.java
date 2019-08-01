package com.tz.dream.budejie;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        // 你们平时做启动页
        // 总结：
        // 有四种解决方案（企业级开发主要就是这四种方案）
        // 第一种方案：属性动画ObjectAnimator实现－－－－
        // 第二种方案：补间动画实现(例如：TranslateAnimation、ScaleAnimation、AlphaAnimation、RotateAnimation)
        // 第三种方案：定时器Timer实现
        // 第四种方案：Handler+Thread实现－－－AsyncTask封装
        // 今天采用第一种方案

        // 第一个参数－－－target:你要对哪个View绑定动画－－－今天我们要对ImageView绑定动画
        View target = findViewById(R.id.iv_bg);
        // 第二个参数－－－propertyName:你要执行什么动画－－－动画的属性名称
        // 缩放动画：scaleX
        // 渐变动画：
        // 第三个参数－－－动画变化范围（例如：缩放动画变化范围0.0-1.0之间）
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(target, "alpha",
                0.0f, 1.0f);
        // 设置动画执行的时间（企业级开发标准：执行时间一般情况2-3秒钟）
        objectAnimator.setDuration(2000);
        // 启动动画
        objectAnimator.start();


        // 思考：动画执行完毕我们是不是要启动新的页面
        // 扩展知识点－－－设计模式－－－适配器模式
        // 项目开发需要定义很多的接口
        // google工程师非常牛逼---提供接口适配器：AnimatorListenerAdapter
        // 将来我们做开发我们是不是可以这么干？
        // java编程思想：设计模式
        objectAnimator.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startActivity(new Intent(LaunchActivity.this,
                        MainActivity.class));
                finish();
            }
        });


    }
}
