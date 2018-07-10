package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.UserDao;
import com.baizhi.cmfz.entity.Statistics;
import com.baizhi.cmfz.entity.User;
import com.baizhi.cmfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 邵迪 on 2018/7/9.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(User user) {
        return 0;
    }

    /**
     * 查询地址对应的男用户信息（省份、使用人数）
     * @return
     */
    @Override
    public List<Statistics> queryManUser() {

        ArrayList<Statistics> statistics = new ArrayList<>();

        //获取省份的名称
        List<User> users = userDao.selectManUser();

        for (User user : users){
            Statistics s = new Statistics();
            s.setName(user.getUserAddress());
            s.setValue(userDao.countMen(user.getUserAddress()));
            statistics.add(s);
        }
        return statistics;
    }

    @Override
    public List<Statistics> queryWomanUser() {
        ArrayList<Statistics> statistics = new ArrayList<>();

        List<User> users = userDao.selectWomanUser();

        for (User user : users){
            Statistics s = new Statistics();
            s.setName(user.getUserAddress());
            s.setValue(userDao.countWomen(user.getUserAddress()));
            statistics.add(s);
        }
        return statistics;
    }
}
