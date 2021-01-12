package com.example.infrastructure.data;

public class WindData {

    /**
     * gatewayCode : 33010210
     * speedDirectionId : 2
     * code : DD100001
     * threshold : 10.0
     * windDirection : 67.5
     * windDirectionName : 东东北风
     * windSpeed : 0.0
     * windSpeedName : 无风
     * voltage : 2.96
     * alarmTotal : 2204
     * isAlarm : 16
     * createTime : 2021-01-11 15:41:27
     */

    private String gatewayCode;
    private int speedDirectionId;
    private String code;
    private double threshold;
    private double windDirection;
    private String windDirectionName;
    private double windSpeed;
    private String windSpeedName;
    private double voltage;
    private int alarmTotal;
    private int isAlarm;
    private String createTime;

    public String getGatewayCode() {
        return gatewayCode;
    }

    public void setGatewayCode(String gatewayCode) {
        this.gatewayCode = gatewayCode;
    }

    public int getSpeedDirectionId() {
        return speedDirectionId;
    }

    public void setSpeedDirectionId(int speedDirectionId) {
        this.speedDirectionId = speedDirectionId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    public String getWindDirectionName() {
        return windDirectionName;
    }

    public void setWindDirectionName(String windDirectionName) {
        this.windDirectionName = windDirectionName;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindSpeedName() {
        return windSpeedName;
    }

    public void setWindSpeedName(String windSpeedName) {
        this.windSpeedName = windSpeedName;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public int getAlarmTotal() {
        return alarmTotal;
    }

    public void setAlarmTotal(int alarmTotal) {
        this.alarmTotal = alarmTotal;
    }

    public int getIsAlarm() {
        return isAlarm;
    }

    public void setIsAlarm(int isAlarm) {
        this.isAlarm = isAlarm;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
