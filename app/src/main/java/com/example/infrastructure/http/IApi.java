package com.example.infrastructure.http;

import com.example.toollib.http.HttpResult;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IApi {
    /**
     * 获取当日总览
     *
     * @return observable
     */
    @GET("static/todaysummary")
    Observable<HttpResult> toDaySummary();
}
