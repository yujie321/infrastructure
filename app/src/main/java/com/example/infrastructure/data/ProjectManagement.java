package com.example.infrastructure.data;

public class ProjectManagement {

    /**
     * id : 2
     * projectName : 马庄~王家峰11kV线路工程
     * engineeringCode : 33010210
     * projectTypeName : 变电工程
     * companyName : 建设分公司
     * startTime : 2020-01-04 09:39:00
     * projectAddress : 浙江省杭州市余杭区未来科技城
     */

    private int id;
    private String projectName;
    private String engineeringCode;
    private String projectTypeName;
    private String companyName;
    private String startTime;
    private String projectAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getEngineeringCode() {
        return engineeringCode;
    }

    public void setEngineeringCode(String engineeringCode) {
        this.engineeringCode = engineeringCode;
    }

    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
    }

}
