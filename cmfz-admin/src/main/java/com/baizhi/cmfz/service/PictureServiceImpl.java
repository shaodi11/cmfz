package com.baizhi.cmfz.service;

import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Picture;
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
public class PictureServiceImpl implements PictureService{

    @Autowired
    private PictureDao pictureDao;

    @Override
    public int addPicture(Picture picture) {
        int n = 0;
        int i = pictureDao.insertPicture(picture);
        if (i>0){
            n = i ;
        }
        return n;
    }

    @Override
    public int removePicture(String pictureId) {
        int n = 0;
        int i = pictureDao.deletePicture(pictureId);
        if (i>0){
            n = i ;
        }
        return n;
    }

    @Override
    public int modifyPicture(Picture picture) {
        int n = 0;
        int i = pictureDao.updatePicture(picture);
        if (i>0){
            n = i ;
        }
        return n;
    }

    @Override
    public Picture queryPictureById(String pictureId) {
        Picture p = new Picture();
        Picture picture = pictureDao.selectPictureById(pictureId);
        if (picture != null){
            p = picture;
        }
        return p;
    }

    @Override
    @Transactional
    public Map<String,Object> queryPicturePage(Integer index, Integer pageSize) {

        Map<String,Object> pictures = new HashMap<String,Object>();

        List<Picture> list = pictureDao.selectPicturePage(index, pageSize);

        Integer count = pictureDao.count();

        pictures.put("total",count);

        pictures.put("rows",list);

        return pictures;
    }

}
