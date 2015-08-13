package soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 * Created by donovan on 15/06/01.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ExpressiveConfig.class)
public class TestExpressiveConfig {

    @Autowired
    private BlankDisc blankDisc;

    @Test
    public void testExpressiveConfig() throws Exception {
        assertNotNull(blankDisc);
        assertEquals(blankDisc.getArtist(), "The Beatles");
        assertEquals(blankDisc.getTitle(), "Sgt. Peppers Lonely Hearts Club Band");
    }
}
