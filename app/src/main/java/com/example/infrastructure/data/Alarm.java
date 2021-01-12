package com.example.infrastructure.data;

import java.util.List;

public class Alarm {
    /**
     * pageNum : 1
     * pageSize : 20
     * size : 20
     * startRow : 1
     * endRow : 20
     * total : 2184
     * pages : 110
     * list : [{"id":1,"giveAnAlarmId":3,"gatewayCode":"33010210","nameType":"1","alarmEquipmentName":"倾角传感器","code":"2003056003","giveAlarmLevel":2,"giveAlarmContent":"y轴角度大于预警值12.05","giveAlarmTime":"2021-01-06 16:38:35"},{"id":2,"giveAnAlarmId":2,"gatewayCode":"33010210","nameType":"1","alarmEquipmentName":"风速风向传感器","code":"DD100001","giveAlarmLevel":1,"giveAlarmContent":"设备：DD100001风速>预警值 1.62","giveAlarmTime":"2021-01-07 10:10:21"},{"id":3,"giveAnAlarmId":3,"gatewayCode":"33010210","nameType":"1","alarmEquipmentName":"倾角传感器","code":"2003056003","giveAlarmLevel":2,"giveAlarmContent":"y轴角度大于预警值6.76","giveAlarmTime":"2021-01-07 10:10:57"},{"id":4,"giveAnAlarmId":2,"gatewayCode":"33010210","nameType":"1","alarmEquipmentName":"风速风向传感器","code":"DD100001","giveAlarmLevel":1,"giveAlarmContent":"设备：DD100001风速>预警值 1.49","giveAlarmTime":"2021-01-07 10:11:47"},{"id":5,"giveAnAlarmId":2,"gatewayCode":"33010210","nameType":"1","alarmEquipmentName":"风速风向传感器","code":"DD100001","giveAlarmLevel":1,"giveAlarmContent":"设备：DD100001风速>预警值 1.09","giveAlarmTime":"2021-01-07 10:54:46"},{"id":6,"giveAnAlarmId":2,"gatewayCode":"33010210","nameType":"1","alarmEquipmentName":"风速风向传感器","code":"DD100001","giveAlarmLevel":1,"giveAlarmContent":"设备：DD100001风速>预警值 0.50","giveAlarmTime":"2021-01-07 10:55:03"},{"id":7,"giveAnAlarmId":3,"gatewayCode":"33010210","nameType":"1","alarmEquipmentName":"倾角传感器","code":"2003056003","giveAlarmLevel":2,"giveAlarmContent":"y轴角度大于预警值11.21","giveAlarmTime":"2021-01-07 10:55:15"},{"id":8,"giveAnAlarmId":3,"gatewayCode":"33010210","nameType":"1","alarmEquipmentName":"倾角传感器","code":"2003056003","giveAlarmLevel":2,"giveAlarmContent":"y轴角度大于预警值10.07","giveAlarmTime":"2021-01-09 15:31:41"},{"id":9,"giveAnAlarmId":3,"gatewayCode":"33010210","nameType":"1","alarmEquipmentName":"倾角传感器","code":"2003056003","giveAlarmLevel":2,"giveAlarmContent":"y轴角度大于预警值11.64","giveAlarmTime":"2021-01-09 15:32:11"},{"id":10,"giveAnAlarmId":3,"gatewayCode":"33010210","nameType":"1","alarmEquipmentName":"倾角传感器","code":"2003056003","giveAlarmLevel":2,"giveAlarmContent":"y轴角度大于预警值9.35","giveAlarmTime":"2021-01-09 15:47:51"},{"id":11,"giveAnAlarmId":2,"gatewayCode":"33010210","nameType":"2","alarmEquipmentName":"风速风向传感器","code":"DD100001","giveAlarmLevel":3,"giveAlarmContent":"设备：DD100001电压异常 电压：2.99","giveAlarmTime":"2021-01-09 19:41:11"},{"id":12,"giveAnAlarmId":2,"gatewayCode":"33010210","nameType":"2","alarmEquipmentName":"风速风向传感器","code":"DD100001","giveAlarmLevel":3,"giveAlarmContent":"设备：DD100001电压异常 电压：2.99","giveAlarmTime":"2021-01-09 19:41:28"},{"id":13,"giveAnAlarmId":2,"gatewayCode":"33010210","nameType":"2","alarmEquipmentName":"风速风向传感器","code":"DD100001","giveAlarmLevel":3,"giveAlarmContent":"设备：DD100001电压异常 电压：2.99","giveAlarmTime":"2021-01-09 19:41:46"},{"id":14,"giveAnAlarmId":2,"gatewayCode":"33010210","nameType":"2","alarmEquipmentName":"风速风向传感器","code":"DD100001","giveAlarmLevel":3,"giveAlarmContent":"设备：DD100001电压异常 电压：2.99","giveAlarmTime":"2021-01-09 19:42:03"},{"id":15,"giveAnAlarmId":2,"gatewayCode":"33010210","nameType":"2","alarmEquipmentName":"风速风向传感器","code":"DD100001","giveAlarmLevel":3,"giveAlarmContent":"设备：DD100001电压异常 电压：2.99","giveAlarmTime":"2021-01-09 19:42:20"},{"id":16,"giveAnAlarmId":2,"gatewayCode":"33010210","nameType":"2","alarmEquipmentName":"风速风向传感器","code":"DD100001","giveAlarmLevel":3,"giveAlarmContent":"设备：DD100001电压异常 电压：2.99","giveAlarmTime":"2021-01-09 19:42:37"},{"id":17,"giveAnAlarmId":2,"gatewayCode":"33010210","nameType":"2","alarmEquipmentName":"风速风向传感器","code":"DD100001","giveAlarmLevel":3,"giveAlarmContent":"设备：DD100001电压异常 电压：2.99","giveAlarmTime":"2021-01-09 19:43:12"},{"id":18,"giveAnAlarmId":2,"gatewayCode":"33010210","nameType":"2","alarmEquipmentName":"风速风向传感器","code":"DD100001","giveAlarmLevel":3,"giveAlarmContent":"设备：DD100001电压异常 电压：2.99","giveAlarmTime":"2021-01-09 19:43:29"},{"id":19,"giveAnAlarmId":2,"gatewayCode":"33010210","nameType":"2","alarmEquipmentName":"风速风向传感器","code":"DD100001","giveAlarmLevel":3,"giveAlarmContent":"设备：DD100001电压异常 电压：2.99","giveAlarmTime":"2021-01-09 19:43:46"},{"id":20,"giveAnAlarmId":2,"gatewayCode":"33010210","nameType":"2","alarmEquipmentName":"风速风向传感器","code":"DD100001","giveAlarmLevel":3,"giveAlarmContent":"设备：DD100001电压异常 电压：2.99","giveAlarmTime":"2021-01-09 19:44:03"}]
     * prePage : 0
     * nextPage : 2
     * isFirstPage : true
     * isLastPage : false
     * hasPreviousPage : false
     * hasNextPage : true
     * navigatePages : 8
     * navigatepageNums : [1,2,3,4,5,6,7,8]
     * navigateFirstPage : 1
     * navigateLastPage : 8
     * lastPage : 8
     * firstPage : 1
     */

