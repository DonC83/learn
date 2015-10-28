package com.donc.repo.springdata;

import com.donc.config.SpringDataJpaConfig;
import com.donc.entities.TestTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by donovan on 15/06/09.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDataJpaConfig.class)
@ActiveProfiles("dev")
public class TestSpringDataJpaRepo {

    @Autowired
    private JpaRepo jpaRepo;

    @Test
    public void testAdd() throws Exception {
        TestTable tt = new TestTable();
        tt.setText("Test from new repo");
        jpaRepo.save(tt);
    }

    @Test
    @Transactional
    public void testFindAll() throws Exception {
        TestTable tt = new TestTable();
        tt.setText("Test from new repo 1");
        jpaRepo.save(tt);
        tt = new TestTable();
        tt.setText("Test from new repo 2");
        jpaRepo.save(tt);
        List<TestTable> list = jpaRepo.findAll();
        assertTrue(list.size()>2);

    }

    @Test
    public void testEvaluateTest() throws Exception {
        TestTable tt = new TestTable();
        tt.setId(3);
        tt.setText("dsds");
        assertFalse(jpaRepo.evaluateTest(tt));

    }
}
