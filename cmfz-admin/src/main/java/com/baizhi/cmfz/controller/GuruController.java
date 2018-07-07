package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import com.baizhi.cmfz.util.UUIDGenerator;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.params.ExcelExportEntity;
import org.jeecgframework.poi.excel.entity.vo.MapExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

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
     * 导出excel表格，整体将上师信息导出
     *
     */


    @RequestMapping("/exportExcel")
    public String exportExcel(HttpServletResponse response, HttpServletRequest request, ModelMap modelMap) throws IOException {

        //excel里的各个标题，对应实体上师类里的属性
        List<ExcelExportEntity> entityList = new ArrayList<ExcelExportEntity>();

        //new excel实体类，为每个所需的标题，并用其当做map的key
        entityList.add(new ExcelExportEntity("上师编号", "guruId", 25));
        entityList.add(new ExcelExportEntity("上师法名", "guruName", 25));
        entityList.add(new ExcelExportEntity("上师简介", "guruIntroduction", 25));

        //excel内容,用map存储每一行的信息，即实体类信息，再将多个map存入到list中，即将多个实体类依次放在了excel的每一行里
        List<Map<String,Object>> dataResult = new ArrayList<Map<String,Object>>();

        //查询所有上师
        Map<String, Object> mapGuru = guruService.queryGuruPage(1, 100);
        List<Guru> gurus = (List<Guru>) mapGuru.get("rows");

        //遍历上师信息，将其存入到map中
        for (Guru g:gurus) {
            Map<String, Object> map = new HashMap<>();
            map.put("guruId", g.getGuruId());
            map.put("guruName", g.getGuruName());
            map.put("guruIntroduction", g.getGuruIntroduction());
            dataResult.add(map);
        }

        //将表格的内容及标题存入到modelMap中
        modelMap.put(MapExcelConstants.ENTITY_LIST, entityList);
        modelMap.put(MapExcelConstants.MAP_LIST, dataResult);
        String fileName = "上师基本信息表";

        modelMap.put(MapExcelConstants.FILE_NAME, fileName);
        modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("上师基本信息表","创建时间"+new Date().toLocaleString(),"上师"));

        return MapExcelConstants.JEECG_MAP_EXCEL_VIEW;
    }



    /**
     * 导入excel表格，批量插入上师信息
     * @return
     * @throws
     */
    @RequestMapping("/importExcel")
    @ResponseBody
    public String importExcel(MultipartFile fileExcel, HttpServletRequest request){
        //判断文件是否为Excel表格
        String fileName = fileExcel.getOriginalFilename();
        String suffixFileName=fileName.substring(fileName.lastIndexOf("."));
        if (!(suffixFileName.equals(".xls")||suffixFileName.equals("xlsx"))){
            return "no";//上传的不是excel文件，无法解析
        }

        try {
            ImportParams params = new ImportParams();
            params.setTitleRows(2);//标题占有的行数
            params.setHeadRows(1);//字段占有的行数
            List<Guru> list = ExcelImportUtil.importExcel( fileExcel.getInputStream(), Guru.class, params);
            System.out.println(list);
            if (list!=null&&guruService.batchAddGuru(list)){
                return "ok";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "no";
    }

}
