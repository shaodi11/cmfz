package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.entity.Statistics;
import com.baizhi.cmfz.service.GuruService;
import com.baizhi.cmfz.service.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 统计图上显示某一地区的男用户个数
     * @return
     */
    @RequestMapping("/userManShow")
    @ResponseBody
    public List<Statistics> userManShow(){

        List<Statistics> statistics = userService.queryManUser();

        return statistics;
    }


    /**
     * 统计图上显示某一地区的女用户个数
     * @return
     */
    @RequestMapping("/userWomanShow")
    @ResponseBody
        public List<Statistics> userWomanShow(){

        List<Statistics> statistics = userService.queryWomanUser();

        return statistics;
    }





}
