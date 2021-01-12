package com.example.infrastructure.data;

public class AngleData {

    /**
     * gatewayCode : 33010210
     * inclinationSensorId : 1
     * code : 2003056003
     * threshold : 3
     * xAngle : -0.1132
     * yAngle : 0.8578
     * temperature : 29.67
     * voltage : 3.4
     * isAlarm : 0
     * alarmTotal : 7
     * createTime : 2021-01-11 15:36:55
     */

    private String gatewayCode;
    private int inclinationSensorId;
    private String code;
    private int threshold;
    private double xAngle;
    private double yAngle;
    private double temperature;
    private double voltage;
    private int isAlarm;
    private int alarmTotal;
    private String createTime;

    public String getGatewayCode() {
        return gatewayCode;
    }

    public void setGatewayCode(String gatewayCode) {
        this.gatewayCode = gatewayCode;
    }

    public int getInclinationSensorId() {
        return inclinationSensorId;
    }

    public void setInclinationSensorId(int inclinationSensorId) {
        this.inclinationSensorId = inclinationSensorId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public double getXAngle() {
        return xAngle;
    }

    public void setXAngle(double xAngle) {
        this.xAngle = xAngle;
    }

    public double getYAngle() {
        return yAngle;
    }

    public void setYAngle(double yAngle) {
        this.yAngle = yAngle;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public int getIsAlarm() {
        return isAlarm;
    }

    public void setIsAlarm(int isAlarm) {
        this.isAlarm = isAlarm;
    }

    public int getAlarmTotal() {
        return alarmTotal;
    }

    public void setAlarmTotal(int alarmTotal) {
        this.alarmTotal = alarmTotal;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
