package com.example.infrastructure.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.example.infrastructure.R;
import com.example.infrastructure.data.AlarmInfo;
import com.example.infrastructure.data.GiveAnAlarmTypeEnum;
import com.example.toollib.base.BaseFragment;
import com.example.toollib.data.IBaseModule;

import butterknife.BindView;

public class RecordDetailFragment extends BaseFragment {

    private static AlarmInfo malarmInfo;
    @BindView(R.id.tvAlarmType)
    TextView tvAlarmType;
    @BindView(R.id.tvAlarmLevel)
    TextView tvAlarmLevel;
    @BindView(R.id.tvAlarmTime)
    TextView tvAlarmTime;
    @BindView(R.id.tvAlarmInfo3)
    TextView tvAlarmInfo3;
    @BindView(R.id.tvAlarmLocation)
    TextView tvAlarmLocation;
    @BindView(R.id.tvAlarmDevice)
    TextView tvAlarmDevice;
    @BindView(R.id.tvBelong)
    TextView tvBelong;
    @BindView(R.id.tvManger)
    TextView tvManger;
    @BindView(R.id.tvPhoneNumber)
    TextView tvPhoneNumber;

    public static RecordDetailFragment newInstance(AlarmInfo alarmInfo) {
        Bundle args = new Bundle();
        args.putSerializable("alarmInfo", alarmInfo);
        malarmInfo = (AlarmInfo) args.getSerializable("alarmInfo");
        RecordDetailFragment fragment = new RecordDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected IBaseModule initModule() {
        return null;
    }

    @Override
    public void initView() {
        statusBarWhite();
        int giveAnAlarmId = malarmInfo.getGiveAnAlarmId();
        int giveAlarmLevel = malarmInfo.getGiveAlarmLevel();
        if(giveAnAlarmId == GiveAnAlarmTypeEnum.SPEED_DIRECTION_TYPE_ID.getId()){
            tvAlarmType.setText(getString(R.string.alarm_tpye, "风速告警"));
        } else if(giveAnAlarmId == GiveAnAlarmTypeEnum.INCLINATION_SENSOR_TYPE_ID.getId()) {
            tvAlarmType.setText(getString(R.string.alarm_tpye, "倾角告警"));

        }  else if(giveAnAlarmId == GiveAnAlarmTypeEnum.UWB_TYPE_ID.getId()) {
            tvAlarmType.setText(getString(R.string.alarm_tpye, "电子围栏告警"));
        }   else if(giveAnAlarmId == GiveAnAlarmTypeEnum.PULL_DIRECTION_TYPE_ID.getId()) {
            tvAlarmType.setText(getString(R.string.alarm_tpye, "拉力告警"));
        }

        switch (giveAlarmLevel){
            case 4:
                tvAlarmLevel.setText(getString(R.string.alarm_level, "一级报警"));
                break;
            case 3:
                tvAlarmLevel.setText(getString(R.string.alarm_level, "二级报警"));
                break;
            case 2:
                tvAlarmLevel.setText(getString(R.string.alarm_level, "三级报警"));
                break;
            case 1:
                tvAlarmLevel.setText(getString(R.string.alarm_level, "四级报警"));
                break;
            default:
                break;
        }
        tvAlarmTime.setText(getString(R.string.alarm_time, malarmInfo.getGiveAlarmTime()));
        tvAlarmInfo3.setText(getString(R.string.alarm_info, malarmInfo.getGiveAlarmContent()));
        tvAlarmLocation.setText(getString(R.string.alarm_location, malarmInfo.getProjectAddress()));
        tvAlarmDevice.setText(getString(R.string.alarm_device, String.valueOf(malarmInfo.getAlarmEquipmentName())));
        tvBelong.setText(getString(R.string.alarm_belong, malarmInfo.getSceneName()));
        tvManger.setText(getString(R.string.alarm_manger, String.valueOf(malarmInfo.getId())));
        tvPhoneNumber.setText(getString(R.string.phone_num, String.valueOf(malarmInfo.getId())));
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_record_detail;
    }

    @Override
    protected String getActivityTitle() {
        return "告警详情";
    }

}
