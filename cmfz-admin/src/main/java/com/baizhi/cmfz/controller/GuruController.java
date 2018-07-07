package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import com.baizhi.cmfz.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;

/**
 * Created by 邵迪 on 2018/7/5.
 */

@Controller
public class GuruController {

    @Autowired
    private GuruService guruService;

    /**
     * 分页展示上师
     * @param nowPage 当前页数
     * @param pageSize 每页显示的条数
     * @return
     */
    @RequestMapping("/guruPageShow")
    @ResponseBody
    public Map<String,Object> guruPageShow(@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize){
        Map<String,Object> map = guruService.queryGuruPage(nowPage,pageSize);
        return map;
    }

    /**
     * 新增上师
     * @param myFile  上传的头像文件
     * @param  guru 接收到的上师基本信息
     * @return
     */
    @RequestMapping("/registGuru")
    @ResponseBody
    public String registGuru(MultipartFile myFile , HttpServletRequest request , Guru guru) throws Exception{

        //获得当前所在目录的绝对路径
        String path = request.getSession().getServletContext().getRealPath("\\");

        int index = path.lastIndexOf("\\");

        //上传文件的路径
        String pathFile = path.substring(0,index-11)+"/upload";

        //oldName 是文件上传时的名字
        String oldName = myFile.getOriginalFilename();

        //文件名唯一性 优化
        String uuid = UUIDGenerator.getUUID();

        //文件存储的真实路径,将id号和传来的文件名组合成上传到文件目录的新名字，同时也将其当做路径名用于后面取出图片做展示
        String realPath = uuid+oldName;

        //文件写入到指定文件内
        myFile.transferTo(new File(pathFile+"/"+uuid+oldName));

        //给定新增上师的ID编号和头像存储路径
        guru.setGuruId(uuid);
        guru.setGuruPic(realPath);

        int result = guruService.addGuru(guru);
        if (result>0){
            return "ok";
        }
        return "no";
    }


    /**
     * 修改上师信息
     * @param myFile 新上传的头像文件
     * @param  guru 接收到的修改后上师基本信息
     * @return
     */
    @RequestMapping("/modifyGuru")
    @ResponseBody
    public String modifyGuru(MultipartFile myFile , HttpServletRequest request , Guru guru) throws Exception{

        //获得当前所在目录的绝对路径
        String path = request.getSession().getServletContext().getRealPath("\\");

        int index = path.lastIndexOf("\\");

        //上传文件的路径
        String pathFile = path.substring(0,index-11)+"/upload";

        //oldName 是文件上传时的名字
        String oldName = myFile.getOriginalFilename();

        //文件名唯一性 优化
        String uuid = UUIDGenerator.getUUID();

        //文件存储的真实路径,将id号和传来的文件名组合成上传到文件目录的新名字，同时也将其当做路径名用于后面取出图片做展示
        String realPath = uuid+oldName;

        //文件写入到指定文件内
        myFile.transferTo(new File(pathFile+"/"+uuid+oldName));

        //给定新增上师的ID编号和头像存储路径
        guru.setGuruPic(realPath);

        int result = guruService.modifyGuru(guru);
        if (result>0){
            return "ok";
        }
        return "no";
    }



    /**
     * 模糊查询上师
     * @param nowPage 当前页数
     * @param pageSize 每页显示的条数
     * @return
     */

    @RequestMapping("/guruPageLikeShow")
    @ResponseBody
    public Map<String,Object> guruPageLikeShow(@RequestParam("guruName") String guruName ,@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize){

        System.out.println("模糊查询的关键字"+guruName);

        Map<String,Object> map = guruService.queryLikeGuru(guruName,nowPage,pageSize);
        return map;
    }

    /**
     * 上传excel表格，批量导入上师信息
     * @param file 上传来的excel表格文件
     * @param request
     */
    public void importExcel(MultipartFile file,HttpServletRequest request){

        try {

        }catch (Exception e){

        }

    }




}
