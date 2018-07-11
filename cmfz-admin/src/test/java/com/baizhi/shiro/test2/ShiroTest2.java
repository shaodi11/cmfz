/*
package com.baizhi.shiro.test2;

*/
/**
 * Created by 邵迪 on 2018/7/10.
 *//*


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

*/
/**
 * shiro 基本练习
 *//*

public class ShiroTest2 {

    public static void main(String[] args) {

        //通过数据库查出数据源的验证：
        //1.通过ini配置文件，创建安全管理器工厂，
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro2.ini");

        //2.通过安全器工厂创建，安全管理器
        SecurityManager instance = iniSecurityManagerFactory.createInstance();

        //3.SecurityUtils类创建，初始化安全器
        SecurityUtils.setSecurityManager(instance);

        //4.获取要验证的主体对象
        Subject subject = SecurityUtils.getSubject();

        //5.获取令牌 token = username + password
        AuthenticationToken token = new UsernamePasswordToken("zs","123456");

        //主体对象（携带含有用户登录信息的令牌）进行登录验证
        try {
            subject.login(token);
            System.out.println("ok!");
        } catch (AuthenticationException e) {
            System.out.println("no");
            e.printStackTrace();
        }

        //登出方法
        subject.logout();
    }
}*/
