package com.donc.repo.springdata;

import com.donc.entities.TestTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by donovan on 15/06/09.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaRepo.class)
public class TestSpringDataJpaRepo {

    @Autowired
    private JpaRepo newJpaRepo;

    @Test
    public void testAdd() throws Exception {
        TestTable tt = new TestTable();
        tt.setText("Test from new repo");
        newJpaRepo.save(tt);

    }
}
