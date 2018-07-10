package com.baizhi.cmfz.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 邵迪 on 2018/7/5.
 */
@Component
public class User implements Serializable {

    private String userId;
    private String userName;
    private String userBuddhishName;
    private String userPassword;
    private String userSex;
    private String userHeadPic;
    private String userAddress;
    private String userPhone;
    private String userSignature;
    private String userStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date userDate;

    public User() {
    }

    public User(String userId, String userName, String userBuddhishName, String userPassword, String userSex, String userHeadPic, String userAddress, String userPhone, String userSignature, String userStatus, Date userDate) {
        this.userId = userId;
        this.userName = userName;
        this.userBuddhishName = userBuddhishName;
        this.userPassword = userPassword;
        this.userSex = userSex;
        this.userHeadPic = userHeadPic;
        this.userAddress = userAddress;
        this.userPhone = userPhone;
        this.userSignature = userSignature;
        this.userStatus = userStatus;
        this.userDate = userDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserBuddhishName() {
        return userBuddhishName;
    }

    public void setUserBuddhishName(String userBuddhishName) {
        this.userBuddhishName = userBuddhishName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserHeadPic() {
        return userHeadPic;
    }

    public void setUserHeadPic(String userHeadPic) {
        this.userHeadPic = userHeadPic;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Date getUserDate() {
        return userDate;
    }

    public void setUserDate(Date userDate) {
        this.userDate = userDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userBuddhishName='" + userBuddhishName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userHeadPic='" + userHeadPic + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userSignature='" + userSignature + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userDate=" + userDate +
                '}';
    }
}
