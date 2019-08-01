package com.tz.dream.budejie.http.impl;

import com.tz.dream.budejie.http.IHttpCommand;
import com.tz.dream.budejie.http.IRequestParam;
import com.tz.dream.budejie.http.utils.HttpUtils;

import java.util.HashMap;


/**
 * Created by Dream on 16/5/28.
 */
public class SystemHttpCommand implements IHttpCommand<HashMap<String,Object>> {

    @Override
    public String execute(String url, IRequestParam<HashMap<String, Object>> requestParam) {
        try {
            return HttpUtils.post(url,requestParam.getRequestParam());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
