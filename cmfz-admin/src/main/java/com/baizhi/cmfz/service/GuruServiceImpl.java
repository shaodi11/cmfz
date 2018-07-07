package com.baizhi.cmfz.service;

import com.baizhi.cmfz.dao.GuruDao;
import com.baizhi.cmfz.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Override
    @Transactional
    public boolean batchAddGuru(List<Guru> gurus) {
        int count=0;
        for (Guru g:gurus){
            guruDao.insertGuru(g);
            count++;
        }
        return gurus.size()==count;
    }
}
