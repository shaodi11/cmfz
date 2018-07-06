package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import com.baizhi.cmfz.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.Map;

/**
 * Created by 邵迪 on 2018/7/5.
 */

@Controller
public class PictureController {

    @Autowired
    private PictureService pictureService;

    /**
     * 分页展示picture
     * @param nowPage 当前页数
     * @param pageSize 每页显示的条数
     * @return
     */
    @RequestMapping("/pageshow")
    @ResponseBody
    public Map<String,Object> picturesPageShow(@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize){
        Map<String,Object> map = pictureService.queryPicturePage((nowPage-1)*pageSize,pageSize);
        return map;
    }

    /**
     * 添加轮播图
     * @param myFile
     * @param request
     * @param pictureDescription
     * @throws Exception
     */
    @RequestMapping("/registpic")
    @ResponseBody
    public String registPic(MultipartFile myFile , HttpServletRequest request ,String pictureDescription) throws Exception{

        //获得当前所在目录的绝对路径
        String path = request.getSession().getServletContext().getRealPath("\\");

        int index = path.lastIndexOf("\\");

        //上传文件的路径
        String pathFile = path.substring(0,index-11);

        //oldName 是文件上传时的名字
        String oldName = myFile.getOriginalFilename();
        System.out.println("文件上传时的名字:"+oldName);


        //文件名唯一性 优化
        String uuid = UUIDGenerator.getUUID();

        //文件存储的真实路径,将id号和传来的文件名组合成上传到文件目录的新名字，同时也将其当做路径名用于后面取出图片做展示
        String realPath = uuid+oldName;
        System.out.println("当前目录之前的路径(文件存储的真实路径):"+realPath);


        //文件写入到指定文件内
        myFile.transferTo(new File(pathFile+"/"+uuid+oldName));

        //将上传来的轮播图信息放至数据库
        Picture picture = new Picture(uuid, oldName, realPath, new Date(), pictureDescription, "未展示");
        int result = pictureService.addPicture(picture);
        if (result>0){
            return "ok";
        }
        return "no";

    }

    /**
     * 删除轮播图
     * @param pictureId 要删除的轮播图id
     * @return
     */
    @RequestMapping("/remove")
    @ResponseBody
    public String removePic(String pictureId){
        int result = pictureService.removePicture(pictureId);
        if (result>0){
            return "ok";
        }
        return "no";
    }

 /*   *//**
     * 修改pic之前先查询出来要修改的pic基本信息显示到页面上
     * @return
     *//*
    @RequestMapping("/modifyPicQuery")
    @ResponseBody
    public String modifyPicQuery(String pictureId, Model model){

        Picture p = pictureService.queryPictureById(pictureId);

        if (p != null){

            model.addAttribute("modifyPicture",p);

            return "ok";
        }
        return "no";
    }*/


    /**
     * 修改轮播图
     * @return
     */
    @RequestMapping("/modifyPic")
    @ResponseBody
    public String modifyPic(Picture picture){
        System.out.println("要删除的pic"+picture);
        int result = pictureService.modifyPicture(picture);
        if (result>0){
            return "ok";
        }
        return "no";

    }
}
