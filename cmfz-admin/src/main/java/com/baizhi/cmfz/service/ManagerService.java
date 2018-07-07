package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Manager;
import org.springframework.stereotype.Service;


/**
 * Created by 邵迪 on 2018/7/4.
 */
@Service
public interface ManagerService {

    /**
     * @Description 添加管理员
     * @Author      邵迪
     * @Time        2018-07-04
     * @Param       参数为要添加的管理员的基本信息
     */
    public int addManager(Manager manager);


    /**
     * @Description 通过管理员名字查找管理员
     * @Author      邵迪
     * @Time        2018-07-04
     * @Param       参数为前台传来的需要查询的账号信息，看能否返回一个管理员
     */
    public Manager queryManagerByName(Manager manager);
}
