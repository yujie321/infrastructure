package com.example.infrastructure.data;

import java.util.List;

public class Project {


    /**
     * id : 2
     * companyName : 建设分公司
     * projectManagementList : [{"id":2,"projectName":"马庄~王家峰11kV线路工程","engineeringCode":"33010210","projectTypeName":"变电工程","companyName":"建设分公司","startTime":"2020-01-04 09:39:00","projectAddress":"浙江省杭州市余杭区未来科技城","cameraList":[{"id":1,"cameraName":"摄像机2","cameraCode":"33010210","projectManagementName":null,"cameraTypeName":null,"ip":"127.0.0.1","port":8081,"isOffLine":0}]}]
     */

    private int id;
    private String companyName;
    private List<ProjectManagement> projectManagementList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<ProjectManagement> getProjectManagementList() {
        return projectManagementList;
    }

    public void setProjectManagementList(List<ProjectManagement> projectManagementList) {
        this.projectManagementList = projectManagementList;
    }

}
