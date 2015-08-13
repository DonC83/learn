package soundsystem;

import configuration.Config;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.sql.DataSource;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by donovan on 15/05/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
//@ActiveProfiles("dev")
public class TestCDPlayer {

    @Rule
    public final SystemOutRule systemOut = new SystemOutRule().enableLog();

    @Autowired
    private MediaPlayer player;

    @Autowired
    private CompactDisc cd;


    @Test
    public void testPlay() throws Exception {
        assertNotNull(player);
        assertNotNull(cd);
        assertTrue(cd instanceof SgtPeppers);
        player.play();
        assertEquals("Playing Sgt. Peppers by The Beatles\n", systemOut.getLog());

    }
}
