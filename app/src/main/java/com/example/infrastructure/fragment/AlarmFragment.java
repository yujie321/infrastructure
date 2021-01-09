package com.example.infrastructure.fragment;

import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.infrastructure.R;
import com.example.infrastructure.adapter.AlarmRecordAdapter;
import com.example.infrastructure.data.AlarmRecordVo;
import com.example.toollib.base.BaseListFragment;
import com.example.toollib.data.IBaseModule;

import java.util.ArrayList;
import java.util.List;

/**
 * 告警
 */
public class AlarmFragment extends BaseListFragment {
    private AlarmRecordAdapter alarmRecordAdapter;

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
        List<AlarmRecordVo> alarmRecordVoList = new ArrayList<>();
        AlarmRecordVo alarmRecordVo = new AlarmRecordVo();
        alarmRecordVo.setAlarmType("Dsdsdsd");
        alarmRecordVo.setAlarmTime("Dsdsdsd");
        alarmRecordVo.setAlarmInfo("Dsdsdsd");
        alarmRecordVo.setAlarmLocation("Dsdsdsd");
        alarmRecordVoList.add(alarmRecordVo);
        alarmRecordAdapter.setList(alarmRecordVoList);
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
    public AlarmRecordAdapter getBaseListAdapter() {
        alarmRecordAdapter = new AlarmRecordAdapter();
        return alarmRecordAdapter;
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        AlarmRecordVo alarmRecordVo = (AlarmRecordVo) view.findViewById(R.id.tvAlarmInfo).getTag();
        startFragment(RecordDetailFragment.newInstance());
    }

    @Override
    public boolean isCustomView() {
        return false;
    }
}
