package com.example.infrastructure.data;

import java.io.Serializable;

public class AlarmInfo implements Serializable {
    /**
     * alarmEquipmentName : string
     * code : string
     * gatewayCode : string
     * giveAlarmContent : string
     * giveAlarmLevel : 0
     * giveAlarmTime : 2021-01-10T05:57:43.584Z
     * giveAnAlarmId : 0
     * id : 0
     * nameType : string
     */

    private String alarmEquipmentName;
    private String code;
    private String gatewayCode;
    private String giveAlarmContent;
    private int giveAlarmLevel;
    private String giveAlarmTime;
    private int giveAnAlarmId;
    private int id;
    private String nameType;
    /**
     * sceneName : 马庄~王家峰11kV线路工程
     * projectAddress : 浙江省杭州市余杭区未来科技城
     */

    private String sceneName;
    private String projectAddress;

    public String getAlarmEquipmentName() {
        return alarmEquipmentName;
    }

    public void setAlarmEquipmentName(String alarmEquipmentName) {
        this.alarmEquipmentName = alarmEquipmentName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGatewayCode() {
        return gatewayCode;
    }

    public void setGatewayCode(String gatewayCode) {
        this.gatewayCode = gatewayCode;
    }

    public String getGiveAlarmContent() {
        return giveAlarmContent;
    }

    public void setGiveAlarmContent(String giveAlarmContent) {
        this.giveAlarmContent = giveAlarmContent;
    }

    public int getGiveAlarmLevel() {
        return giveAlarmLevel;
    }

    public void setGiveAlarmLevel(int giveAlarmLevel) {
        this.giveAlarmLevel = giveAlarmLevel;
    }

    public String getGiveAlarmTime() {
        return giveAlarmTime;
    }

    public void setGiveAlarmTime(String giveAlarmTime) {
        this.giveAlarmTime = giveAlarmTime;
    }

    public int getGiveAnAlarmId() {
        return giveAnAlarmId;
    }

    public void setGiveAnAlarmId(int giveAnAlarmId) {
        this.giveAnAlarmId = giveAnAlarmId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
    }
}
