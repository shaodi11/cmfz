package com.baizhi.cmfz.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 邵迪 on 2018/7/5.
 */
@Component
public class Menu implements Serializable {
    private String menuId ;
    private String menuName ;
    private String menuCode ;
    private String menuIcon ;
    private String menuURL ;
    private String menuLevel ;

    private List<Menu> menuList;

    public Menu() {
    }

    public Menu(String menuId, String menuName, String menuCode, String menuIcon, String menuURL, String menuLevel, List<Menu> menuList) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuCode = menuCode;
        this.menuIcon = menuIcon;
        this.menuURL = menuURL;
        this.menuLevel = menuLevel;
        this.menuList = menuList;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuURL() {
        return menuURL;
    }

    public void setMenuURL(String menuURL) {
        this.menuURL = menuURL;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId='" + menuId + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuCode='" + menuCode + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuURL='" + menuURL + '\'' +
                ", menuLevel='" + menuLevel + '\'' +
                ", menuList=" + menuList +
                '}';
    }
}
