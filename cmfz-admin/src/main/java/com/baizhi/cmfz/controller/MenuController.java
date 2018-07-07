package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 邵迪 on 2018/7/5.
 */
@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 菜单查询用以展示
     */
    @RequestMapping("/menu")
    public @ResponseBody List<Menu> showMenu(){

        //二级菜单
        List<Menu> menus = menuService.queryMenu();

        return menus;

    }


}
