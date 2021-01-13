package com.example.infrastructure.fragment;

import android.os.Bundle;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.infrastructure.R;
import com.example.infrastructure.adapter.AlarmAdapter;
import com.example.infrastructure.data.Alarm;
import com.example.infrastructure.data.AlarmInfo;
import com.example.infrastructure.http.ServiceUrl;
import com.example.toollib.base.BaseListFragment;
import com.example.toollib.data.IBaseModule;
import com.example.toollib.enums.StaticExplain;
import com.example.toollib.http.exception.ApiException;
import com.example.toollib.http.observer.BaseHttpRxObserver;
import com.example.toollib.http.util.RxUtils;
import com.example.toollib.util.Log;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * 告警
 */
public class AlarmFragment extends BaseListFragment {
    private AlarmAdapter alarmAdapter;

    public static AlarmFragment newInstance() {

        Bundle args = new Bundle();

        AlarmFragment fragment = new AlarmFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected IBaseModule initModule() {
        return null;
    }

    @Override
    public void initView() {
        super.initView();
        EventBus.getDefault().register(this);
    }

    private void getAlarmInfo() {
        RxUtils.getObservable(ServiceUrl.getUserApi().getAllAlarmInfo(getPage(), StaticExplain.PAGE_NUM.getCode()))
                .subscribe(new BaseHttpRxObserver<Alarm>() {
                    @Override
                    protected void onSuccess(Alarm alarm) {
                        if (alarm == null) {
                            alarm = new Alarm();
                        }
                        List<AlarmInfo> list = alarm.getList();
                        if (getPage() == StaticExplain.PAGE_NUMBER.getCode()) {
                            //刷新
                            setAlarmInfo(alarm);
                            finishRefresh();
                        } else {
                            //加载
                            loadMoreSecure(alarm);
                        }
                        if (list.size() < StaticExplain.PAGE_NUM.getCode()) {
                            //加载结束
                            loadMoreEnd();
                        } else {
                            //加载完成
                            loadMoreComplete();
                        }
                    }

                    @Override
                    public void onError(ApiException apiException) {
                        super.onError(apiException);
                        finishRefresh();
                        loadError();
                    }
                });
    }

    private void setAlarmInfo(Alarm alarm) {
        if (alarm.getList().size() != 0) {
            alarmAdapter.setList(alarm.getList());
        }
    }

    private void loadMoreSecure(Alarm alarm) {
        alarmAdapter.addData(alarm.getList());
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_alarm;
    }

    @Override
    protected String getActivityTitle() {
        return null;
    }

    @Override
    public AlarmAdapter getBaseListAdapter() {
        alarmAdapter = new AlarmAdapter();
        return alarmAdapter;
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

        AlarmInfo alarmInfo = (AlarmInfo) adapter.getData().get(position);
        startFragment(RecordDetailFragment.newInstance(alarmInfo));
    }

    @Override
    public boolean isCustomView() {
        return false;
    }

    @Override
    public void onBaseRefresh(RefreshLayout refreshLayout) {
        getAlarmInfo();
    }

    @Override
    public void onBaseLoadMoreRequested() {
        getAlarmInfo();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvents(String msg) {
        JSONObject obj = JSON.parseObject(msg);
        Integer topic = obj.getInteger("topic");
        if (topic == 2) {
            getAlarmInfo();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
