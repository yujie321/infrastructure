package com.example.toollib.util;

import com.example.toollib.http.exception.ApiException;

import org.greenrobot.eventbus.EventBus;

/**
 * @author Administrator
 * @date 2019/8/6 0006
 *
 * 登录拦截
 */
public class LoginInterceptor {

    /**
     * token 过期 或 重复登录
     */
    public static boolean tokenReLogin(ApiException apiException){
        boolean flag = true;
        return flag;
    }
}
