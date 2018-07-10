package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;


/**
 * Created by 邵迪 on 2018/7/6.
 *
 * 轮播图的增删改查操作的dao
 */
public interface ArticleDao {
    /**
     * @Description 添加文章
     * @Author      邵迪
     * @Time        2018-07-09
     * @Param       参数为要添加的文章的基本信息
     */
    public int insertArticle(@Param("article") Article article);


}
