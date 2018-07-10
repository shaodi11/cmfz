package com.baizhi.cmfz.service;

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 邵迪 on 2018/7/9.
 */
@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    /**
     * 添加log
     * @param log 要存入log的对象
     * @return
     */
    @Override
    public int addLog(Log log) {

        int result = 0;

        int i = logDao.insertLog(log);

        if (i>0){
            result = i;
        }
        return result;
    }

    /**
     * log分页显示
     *
     */
    public Map<String,Object> queryPageLog( Integer index,Integer pageSize){
        Map<String,Object> map = new HashMap<String,Object>();

        int total = logDao.countLog();

        List<Log> rows = logDao.selectPageLog((index - 1) * pageSize, pageSize);

        map.put("total",total);
        map.put("rows",rows);

        return map;
    }


}