    private int pageNum;
    private int pageSize;
    private int size;
    private int startRow;
    private int endRow;
    private int total;
    private int pages;
    private int prePage;
    private int nextPage;
    private boolean isFirstPage;
    private boolean isLastPage;
    private boolean hasPreviousPage;
    private boolean hasNextPage;
    private int navigatePages;
    private int navigateFirstPage;
    private int navigateLastPage;
    private int lastPage;
    private int firstPage;
    private List<AlarmInfo> list;
    private List<Integer> navigatepageNums;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public boolean isIsFirstPage() {
        return isFirstPage;
    }

    public void setIsFirstPage(boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
    }

    public boolean isIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    public int getNavigateFirstPage() {
        return navigateFirstPage;
    }

    public void setNavigateFirstPage(int navigateFirstPage) {
        this.navigateFirstPage = navigateFirstPage;
    }

    public int getNavigateLastPage() {
        return navigateLastPage;
    }

    public void setNavigateLastPage(int navigateLastPage) {
        this.navigateLastPage = navigateLastPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public List<AlarmInfo> getList() {
        return list;
    }

    public void setList(List<AlarmInfo> list) {
        this.list = list;
    }

    public List<Integer> getNavigatepageNums() {
        return navigatepageNums;
    }

    public void setNavigatepageNums(List<Integer> navigatepageNums) {
        this.navigatepageNums = navigatepageNums;
    }

}
