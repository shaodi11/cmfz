package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Guru;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 邵迪 on 2018/7/5.
 */
@Service
public interface GuruService {

    /**
     * @Description 添加上师
     * @Author      邵迪
     * @Time        2018-07-06
     * @Param       参数为要添加的上师的基本信息
     */
    public int addGuru(Guru guru);


    /**
     * @Description 删除上师
     * @Author      邵迪
     * @Time        2018-07-06
     * @Param       参数为要删除的上师的id
     */

    public int removeGuru(String guruId);

    /**
     * @Description 修改上师
     * @Author      邵迪
     * @Time        2018-07-06
     * @Param       参数为要修改的上师的基本信息
     */

    public int modifyGuru(Guru guru);

    /**
     * @Description 通过轮播图id查找上师
     * @Author      邵迪
     * @Time        2018-07-06
     * @Param       参数为前台传来的需要查询的上师id，返回一个上师
     */

    public Guru queryGuruById(String guruId);

    /**
     * @Description 分页展示上师信息
     * @Author      邵迪
     * @Time        2018-07-06
     * @Param       参数为前台传来的需要查询的上师首张图片的下标、每页展示的数目
     */
    public Map<String,Object> queryGuruPage(Integer index, Integer pageSize);

    /**
     * @Description 通过名字的关键字，模糊查询出上师
     * @Author      邵迪
     * @Time        2018-07-06
     * @Param       参数为前台传来的需要查询的姓名关键字,及分页显示时的页数，和每页显示的个数
     *
     */
    public Map<String,Object> queryLikeGuru(String name , Integer index , Integer pageSize);

    boolean batchAddGuru(List<Guru> gurus);
}
