package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.PermissionDao;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 邵迪 on 2018/7/12.
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;


    @Override
    public List<Role> queryRole(String username) {
        return permissionDao.selectRole(username);
    }

    @Override
    public List<Permission> queryPermission(String username) {
        return permissionDao.selectPermission(username);
    }
}
