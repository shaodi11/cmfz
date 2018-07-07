package com.baizhi.cmfz.service;

import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 邵迪 on 2018/7/5.
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> queryMenu() {
        List<Menu> lists = null;

        List<Menu> menus = menuDao.selectMenu();

        if (menus != null){
            lists = menus;
        }

        return lists;
    }
}
