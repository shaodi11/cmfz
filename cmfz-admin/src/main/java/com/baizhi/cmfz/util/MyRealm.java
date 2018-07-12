package com.baizhi.cmfz.util;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.PermissionService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * 继承AuthorizingRealm类，覆盖两个抽象方法，
 *
 * 一个获取授权，一个验证信息
 *
 * Created by 邵迪 on 2018/7/11.
 */
public class MyRealm extends AuthorizingRealm{

    @Autowired
    private ManagerDao managerDao;

    @Autowired
    private PermissionService permissionService;

    /**
     * 获取授权信息   有 角色信息 + 权限信息
     *
     * 编程式  subject hasRole hasRoles 。。。
     *
     * 标签式  有shiro提供的一个标签库
     *
     * 注解式  @RequiresRoles("角色")
     *
     * 注：后面两个获取授权信息的前提是在编程式授权信息完成之后才可用
     *
     * @param principalCollection 认证的主体名
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("-----------------进入授权------------------");

        //获得认证的主体名
        String username = (String) principalCollection.getPrimaryPrincipal();
        //new一个用于授权的类
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //查询主体的角色有哪些
        List<Role> roles = permissionService.queryRole(username);
        //依次给主体加入角色的权限
        for ( Role role : roles){

            info.addRole(role.getRoleTag());
        }

        //查询主体的角色对应的资源权限
        List<Permission> permissions = permissionService.queryPermission(username);
        for (Permission permission : permissions){
            info.addStringPermission(permission.getPermissionTag());
        }

        return info;
    }


    /**
     *
     * 获取认证信息的方法
     *
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //将令牌转换成UsernamePasswordToken 类型
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        //通过令牌获取到用户名
        String username = token.getUsername();

        //从数据库中获取用户信息，进行比对认证
        Manager manager = new Manager();
        manager.setManagerName(username);

        Manager managers = managerDao.selectManagerByName(manager);

        if (managers!=null && username.equals(managers.getManagerName())){
            //当查到的数据库中的用户信息不为空，且y用户名匹配成功，则将查到的用户信息封装成指定的类型，返回

            //获取session，存入查到的manager，用于后期的log日志的增加
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();

            HttpSession session = requestAttributes.getRequest().getSession();

            session.setAttribute("manager",managers);

            return new SimpleAuthenticationInfo(managers.getManagerName(),
                    managers.getManagerPassword(),
                    ByteSource.Util.bytes(managers.getSalt()),
                    UUIDGenerator.getUUID());
        }

        return null;
    }
}
