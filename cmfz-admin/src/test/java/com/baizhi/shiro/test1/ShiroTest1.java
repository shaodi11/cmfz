package com.baizhi.shiro.test1;

/**
 * Created by 邵迪 on 2018/7/10.
 */

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * shiro 基本练习
 */
public class ShiroTest1 {

   /* public static void main(String[] args) {
        //shiro认证  基础认证步骤

        //1.初始化基于ini配置文件的安全管理器工厂
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro1.ini");

        //2.通过安全管理器工厂，创建安全管理器
        SecurityManager securityManager = iniSecurityManagerFactory.createInstance();

        //3.对安全管理器初始化
        SecurityUtils.setSecurityManager(securityManager);

        //4.获取当前访问系统的主体对象
        Subject subject = SecurityUtils.getSubject();

        //5.主体认证 token = 身份信息 + 凭证信息
        AuthenticationToken token = new UsernamePasswordToken("zs", "123456");

        try {
            subject.login(token);
            System.out.println("认证成功！");
        } catch (AuthenticationException e) {
            System.out.println("认证失败！");
            e.printStackTrace();
        }

        subject.logout();
    }
*/


    public static void main(String[] args) {

        //1.创建安全管理器工厂，通过ini配置文件
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro1.ini");

        //2、创建安全管理器
        SecurityManager instance = iniSecurityManagerFactory.createInstance();

        //3、通过SecurityUtils类，对安全管理器初始化
        SecurityUtils.setSecurityManager(instance);

        //4.通过SecurityUtils类,获取当前访问的主体，即要验证的对象
        Subject subject = SecurityUtils.getSubject();

        //主体的令牌 token = username + userpassword
        AuthenticationToken zs = new UsernamePasswordToken("zs", "123456");

        //5.进行主体认证

        try {
            subject.login(zs);
            System.out.println("ok!");
        } catch (AuthenticationException e) {
            System.out.println("no!");
            e.printStackTrace();
        }

        subject.logout();
    }
}
