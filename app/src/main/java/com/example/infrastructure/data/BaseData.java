package com.example.infrastructure.data;

public class BaseData<T> {

    /**
     * content : {"cardId":76886,"cardX":3.9454,"cardY":0.72907,"cardZ":0,"equipmentCoding":"33010101","floorId":1,"recServerTime":1610272150,"setGatewayCode":"33010210","staticStartTime":1610255180,"time":1610272149369}
     * topic : 1
     */

    private T content;
    private int topic;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public int getTopic() {
        return topic;
    }

    public void setTopic(int topic) {
        this.topic = topic;
    }

}
