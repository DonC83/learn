package jdbc;

import entities.TestTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by donovan on 15/06/03.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JdbcConfig.class })
@ActiveProfiles("external")
public class TestJdbc {

    @Autowired
    private TestRepository testRepository;

    @Test
    public void testTestAdd() throws Exception {
        TestTable tt = new TestTable();
        tt.setId(2);
        tt.setText("text");
        testRepository.addTest(tt);
    }

    @Test
    public void testGetTest() throws Exception {
        TestTable tt = testRepository.getTestTable(1);
        assertNotNull(tt);
        assertEquals("text", tt.getText());
    }
}
