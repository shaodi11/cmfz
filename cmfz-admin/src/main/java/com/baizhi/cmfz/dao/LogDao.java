package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by 邵迪 on 2018/7/6.
 *
 * 日志的增的dao
 */
public interface LogDao {
    /**
     * @Description 添加日志
     * @Author      邵迪
     * @Time        2018-07-09
     * @Param       参数为要添加的日志的基本信息
     */
    public int insertLog(@Param("log") Log log);

    /**
     * @Description 分页展示日志
     * @Author      邵迪
     * @Time        2018-07-09
     */
    public List<Log> selectPageLog(@Param("index") Integer index, @Param("pageSize") Integer pageSize);

    public int countLog();
}
