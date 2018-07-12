import com.baizhi.cmfz.dao.PermissionDao;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by 邵迪 on 2018/7/12.
 */
public class PermissionTest {

    @Test
    public void permissionTest(){

        ApplicationContext cxt = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        PermissionDao permissionDao = (PermissionDao) cxt.getBean("permissionDao");

        List<Role> tom1 = permissionDao.selectRole("张张");
        System.out.println(tom1);

         List<Permission> tom = permissionDao.selectPermission("张张");
         System.out.println(tom);

    }

}
