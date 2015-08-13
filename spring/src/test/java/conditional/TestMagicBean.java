package conditional;

import configuration.Config;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 * Created by donovan on 15/06/01.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class TestMagicBean {

    @Autowired
    private MagicBean magicBean;

    @Autowired
    private ApplicationContext context;

    @BeforeClass
    public static void before() {
        System.setProperty("magic", "magic");
    }

    @Test
    public void testGetMagicBean() throws Exception {
        assertTrue(context.getEnvironment().containsProperty("magic"));
        assertNotNull(magicBean);
    }
}
