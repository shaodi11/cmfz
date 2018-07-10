package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Article;
import org.springframework.stereotype.Service;


/**
 * Created by 邵迪 on 2018/7/5.
 */
@Service
public interface ArticleService {

    /**
     * @Description 添加文章
     * @Author      邵迪
     * @Time        2018-07-09
     * @Param       参数为要添加的文章的基本信息
     */
    public int addArticle(Article article);



}
