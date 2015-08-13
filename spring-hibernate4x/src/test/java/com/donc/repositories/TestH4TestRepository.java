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
 * Created by donovan on 15/06/07.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfig.class)
public class TestH4TestRepository {

    @Autowired
    private TestRepository repo;


    @Test
    @Transactional
    public void testGetAll() throws Exception {
        repo.add("Random text");
        List<TestTable> list = repo.getAll();
        assertTrue(list.size()>0);
    }
}
