package com.baizhi.cmfz.service.impl;


import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 邵迪 on 2018/7/4.
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;

    @Override
    public int addManager(Manager manager) {
        return 0;
    }

    /**
     * 管理员登录验证
     * @param manager 参数为前台传来的需要查询的账号信息，看能否返回一个管理员
     * @return 空 或 一个已存在的管理员
     */
    @Override
    @Transactional()
    public Manager queryManagerByName(Manager manager) {
        Manager man = null;

        Manager realManager = managerDao.selectManagerByName(manager);

        if(realManager != null){
            String realPwd = realManager.getManagerPassword();
            String  salt = realManager.getSalt();
            String pwd = MD5.getMD5String(manager.getManagerPassword() + salt);
            if (pwd.equals(realPwd)){
                man = realManager;
            }
        }
        return man;
    }
}
