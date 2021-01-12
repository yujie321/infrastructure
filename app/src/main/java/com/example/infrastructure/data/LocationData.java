package com.example.infrastructure.data;

public class LocationData {
    /**
     * cardId : 76886
     * cardX : 3.9454
     * cardY : 0.72907
     * cardZ : 0
     * equipmentCoding : 33010101
     * floorId : 1
     * recServerTime : 1610272150
     * setGatewayCode : 33010210
     * staticStartTime : 1610255180
     * time : 1610272149369
     */

    private int cardId;
    private double cardX;
    private double cardY;
    private int cardZ;
    private String equipmentCoding;
    private int floorId;
    private int recServerTime;
    private String setGatewayCode;
    private int staticStartTime;
    private long time;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public double getCardX() {
        return cardX;
    }

    public void setCardX(double cardX) {
        this.cardX = cardX;
    }

    public double getCardY() {
        return cardY;
    }

    public void setCardY(double cardY) {
        this.cardY = cardY;
    }

    public int getCardZ() {
        return cardZ;
    }

    public void setCardZ(int cardZ) {
        this.cardZ = cardZ;
    }

    public String getEquipmentCoding() {
        return equipmentCoding;
    }

    public void setEquipmentCoding(String equipmentCoding) {
        this.equipmentCoding = equipmentCoding;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getRecServerTime() {
        return recServerTime;
    }

    public void setRecServerTime(int recServerTime) {
        this.recServerTime = recServerTime;
    }

    public String getSetGatewayCode() {
        return setGatewayCode;
    }

    public void setSetGatewayCode(String setGatewayCode) {
        this.setGatewayCode = setGatewayCode;
    }

    public int getStaticStartTime() {
        return staticStartTime;
    }

    public void setStaticStartTime(int staticStartTime) {
        this.staticStartTime = staticStartTime;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
