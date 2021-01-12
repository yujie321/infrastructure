package com.example.infrastructure.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.infrastructure.R;
import com.example.infrastructure.data.AlarmInfo;
import com.example.infrastructure.data.GiveAnAlarmTypeEnum;


import org.jetbrains.annotations.NotNull;

public class AlarmAdapter extends BaseQuickAdapter<AlarmInfo, BaseViewHolder> implements LoadMoreModule {
    public AlarmAdapter() {
        super(R.layout.item_alarmrecord, null);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, AlarmInfo alarmInfo) {
        ImageView imgAlarmType = baseViewHolder.getView(R.id.imgAlarmType);
        TextView tvAlarmInfo = baseViewHolder.getView(R.id.tvAlarmInfo);
        TextView tvAlarmLocation = baseViewHolder.getView(R.id.tvAlarmLocation);
        ImageView imgAlarmLevel = baseViewHolder.getView(R.id.imgAlarmLevel);
        TextView tvAlarmType = baseViewHolder.getView(R.id.tvAlarmType);
        TextView tvAlarmTime = baseViewHolder.getView(R.id.tvAlarmTime);

        int giveAnAlarmId = alarmInfo.getGiveAnAlarmId();
        int giveAlarmLevel = alarmInfo.getGiveAlarmLevel();
        if(giveAnAlarmId == GiveAnAlarmTypeEnum.SPEED_DIRECTION_TYPE_ID.getId()){
            switch (giveAlarmLevel){
                case 4:
                    imgAlarmType.setImageResource(R.mipmap.ic_windlevel1);
                    break;
                case 3:
                    imgAlarmType.setImageResource(R.mipmap.ic_windlevel2);
                    break;
                case 2:
                    imgAlarmType.setImageResource(R.mipmap.ic_windlevel3);
                    break;
                case 1:
                    imgAlarmType.setImageResource(R.mipmap.ic_windlevel4);
                    break;
                default:
                    break;
            }
        } else if(giveAnAlarmId == GiveAnAlarmTypeEnum.UWB_TYPE_ID.getId()) {
            switch (giveAlarmLevel){
                case 4:
                    imgAlarmType.setImageResource(R.mipmap.ic_pulllevel1);
                    break;
                case 3:
                    imgAlarmType.setImageResource(R.mipmap.ic_pulllevel2);
                    break;
                case 2:
                    imgAlarmType.setImageResource(R.mipmap.ic_pulllevel3);
                    break;
                case 1:
                    imgAlarmType.setImageResource(R.mipmap.ic_pulllevel4);
                    break;
                default:
                    break;
            }
        }  else if(giveAnAlarmId == GiveAnAlarmTypeEnum.INCLINATION_SENSOR_TYPE_ID.getId()) {
            switch (giveAlarmLevel){
                case 4:
                    imgAlarmType.setImageResource(R.mipmap.ic_anglelevel1);
                    break;
                case 3:
                    imgAlarmType.setImageResource(R.mipmap.ic_anglelevel2);
                    break;
                case 2:
                    imgAlarmType.setImageResource(R.mipmap.ic_anglelevel3);
                    break;
                case 1:
                    imgAlarmType.setImageResource(R.mipmap.ic_anglelevel4);
                    break;
                default:
                    break;
            }
        }   else if(giveAnAlarmId == GiveAnAlarmTypeEnum.PULL_DIRECTION_TYPE_ID.getId()) {
            switch (giveAlarmLevel){
                case 4:
                    imgAlarmType.setImageResource(R.mipmap.ic_pulllevel1);
                    break;
                case 3:
                    imgAlarmType.setImageResource(R.mipmap.ic_pulllevel2);
                    break;
                case 2:
                    imgAlarmType.setImageResource(R.mipmap.ic_pulllevel3);
                    break;
                case 1:
                    imgAlarmType.setImageResource(R.mipmap.ic_pulllevel4);
                    break;
                default:
                    break;
            }
        }

        switch (giveAlarmLevel){
            case 4:
                imgAlarmLevel.setImageResource(R.mipmap.ic_alarmlevel1);
                break;
            case 3:
                imgAlarmLevel.setImageResource(R.mipmap.ic_alarmlevel2);
                break;
            case 2:
                imgAlarmLevel.setImageResource(R.mipmap.ic_alarmlevel3);
                break;
            case 1:
                imgAlarmLevel.setImageResource(R.mipmap.ic_alarmlevel4);
                break;
            default:
                break;
        }

        tvAlarmInfo.setText(alarmInfo.getGiveAlarmContent());
        tvAlarmLocation.setText(alarmInfo.getProjectAddress());
        tvAlarmType.setText(alarmInfo.getAlarmEquipmentName());
        tvAlarmTime.setText(alarmInfo.getGiveAlarmTime());

    }
}
