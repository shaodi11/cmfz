package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.entity.RichTextResult;
import com.baizhi.cmfz.service.ArticleService;
import com.baizhi.cmfz.service.PictureService;
import com.baizhi.cmfz.util.UUIDGenerator;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Created by 邵迪 on 2018/7/5.
 */

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 添加轮播图
     * @throws Exception
     */
    @RequestMapping("/registArticle")
    @ResponseBody
    public String registPic(Article article){

        System.out.println(article);

        //开始插入文章
        article.setArticleId(UUIDGenerator.getUUID());
        article.setArticleDate(new Date());

        int result = articleService.addArticle(article);
        if (result>0){
            return "ok";
        }
        return "no";

    }


    /**
     * 文章图片的上传
     * @throws Exception
     */
    @RequestMapping("/upload")
    @ResponseBody
    public RichTextResult picUpload(@RequestParam("files") MultipartFile[] files, HttpServletRequest request){
        RichTextResult result = new RichTextResult();
        ArrayList<String> data = new ArrayList<>();
        try {
            String realPath = request.getRealPath("");
            String uploadPath = realPath.substring(0,realPath.lastIndexOf("\\"))+"\\articlePic";
            if(files != null && files.length != 0){
                for (MultipartFile file : files) {
                    String fileName = UUIDGenerator.getUUID()+"."+ FilenameUtils.getExtension(file.getOriginalFilename());
                    // 将上传的文件转存到服务器中存储
                    file.transferTo(new File(uploadPath+"\\"+fileName));

                    // 将上传的图片在服务器的url响应给客户端  图片回显
                    data.add(request.getContextPath()+"/articlePic/"+fileName);
                }
            }
            result.setErrno(0);
            result.setData(data);
        } catch (Exception e) {
            result.setErrno(1);
            e.printStackTrace();
        }
        return result;
    }

}
