import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.MD5;
import com.baizhi.cmfz.util.Salt;
import com.baizhi.cmfz.util.UUIDGenerator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by 邵迪 on 2018/7/4.
 */
public class ManagerTest {
    @Test
    public void testManager(){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        ManagerDao managerDao = (ManagerDao) ctx.getBean("managerDao");

        Manager manager = new Manager();

        manager.setManagerId(UUIDGenerator.getUUID());

        manager.setManagerName("小小");

        String salt = Salt.getSalt();

        String realPwd = "111111";

        String pwd = MD5.getMD5String(realPwd + salt);

        manager.setManagerPassword(pwd);

        manager.setSalt(salt);

        manager.setManagerStatus(0);

        int i = managerDao.insertManager(manager);

        System.out.println(manager);

        System.out.println(i);
    }

    @Test
    public void testSelectManager(){
        Manager manager = new Manager();

        manager.setManagerName("tom");

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        ManagerDao managerDao = (ManagerDao) ctx.getBean("managerDao");

        System.out.println(managerDao.selectManagerByName(manager));
    }

    @Test
    public void testServiceSelectManager(){
        Manager manager = new Manager();

        manager.setManagerName("小小");

        manager.setManagerPassword("111111");

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        ManagerService Impl = (ManagerService) ctx.getBean("managerServiceImpl");

        System.out.println(Impl.queryManagerByName(manager));
    }


}
