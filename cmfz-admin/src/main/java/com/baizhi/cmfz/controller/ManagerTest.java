package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Manager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 邵迪 on 2018/7/11.
 */
@Controller
public class ManagerTest {

    /**
     * 登录认证
     *
     * @return
     */
    @RequestMapping("/loginTest")
    public String loginTest(Manager manager,boolean rememberMe){



        System.out.println("-----------------"+rememberMe+"----------------------");

        //在web环境中，安全管理器及其工厂的创建初始化，会在配置文件中被自动执行，
        //在代码的编程中，只需从securityUtil中获取主体对象,将主体对象放至令牌中，发送给自定义数据源，认证登录
        Subject subject = SecurityUtils.getSubject();

        try {
            UsernamePasswordToken token = new UsernamePasswordToken(manager.getManagerName(), manager.getManagerPassword(), rememberMe);
            subject.login(token);
            System.out.println("------认证成功-----");
            return "redirect:/main.jsp";
        } catch (AuthenticationException e) {
            System.out.println("------认证失败-----");
            e.printStackTrace();
        }

        return "redirect:/login.jsp";

    }

}
