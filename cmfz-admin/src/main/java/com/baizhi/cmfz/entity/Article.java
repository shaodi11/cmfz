package com.baizhi.cmfz.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 邵迪 on 2018/7/8.
 */
@Component
public class Article implements Serializable{

    private String articleId ;
    private String articleTitle;
    private String articleName ;
    private String articleIntroduction ;
    private String articleStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date articleDate ;

    public Article() {
    }

    public Article(String articleId, String articleTitle, String articleName, String articleIntroduction, String articleStatus, Date articleDate) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleName = articleName;
        this.articleIntroduction = articleIntroduction;
        this.articleStatus = articleStatus;
        this.articleDate = articleDate;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleIntroduction() {
        return articleIntroduction;
    }

    public void setArticleIntroduction(String articleIntroduction) {
        this.articleIntroduction = articleIntroduction;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleName='" + articleName + '\'' +
                ", articleIntroduction='" + articleIntroduction + '\'' +
                ", articleStatus='" + articleStatus + '\'' +
                ", articleDate=" + articleDate +
                '}';
    }
}
