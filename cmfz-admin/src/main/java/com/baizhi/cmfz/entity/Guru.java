package com.baizhi.cmfz.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 邵迪 on 2018/7/5.
 */
@Component
public class Guru implements Serializable {
    private String guruId ;
    private String guruName ;
    private String guruPic ;
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
