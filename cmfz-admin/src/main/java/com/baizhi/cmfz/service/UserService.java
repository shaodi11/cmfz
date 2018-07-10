package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Statistics;
import com.baizhi.cmfz.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by 邵迪 on 2018/7/5.
 */
@Service
public interface UserService {

    /**
     * @Description 添加上师
     * @Author      邵迪
     * @Time        2018-07-06
     * @Param       参数为要添加的上师的基本信息
     */
    public int addUser(User user);


    /**
     * @Description 查询男用户
     * @Author      邵迪
     * @Time        2018-07-09
     */
    public List<Statistics> queryManUser();

    /**
     * @Description 查询女用户
     * @Author      邵迪
     * @Time        2018-07-09
     */
    public List<Statistics> queryWomanUser();
}
