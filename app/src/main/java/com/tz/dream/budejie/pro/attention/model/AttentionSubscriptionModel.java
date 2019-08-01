package com.tz.dream.budejie.pro.attention.model;

import android.content.Context;

import com.tz.dream.budejie.http.impl.RequestParam;
import com.tz.dream.budejie.http.impl.SystemHttpCommand;
import com.tz.dream.budejie.http.utils.HttpTask;
import com.tz.dream.budejie.http.utils.HttpUtils;
import com.tz.dream.budejie.pro.base.model.BaseModel;

/**
 * Created by Dream on 16/5/30.
 */
public class AttentionSubscriptionModel extends BaseModel{

    private static final String URL_STR = "/api/api_open.php";

    public AttentionSubscriptionModel(Context context) {
        super(context);
    }

    public void getAttentionSubscriptionList(int type, HttpUtils.OnHttpResultListener onHttpResultListener){
        RequestParam requestParam = new RequestParam();
        requestParam.put("a","tag_recommend");
        requestParam.put("action","sub");
        requestParam.put("c","topic");
        requestParam.put("type",type);

        HttpTask httpTask = new HttpTask(getServerUrl().concat(URL_STR),requestParam,new SystemHttpCommand(),onHttpResultListener);
        httpTask.execute();

    }

}
