package com.baizhi.shiro.test3;

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
public class ShiroTest3 {

    public static void main(String[] args) {
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro3.ini");

        SecurityManager securityManager = iniSecurityManagerFactory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        AuthenticationToken token = new UsernamePasswordToken("zs", "123456");

        try {
            subject.login(token);
            System.out.println("ok");
        } catch (AuthenticationException e) {
            System.out.println("no");
            e.printStackTrace();
        }

        subject.logout();

    }
}