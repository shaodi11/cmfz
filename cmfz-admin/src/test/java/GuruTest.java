import com.baizhi.cmfz.dao.GuruDao;
import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.GuruService;
import com.baizhi.cmfz.service.PictureService;
import com.baizhi.cmfz.util.UUIDGenerator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.UUID;

/**
 * Created by 邵迪 on 2018/7/5.
 */
public class GuruTest {
    @Test
    public void testSelectGrur() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

       // GuruService grurService = (GuruService) ctx.getBean("guruServiceImpl");

        //Guru g = new Guru("93ebee16ffdc4f2690a62a8d44506beb", "仁波切11", "2.png", "上师1枚");

        //System.out.println(grurService.modifyGuru(g));

        GuruDao guruDao = (GuruDao) ctx.getBean("guruDao");

       // System.out.println(guruDao.selectGuruPage(0,30));

        System.out.println(guruDao.selectLikeGuru("%仁波%",0,2));

    }
}