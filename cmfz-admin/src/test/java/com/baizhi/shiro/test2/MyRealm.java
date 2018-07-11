package com.baizhi.shiro.test2;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;

import java.util.UUID;

/**
 *
 * 自定义数据源类
 *
 * 要验证的数据并配写死在配置文件中，而是从数据库中查得
 *
 * Created by 邵迪 on 2018/7/10.
 */


/*

public class MyRealm extends AuthenticatingRealm{
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //将令牌转换成U色人那么PasswordToken类型的
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;

        //获取token中的用户名
        String tokenUsername = upToken.getUsername();

        //判断用户给到的验证信息是否正确
        if ("zs".equals(tokenUsername)){

    //从数据库中查到的用户信息后：

            // 将用户信息封装到指定的返回值中
            // 参数一：代表从数据库中查询到需要封装的用户身份信息
            // 参数二：代表从数据库中查询到需要封装的用户凭证信息
            // 参数三：标识唯一的数据源类
            // new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), UUID.randomUUID().toString());

            return new SimpleAuthenticationInfo("zs","123456", UUID.randomUUID().toString());
        }
        return null;
    }
}
*/
