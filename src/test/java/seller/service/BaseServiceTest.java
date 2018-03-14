package seller.service;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Базовый класс для тестов.
 *
 * @author Aleksei_Zabezhinsky
 */
@Ignore
@ContextConfiguration(locations = { "classpath:spring/service.xml",
        "classpath:spring/aspect.xml",
        "classpath:spring/dao.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class BaseServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

}
