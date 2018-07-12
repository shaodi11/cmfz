package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by 邵迪 on 2018/7/5.
 */
@Service
public interface PermissionService {

    /**
     * @Description 用户认证后的角色授权
     * @Author      邵迪
     * @Time        2018-07-12
     * @Param       username 要查询角色的用户名
     */
    public List<Role> queryRole(String username);


    /**
     * @Description 用户认证后的资源权限
     * @Author      邵迪
     * @Time        2018-07-12
     * @Param       username 要查询角色的用户名
     */
    public List<Permission> queryPermission(String username);


}
