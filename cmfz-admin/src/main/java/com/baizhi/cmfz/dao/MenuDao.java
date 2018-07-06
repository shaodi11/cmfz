package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Menu;


import java.util.List;

/**
 * Created by 邵迪 on 2018/7/5.
 */
public interface MenuDao {


    /**
     * 查询所有菜单（包括一级二级）
     * @return
     */
    public List<Menu> selectMenu();

}
