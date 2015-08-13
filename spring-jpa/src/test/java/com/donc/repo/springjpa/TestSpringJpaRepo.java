package com.donc.repo.springjpa;

import com.donc.config.AppConfig;
import com.donc.repo.springjpa.JpaRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
/**
 * Created by donovan on 15/06/09.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestSpringJpaRepo {

    @Autowired
    private JpaRepo jpaRepo;

    @Test
    public void testAdd() throws Exception {
        int id = jpaRepo.add("Test text");
        assertTrue(id>0);
    }

}
