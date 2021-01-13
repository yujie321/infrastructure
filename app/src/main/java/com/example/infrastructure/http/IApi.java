package com.example.infrastructure.http;

import com.example.infrastructure.data.Alarm;
import com.example.infrastructure.data.AlarmInfo;
import com.example.infrastructure.data.AngleData;
import com.example.infrastructure.data.BaseStation;
import com.example.infrastructure.data.Project;
import com.example.infrastructure.data.WindData;
import com.example.toollib.http.HttpResult;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IApi {
    /**
     * 登录验证
     *
     * @return observable
     */
    @POST("/user/login")
    Observable<HttpResult<Object>> login(@Query("userName") String userName, @Query("userPassword") String userPassword);

    /**
     * 获取项目列表
     *
     * @return observable
     */
    @GET("/platform/allInfo")
    Observable<HttpResult<List<Project>>> getProjectList(@Query("pageNum") int pageNum, @Query("pageSize") int pageSize);

    /**
     * 获取所有报警信息
     *
     * @return observable
     */
    @GET("/giveAlarmInfo/find")
    Observable<HttpResult<Alarm>> getAllAlarmInfo(@Query("pageNum") int pageNum, @Query("pageSize") int pageSize);

    /**
     * 查询倾角传感器
     *
     * @return observable
     */
    @GET("/dipAngleData/find")
    Observable<HttpResult<AngleData>> getAngleData();

    /**
     * 查询风速风向
     *
     * @return observable
     */
    @GET("/speedDirection/find")
    Observable<HttpResult<WindData>> getWindData();

    /**
     * 查询基站坐标
     *
     * @return observable
     */
    @GET("/station/allBaseStationInfo")
    Observable<HttpResult<List<BaseStation>>> getBaseStation();
}
