package com.example.infrastructure.data;

public class BaseStation {

    /**
     * base_station_y : 0
     * base_station_x : 0
     * base_station_z : 0.75
     * base_station_id : 3678
     * network_id : 1
     * subnet_id : 1
     * online : 1
     * sn : G02D090002
     */

    private double base_station_y;
    private double base_station_x;
    private double base_station_z;
    private int base_station_id;
    private int network_id;
    private int subnet_id;
    private int online;
    private String sn;

    public double getBase_station_y() {
        return base_station_y;
    }

    public void setBase_station_y(int base_station_y) {
        this.base_station_y = base_station_y;
    }

    public double getBase_station_x() {
        return base_station_x;
    }

    public void setBase_station_x(int base_station_x) {
        this.base_station_x = base_station_x;
    }

    public double getBase_station_z() {
        return base_station_z;
    }

    public void setBase_station_z(double base_station_z) {
        this.base_station_z = base_station_z;
    }

    public int getBase_station_id() {
        return base_station_id;
    }

    public void setBase_station_id(int base_station_id) {
        this.base_station_id = base_station_id;
    }

    public int getNetwork_id() {
        return network_id;
    }

    public void setNetwork_id(int network_id) {
        this.network_id = network_id;
    }

    public int getSubnet_id() {
        return subnet_id;
    }

    public void setSubnet_id(int subnet_id) {
        this.subnet_id = subnet_id;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }
}
