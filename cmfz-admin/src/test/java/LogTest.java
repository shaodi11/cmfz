import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.GuruService;
import com.baizhi.cmfz.service.LogService;
import com.baizhi.cmfz.util.UUIDGenerator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by 邵迪 on 2018/7/5.
 */
public class LogTest {
    @Test
    public void testLog() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        LogDao logService = (LogDao) ctx.getBean("logLogDao");


       // int i = logService.addLog(new Log("1","11",new Date(),"111","1111","111111","1212"));

       // System.out.println(i);

        System.out.println(logService.selectPageLog(0,2));


    }
}