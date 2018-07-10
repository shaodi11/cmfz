import com.baizhi.cmfz.dao.ArticleDao;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.ArticleService;
import com.baizhi.cmfz.service.GuruService;
import com.baizhi.cmfz.util.UUIDGenerator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by 邵迪 on 2018/7/5.
 */
public class ActiveTest {
    @Test
    public void testSelectGrur() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        ArticleService article = (ArticleService) ctx.getBean("articleServiceImpl");

        ArticleDao articleDao = (ArticleDao) ctx.getBean("articleDao");

        Article article1 = new Article("1122","121","12121","111111","222",new Date());

     //   int i = articleDao.insertArticle(article1);

        int i = article.addArticle(article1);
        System.out.println(i);

    }
}