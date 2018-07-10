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

        GuruService grurService = (GuruService) ctx.getBean("guruServiceImpl");

        Guru g = new Guru(UUIDGenerator.getUUID(), "仁波切11", "2.png", "上师1枚");

        int i = grurService.addGuru(g);

    }
}