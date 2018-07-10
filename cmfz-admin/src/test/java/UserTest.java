import com.baizhi.cmfz.dao.GuruDao;
import com.baizhi.cmfz.dao.UserDao;
import com.baizhi.cmfz.entity.User;
import com.baizhi.cmfz.util.UUIDGenerator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by 邵迪 on 2018/7/5.
 */
public class UserTest {
    @Test
    public void testSelectGrur() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = (UserDao) ctx.getBean("userDao");

        User user = new User(UUIDGenerator.getUUID(),"tom","tom仁波切","111111","男","1.png","上海","13999999999","打坐","0",new Date());

        int i = userDao.insertUser(user);

        System.out.println(i);
    }


    @Test
    public void testCount() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = (UserDao) ctx.getBean("userDao");

        List<User> users = userDao.selectManUser();

        System.out.println(users);

    }
}