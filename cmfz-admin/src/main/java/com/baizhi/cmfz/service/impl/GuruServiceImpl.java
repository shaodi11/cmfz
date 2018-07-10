package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.GuruDao;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 邵迪 on 2018/7/6.
 */
@Service
@Transactional
public class GuruServiceImpl implements GuruService {

    @Autowired
    private GuruDao guruDao;

    @Override
    public int addGuru(Guru guru) {
        int result = 0;
        int res = guruDao.insertGuru(guru);
        if (res>0){
            result = res ;
        }
        return result;
    }

    @Override
    public int removeGuru(String guruId) {
        return 0;
    }

    @Override
    public int modifyGuru(Guru guru) {
        int result = 0;
        int res = guruDao.updateGuru(guru);
        if (res>0){
            result = res ;
        }
        return result;
    }

    @Override
    @Transactional
    public Guru queryGuruById(String guruId) {

        Guru guru = new Guru();

        Guru g = guruDao.selectGuruById(guruId);

        if (g != null){
            guru = g;
        }
        return guru;
    }

    @Override
    @Transactional
    public Map<String, Object> queryGuruPage(Integer index, Integer pageSize) {

        Map<String, Object> map = new HashMap<String, Object>();

        List<Guru> gurus = guruDao.selectGuruPage((index - 1)*pageSize, pageSize);

        int count = guruDao.count();

        map.put("rows",gurus);
        map.put("total",count);

        return map;
    }

    @Override
    @Transactional
    public Map<String,Object> queryLikeGuru(String name, Integer index, Integer pageSize) {

        Map<String, Object> map = new HashMap<>();

        String queryName = "%"+name+"%";

        List<Guru> gurus = guruDao.selectLikeGuru(queryName, (index - 1) * pageSize, pageSize);

        Integer count = guruDao.likeGuruCount(queryName);

        map.put("total",count);
        map.put("rows",gurus);

        return map;
    }

    /**
     * 文件批量导入，调用insertGuru方法，多次插入数据
     * @param gurus
     * @return
     */
    @Override
    @Transactional
    public boolean batchAddGuru(List<Guru> gurus) {
        //count用于记录插入的总条数
        int count=0;
        for (Guru g:gurus){
            guruDao.insertGuru(g);
            count++;
        }
        //当总条数和传来的gurus的长度相同时，返回true，反之返回false
        return gurus.size()==count;
    }


    /**
     * @Description 分页展示上师信息
     * @Author      邵迪
     * @return      用于将查询结果放至添加文章页面的上师选择处
     */
    @Override
    @Transactional
    public List<Guru> queryGuruAll(){
        return guruDao.selectGuruAll();
    }
}
