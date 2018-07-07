package com.baizhi.cmfz.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 邵迪 on 2018/7/5.
 */
@Component
public class Picture implements Serializable {
    private String pictureId ;
    private String pictureName ;
    private String picturePath ;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pictureDate ;
    private String pictureDescription ;
    private String pictureStatus ;

    public Picture() {
    }

    public Picture(String pictureName, String picturePath, Date pictureDate, String pictureDescription, String pictureStatus) {
        this.pictureName = pictureName;
        this.picturePath = picturePath;
        this.pictureDate = pictureDate;
        this.pictureDescription = pictureDescription;
        this.pictureStatus = pictureStatus;
    }


    public Picture(String pictureId, String pictureName, String picturePath, Date pictureDate, String pictureDescription, String pictureStatus) {
        this.pictureId = pictureId;
        this.pictureName = pictureName;
        this.picturePath = picturePath;
        this.pictureDate = pictureDate;
        this.pictureDescription = pictureDescription;
        this.pictureStatus = pictureStatus;
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public Date getPictureDate() {
        return pictureDate;
    }

    public void setPictureDate(Date pictureDate) {
        this.pictureDate = pictureDate;
    }

    public String getPictureDescription() {
        return pictureDescription;
    }

    public void setPictureDescription(String pictureDescription) {
        this.pictureDescription = pictureDescription;
    }

    public String getPictureStatus() {
        return pictureStatus;
    }

    public void setPictureStatus(String pictureStatus) {
        this.pictureStatus = pictureStatus;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "pictureId='" + pictureId + '\'' +
                ", pictureName='" + pictureName + '\'' +
                ", picturePath='" + picturePath + '\'' +
                ", pictureDate=" + pictureDate +
                ", pictureDescription='" + pictureDescription + '\'' +
                ", pictureStatus='" + pictureStatus + '\'' +
                '}';
    }
}
