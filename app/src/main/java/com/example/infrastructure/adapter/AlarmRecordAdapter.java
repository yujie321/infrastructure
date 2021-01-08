package com.example.infrastructure.adapter;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.infrastructure.R;
import com.example.infrastructure.data.AlarmRecordVo;

import org.jetbrains.annotations.NotNull;

public class AlarmRecordAdapter extends BaseQuickAdapter<AlarmRecordVo, BaseViewHolder> implements LoadMoreModule {
    public AlarmRecordAdapter() {
        super(R.layout.item_alarmrecord, null);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, AlarmRecordVo alarmRecordVo) {
        TextView tvAlarmType = baseViewHolder.getView(R.id.tvAlarmType);
        TextView tvAlarmTime = baseViewHolder.getView(R.id.tvAlarmTime);
        TextView tvAlarmInfo = baseViewHolder.getView(R.id.tvAlarmInfo);
        TextView tvAlarmLocation = baseViewHolder.getView(R.id.tvAlarmLocation);

        tvAlarmType.setText(alarmRecordVo.getAlarmType());
        tvAlarmTime.setText(alarmRecordVo.getAlarmTime());
        tvAlarmInfo.setText(alarmRecordVo.getAlarmInfo());
        tvAlarmLocation.setText(alarmRecordVo.getAlarmLocation());
    }
}
