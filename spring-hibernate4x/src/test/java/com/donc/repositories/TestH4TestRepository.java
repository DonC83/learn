package com.donc.repositories;

import donc.config.HibernateConfig;
import donc.repositories.TestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by donovan on 15/06/07.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfig.class)
public class TestH4TestRepository {

    @Autowired
    private TestRepository repo;

    @Test
    public void testGet() throws Exception {
        System.out.println(repo);

    }
}
