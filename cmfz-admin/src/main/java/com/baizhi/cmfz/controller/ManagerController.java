package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.code.VerificationCodeType;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.*;

/**
 * Created by 邵迪 on 2018/7/4.
 */

@Controller
@SessionAttributes(value = {"code"})
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    /**
     * @Description 管理员的登录验证
     * @Author      邵迪
     * @Time        2018-07-04
     * @param manager   接收到的管理员信息
     * @param code      接收到的验证码
     * @param rememberMe  接收到的复选框记住密码的状态
     * @return
     */
    @RequestMapping("/login")
    public String loginManager(Manager manager, String code, boolean rememberMe, HttpServletRequest request ,HttpServletResponse response){
        HttpSession session = request.getSession();
        //从session中取出验证码的值，用以和前台传来的code做对比
        String realCode = (String) session.getAttribute("rcode");

        System.out.println("从session中取得的realcode："+realCode);
        System.out.println(code);

        //输入的code与session中取得的code作对比，值一致时，进行登录验证
        if (code!=null && realCode.equalsIgnoreCase(code)){
/*
            Manager realManager = managerService.queryManagerByName(manager);
            if (realManager != null){

                //登录验证成功，将登录的管理员账号存入到session中，以便后续用到
                session.setAttribute("manager",realManager);

*//*cookie 记住姓名实现， URLEncoder.encode乱码不能实现*//*
                if(remember != null ){  //记住用户

                    String userName =  realManager.getManagerName();
                    //将用户信息存至cookie中，用以记住用户名的实现，
                    String name = URLEncoder.encode(userName);

                    Cookie cookie = new Cookie("name",name);

                    // 设置cookie的有效期为7天，及访问cookie的路径，
                    cookie.setMaxAge(3600*24*7);
                    cookie.setPath("/cmfz-admin");

                    //发送cookie
                    response.addCookie(cookie);

                }else{      //取消记住密码

                    //获取到cookie数组
                    Cookie[] cookies = request.getCookies();

                    //遍历cookie数组，从中找到想要取消的cookie
                    for(Cookie cookie : cookies){
                        if(cookie.getName().equals("name")){

                            //将cookie的存活时间设置为0，销毁已存的cookie
                            cookie.setMaxAge(0);
                        }
                    }

                }

                return "forward:/main.jsp";
            }*/



            System.out.println("-----------------"+rememberMe+"----------------------");

            //在web环境中，安全管理器及其工厂的创建初始化，会在配置文件中被自动执行，
            //在代码的编程中，只需从securityUtil中获取主体对象,将主体对象放至令牌中，发送给自定义数据源，认证登录
            Subject subject = SecurityUtils.getSubject();

            try {
                UsernamePasswordToken token = new UsernamePasswordToken(manager.getManagerName(), manager.getManagerPassword(), rememberMe);
                subject.login(token);
                System.out.println(subject.hasRole("admin"));
                System.out.println("------认证成功-----");
                return "redirect:/main.jsp";
            } catch (AuthenticationException e) {
                System.out.println("------认证失败-----");
                e.printStackTrace();
            }


        }

        return "redirect:/login.jsp";
    }
    /**
     * @Description 登录时验证码的产生
     * @Author      邵迪
     * @Time        2018-07-04
     * @param       response 响应
     * @return
     */
    @RequestMapping("/getCode")
    public void getCode(HttpServletRequest request, HttpServletResponse response) throws Exception{



        VerificationCodeType code = new VerificationCodeType(150,40,4);//获得验证码

        System.out.println( code.getCode());
        //存入model
        HttpSession session = request.getSession();
        session.setAttribute("rcode", code.getCode());

        System.out.println("real验证码为："+session.getAttribute("rcode"));

        //以流的形式输出到页面上
        code.write(response.getOutputStream());

    }

}
