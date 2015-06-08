package com.donc.repositories;

import com.donc.config.HibernateConfig;
import com.donc.entities.TestTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by donovan on 15/06/05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfig.class)
public class TestTestRepository {

    @Autowired
    private TestRepository testRepo;


    @Test
    @Transactional
    public void testGetAll() throws Exception {
        int id = testRepo.add("Random text testing");
        List<TestTable> list = testRepo.getAll();
        assertNotNull(list);
        assertTrue(list.size()>0);

    }

    @Test
    @Transactional
    public void testAdd() throws Exception {
        int id = testRepo.add("Random text testing");
        assertTrue(id>0);
    }

}
