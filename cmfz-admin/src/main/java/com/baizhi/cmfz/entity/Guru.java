package com.baizhi.cmfz.entity;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 邵迪 on 2018/7/5.
 */
@Component
public class Guru implements Serializable {
    //上传文件时，为了使其辨认实体类属性
    @Excel(name="上师编号")
    private String guruId ;

    @Excel(name="上师法名")
    private String guruName ;

    private String guruPic ;

    @Excel(name="上师简介")
    private String guruIntroduction ;

    public Guru() {
    }

    public Guru(String guruId, String guruName, String guruPic, String guruIntroduction) {
        this.guruId = guruId;
        this.guruName = guruName;
        this.guruPic = guruPic;
        this.guruIntroduction = guruIntroduction;
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    public String getGuruName() {
        return guruName;
    }

    public void setGuruName(String guruName) {
        this.guruName = guruName;
    }

    public String getGuruPic() {
        return guruPic;
    }

    public void setGuruPic(String guruPic) {
        this.guruPic = guruPic;
    }

    public String getGuruIntroduction() {
        return guruIntroduction;
    }

    public void setGuruIntroduction(String guruIntroduction) {
        this.guruIntroduction = guruIntroduction;
    }

    @Override
    public String toString() {
        return "Grur{" +
                "guruId='" + guruId + '\'' +
                ", guruName='" + guruName + '\'' +
                ", guruPic='" + guruPic + '\'' +
                ", guruIntroduction='" + guruIntroduction + '\'' +
                '}';
    }
}
