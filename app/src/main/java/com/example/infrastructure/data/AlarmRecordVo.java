package com.example.infrastructure.data;

public class AlarmRecordVo {
    private String alarmType;
    private String alarmTime;
    private String alarmLevel;
    private String alarmInfo;
    private String alarmLocation;

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public String getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(String alarmTime) {
        this.alarmTime = alarmTime;
    }

    public String getAlarmLevel() {
        return alarmLevel;
    }

    public void setAlarmLevel(String alarmLevel) {
        this.alarmLevel = alarmLevel;
    }

    public String getAlarmInfo() {
        return alarmInfo;
    }

    public void setAlarmInfo(String alarmInfo) {
        this.alarmInfo = alarmInfo;
    }

    public String getAlarmLocation() {
        return alarmLocation;
    }

    public void setAlarmLocation(String alarmLocation) {
        this.alarmLocation = alarmLocation;
    }
}
