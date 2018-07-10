package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by 邵迪 on 2018/7/6.
 *
 * 轮播图的增删改查操作的dao
 */
public interface UserDao {
    /**
     * @Description 添加用户
     * @Author      邵迪
     * @Time        2018-07-09
     * @Param       参数为要添加的用户的基本信息
     */
    public int insertUser(@Param("user") User user);

    /**
     * @Description 查询男用户
     * @Author      邵迪
     * @Time        2018-07-09
     */
    public List<User> selectManUser();

    public int countMen(@Param("address") String address);

    /**
     * @Description 查询女用户
     * @Author      邵迪
     * @Time        2018-07-09
     */
    public List<User> selectWomanUser();

    public int countWomen(@Param("address") String address);



}
