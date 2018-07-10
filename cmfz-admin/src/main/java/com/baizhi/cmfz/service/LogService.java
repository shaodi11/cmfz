package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Log;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * Created by 邵迪 on 2018/7/5.
 */
@Service
public interface LogService {

    /**
     * @Description 添加log
     * @Author      邵迪
     * @Time        2018-07-09
     * @Param       参数为要添加的log的基本信息
     */
    public int addLog(Log log);

    /**
     * @Description 分页展示log
     * @Author      邵迪
     * @Time        2018-07-09
     * @Param       参数为要添加的log的基本信息
     */
    public Map<String,Object> queryPageLog(Integer index , Integer pageSize);

}
