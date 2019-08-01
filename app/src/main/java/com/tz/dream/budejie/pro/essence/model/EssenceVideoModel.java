package com.tz.dream.budejie.pro.essence.model;

import android.content.Context;
import android.text.TextUtils;

import com.tz.dream.budejie.http.impl.RequestParam;
import com.tz.dream.budejie.http.impl.SystemHttpCommand;
import com.tz.dream.budejie.http.utils.HttpTask;
import com.tz.dream.budejie.http.utils.HttpUtils;
import com.tz.dream.budejie.pro.base.model.BaseModel;

/**
 * M层:数据层
 *
 * 请求网络数据
 * 加载本地数据库缓存数据
 * 加载SD卡数据等等......
 *
 * Created by Dream on 16/5/28.
 */
public class EssenceVideoModel extends BaseModel{


    public EssenceVideoModel(Context context){
        super(context);
    }

    private String getUrl(){
        return getServerUrl().concat("/api/api_open.php");
    }

    //定义访问精华接口
    //第一步:定义URL
    //第二步:定义接口

    /**
     * 获取精华列表
     * @param type---数据类型(例如:图片  视频  音频  妹子等等)
     * @param page---页码
     * @param maxtime--用户加载更多
     * @param onHttpResultListener---数据回调监听
     */
    public void getEssenceList(int type, int page, String maxtime,HttpUtils.OnHttpResultListener onHttpResultListener){
        RequestParam requestParam = new RequestParam();
        requestParam.put("a","list");
        requestParam.put("c","data");
        requestParam.put("type",type);
        requestParam.put("page",page);
        if (!TextUtils.isEmpty(maxtime)){
            requestParam.put("maxtime",maxtime);
        }
        //发送请求
        HttpTask httpTask = new HttpTask(
                getUrl(),
                requestParam,
                new SystemHttpCommand(),
                onHttpResultListener);
        httpTask.execute();
    }
}
