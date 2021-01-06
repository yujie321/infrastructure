package com.example.infrastructure.application;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.example.toollib.ToolLib;
import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager;

public class InfrastructureApplication extends Application {
    private static InfrastructureApplication infrastructureApplication;


    //    public static final String BASE_URL = "http://192.168.3.2:8082/";
    public static final String BASE_URL = "http://192.168.1.39:8082/microservice-pad/rest/";

    public static InfrastructureApplication getInstance() {
        return infrastructureApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        infrastructureApplication = this;

        QMUISwipeBackActivityManager.init(infrastructureApplication);

        ToolLib.getInstance().init(infrastructureApplication)
                .setBaseUrl(BASE_URL);

        registerActivityLifecycleCallbacks(new LifecycleCallbacks());

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
