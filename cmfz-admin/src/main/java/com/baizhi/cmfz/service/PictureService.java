package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Picture;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * Created by 邵迪 on 2018/7/5.
 */
@Service
public interface PictureService {

    /**
     * @Description 添加轮播图
     * @Author      邵迪
     * @Time        2018-07-05
     * @Param       参数为要添加的轮播图的基本信息
     */
    public int addPicture(Picture picture);


    /**
     * @Description 删除轮播图
     * @Author      邵迪
     * @Time        2018-07-05
     * @Param       参数为要删除的轮播图的id
     */

    public int removePicture(String pictureId);

    /**
     * @Description 修改轮播图
     * @Author      邵迪
     * @Time        2018-07-05
     * @Param       参数为要修改的轮播图的基本信息
     */

    public int modifyPicture(Picture picture);

    /**
     * @Description 通过轮播图id查找轮播图
     * @Author      邵迪
     * @Time        2018-07-05
     * @Param       参数为前台传来的需要查询的轮播图id，返回一个轮播图
     */

    public Picture queryPictureById(String pictureId);

    /**
     * @Description 分页展示轮播图信息
     * @Author      邵迪
     * @Time        2018-07-05
     * @Param       参数为前台传来的需要查询的轮播图首张图片的下标、每页展示的数目
     */
    public Map<String,Object> queryPicturePage(Integer index , Integer pageSize);



}
