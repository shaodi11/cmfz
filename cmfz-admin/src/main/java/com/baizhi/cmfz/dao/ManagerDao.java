package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 邵迪 on 2018/7/4.
 *
 * 管理员的增删改查操作的dao
 */
public interface ManagerDao {
    /**
     * @Description 添加管理员
     * @Author      邵迪
     * @Time        2018-07-04
     * @Param       参数为要添加的管理员的基本信息
     */
    public int insertManager(@Param("manager") Manager manager);


    /**
     * @Description 通过管理员名字查找管理员
     * @Author      邵迪
     * @Time        2018-07-04
     * @Param       参数为前台传来的需要查询的账号信息，看能否返回一个管理员
     */
    public Manager selectManagerByName(@Param("manager") Manager manager);
}
