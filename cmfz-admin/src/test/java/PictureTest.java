import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.MenuService;
import com.baizhi.cmfz.service.PictureService;
import com.baizhi.cmfz.util.UUIDGenerator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by 邵迪 on 2018/7/5.
 */
public class PictureTest {
    @Test
    public void testSelectMenu() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        PictureDao pictureDao = (PictureDao) ctx.getBean("pictureDao");

        Picture picture = new Picture("3a22bd93944f4e90950ecb11f6699879", "2.png", "/", new Date(), "上师", "未展示");

        int i = pictureDao.updatePicture(picture);
        System.out.println(i);
        //  int i = pictureDao.insertPicture(picture);

        //   List<Picture> pictures = pictureDao.selectPicturePage(0, 4);

        //  for (Picture p : pictures){
        //     System.out.println(p);
        // }

        // System.out.println(pictureDao.selectPictureById("4349ff77a18d4a74be26fa231111a931"));


        //  System.out.println(pictureDao.deletePicture("4349ff77a18d4a74be26fa231111a931"));
    }

    @Test
    public void testServiceSelectMenu() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        PictureService pictureService = (PictureService) ctx.getBean("pictureServiceImpl");

     /*   List<Picture> list = pictureService.queryPicturePage(0, 3);

        for(Picture p : list){
            System.out.println(p);
        }*/

    }

    @Test
    public void testServiceSelect() {
        //获得文件夹绝对路径
        String realPath = "wds/webapp/local";

        //获取文件路径的最后一个/的下标
        int i = realPath.lastIndexOf("/");

        String substring = realPath.substring(0,i);

        System.out.println(substring);
    }
}