package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Guru;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by 邵迪 on 2018/7/6.
 *
 * 上师的增删改查操作的dao
 */
@Repository
public interface GuruDao {
    /**
     * @Description 添加上师
     * @Author      邵迪
     * @Time        2018-07-06
     * @Param       参数为要添加的上师的基本信息
     */
    public int insertGuru(@Param("guru") Guru guru);


    /**
     * @Description 删除上师
     * @Author      邵迪
     * @Time        2018-07-06
     * @Param       参数为要删除的上师的id
     */
    public int deleteGuru(@Param("guruId") String guruId);


    /**
     * @Description 修改上师
     * @Author      邵迪
     * @Time        2018-07-06
     * @Param       参数为要修改的上师的基本信息
     */
    public int updateGuru(@Param("guru") Guru guru);


    /**
     * @Description 通过轮播图id查找上师
     * @Author      邵迪
     * @Time        2018-07-06
     * @Param       参数为前台传来的需要查询的上师id，返回一个轮播图
     */
    public Guru selectGuruById(@Param("guruId") String guruId);


    /**
     * @Description 分页展示上师信息
     * @Author      邵迪
     * @Time        2018-07-06
     * @Param       参数为前台传来的需要查询的上师首张图片的下标、每页展示的数目
     */
    public List<Guru> selectGuruPage(@Param("index") Integer index, @Param("pageSize") Integer pageSize);


    /**
     * 获得图片的总数量
     * @return
     */
    public int count();

    /**
     * @Description 通过名字的关键字，模糊查询出上师
     * @Author      邵迪
     * @Time        2018-07-06
     * @Param       参数为前台传来的需要查询的姓名关键字,及分页显示时的页数，和每页显示的个数
     *
     */
    public List<Guru> selectLikeGuru(@Param("name") String name ,@Param("index") Integer index, @Param("pageSize") Integer pageSize);

    /**
     * @Description 模糊查询时，用于分页展示的总数据条数
     * @Author      邵迪
     * @Time        2018-07-06
     * @Param       参数为前台传来的需要查询的姓名关键字,及分页显示时的页数，和每页显示的个数
     */
    public Integer likeGuruCount(@Param("name") String name);
}
