package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 邵迪 on 2018/7/12.
 */
public interface PermissionDao {

    /**
     * @Description 用户认证后的角色授权
     * @Author      邵迪
     * @Time        2018-07-12
     * @Param       username 要查询角色的用户名
     */
    public List<Role> selectRole(@Param("username") String username);


    /**
     * @Description 用户认证后的资源权限
     * @Author      邵迪
     * @Time        2018-07-12
     * @Param       username 要查询角色的用户名
     */
    public List<Permission> selectPermission(@Param("username") String username);



}
