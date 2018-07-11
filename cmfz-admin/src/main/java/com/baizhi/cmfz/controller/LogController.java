package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;

/**
 * Created by 邵迪 on 2018/7/9.
 */

@Controller
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 日志展示
     * @throws Exception
     */
    @RequestMapping("/logPageShow")
    @ResponseBody
    public Map<String,Object> logPageShow(@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize){

        return logService.queryPageLog(nowPage,pageSize);

    }

}
