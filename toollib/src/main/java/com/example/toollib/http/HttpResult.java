package com.example.toollib.http;


import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;


public class HttpResult<T> {

    @SerializedName("msg")
    private String msg;

    @SerializedName("code")
    private String code;

    @SerializedName("resData")
    private T data ;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @NonNull
    @Override
    public String toString() {
        return "HttpResult{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", resData=" + data +
                '}';
    }
}
