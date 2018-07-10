package com.baizhi.cmfz.util;

import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by 邵迪 on 2018/7/9.
 */
@Aspect
public class MyLogAdvice {
/*

    @Autowired
    private HttpSession session;
*/

    @Autowired
    private LogService logService;


    /**
     * 声明切入点表达式
     * 定义method的方法
     */
    @Pointcut("execution(* com.baizhi.cmfz.service.impl.*.modify*(..)) || execution(* com.baizhi.cmfz.service.impl.*.remove*(..)) || execution(* com.baizhi.cmfz.service.impl.*.add*(..))")
    public void method(){}


    /**
     * 定义环绕通知方法
     * 用以log日志的监控
     */
    @Around("method()")
    public Object log(ProceedingJoinPoint pjp){

        System.out.println("~~~~~~~~~~~~~~~开始log监控~~~~~~~~~~~~~~~~~~~~~~~~");

        //得到要操作的对象的参数值（集合）
        Object[] args = pjp.getArgs();
        String logMessage = args[0].toString();

        //得到调用serviceimpl方法的名字
        MethodSignature signatureMethod = (MethodSignature) pjp.getSignature();
        String logAction = signatureMethod.getMethod().getName();

        //获得执行类的全限定名 com.baizhi.cmfz.service.impl.XXXXServiceImpl@XXXXX
        String allName = pjp.getThis().toString();

        //得到com.baizhi.cmfz.service.impl.XXXXServiceImpl
        String s = allName.substring(0, allName.lastIndexOf("@"));
        String logResource = s.substring(s.lastIndexOf(".")+1);

        //设置一个object对象，用其来接收原始方法的返回值,返回给调用者
        Object obj = null;
        String result = "";
        try {
            obj = pjp.proceed();

            //方法执行无误后返回设置log的result为success，发生异常，则设置为error
            result = "success";


        } catch (Throwable throwable) {
            result = "error";
            throwable.printStackTrace();
        }

        //session获取
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = requestAttributes.getRequest().getSession();

        //创建本次用户操作的log对象，插入数据库
        Log l = new Log();
        l.setLogId(UUIDGenerator.getUUID());
        l.setLogDate(new Date());
        l.setLogResult(result);
        l.setLogMessage(logMessage);
        l.setLogResource(logResource);
        l.setLogAction(logAction);
        Manager manager = (Manager) session.getAttribute("manager");
        l.setUserName(manager.getManagerName());
        logService.addLog(l);
        return obj;
    }


}
