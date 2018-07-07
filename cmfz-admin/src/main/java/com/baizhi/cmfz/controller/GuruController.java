package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
     * 模糊查询上师
     * @param nowPage 当前页数
     * @param pageSize 每页显示的条数
     * @return
     */
    @RequestMapping("/guruPageShow")
    @ResponseBody
    public Map<String,Object> guruPageLikeShow(@RequestParam("guruName") String guruName ,@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize){
        Map<String,Object> map = guruService.queryLikeGuru(guruName,nowPage,pageSize);
        return map;
    }


}
