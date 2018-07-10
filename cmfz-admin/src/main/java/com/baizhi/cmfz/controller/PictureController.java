package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import com.baizhi.cmfz.util.UUIDGenerator;
import org.apache.commons.io.FilenameUtils;
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
        String realPath = request.getRealPath("");

        //上传文件的路径
        String uploadPath = realPath.substring(0,realPath.lastIndexOf("\\"))+"\\upload";

        //oldName 是文件上传时的名字
        String oldName = myFile.getOriginalFilename();

        //文件名唯一性 优化
        String uuid = UUIDGenerator.getUUID();  //图片的别名，并且充当图片的id

        //文件存储的真实路径,将id号和传来的文件名组合成上传到文件目录的新名字，以防图片名相同会被覆盖掉，同时也将其当做路径名用于后面取出图片做展示
        String fileName = uuid +"."+ oldName;

        //文件写入到指定文件内
        myFile.transferTo(new File(uploadPath+"\\"+fileName));

        //将上传来的轮播图信息放至数据库
        Picture picture = new Picture(uuid, oldName, fileName, new Date(), pictureDescription, "未展示");
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
