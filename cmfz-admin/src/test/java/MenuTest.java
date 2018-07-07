import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import com.baizhi.cmfz.service.MenuServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by 邵迪 on 2018/7/5.
 */
public class MenuTest {
    @Test
    public void testSelectMenu(){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

       // MenuDao m = (MenuDao) ctx.getBean("menuDao");

      //  List<Menu> menus = m.selectMenu();

        MenuService menuService = (MenuService) ctx.getBean("menuServiceImpl");

        List<Menu> menus = menuService.queryMenu();
        for (Menu men : menus){
            System.out.println(men);
        }

    }
}
