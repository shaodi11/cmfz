package com.baizhi.cmfz.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by 邵迪 on 2018/7/4.
 */
@Component
public class Manager implements Serializable{

    private String managerId;           //管理员id
    private String managerName;         //管理员姓名
    private String managerPassword;     //管理员密码
    private String salt;                //管理员注册是的私盐
    private Integer managerStatus;      //管理员登录状态

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getManagerStatus() {
        return managerStatus;
    }

    public void setManagerStatus(Integer managerStatus) {
        this.managerStatus = managerStatus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerId='" + managerId + '\'' +
                ", managerName='" + managerName + '\'' +
                ", managerPassword='" + managerPassword + '\'' +
                ", salt='" + salt + '\'' +
                ", managerStatus=" + managerStatus +
                '}';
    }

    public Manager() {
    }

    public Manager(String managerId, String managerName, String managerPassword, String salt, Integer managerStatus) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.managerPassword = managerPassword;
        this.salt = salt;
        this.managerStatus = managerStatus;
    }
}
