package com.donc.repo;

import com.donc.config.DataConfig;
import com.donc.entities.EncrytedEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by donovan on 15/10/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class EncryptedEntityTest {

    @Autowired
    private EncryptedEntityRepo encrytedEntity;

    @Test
    public void testAdd() throws Exception {
        EncrytedEntity entity = new EncrytedEntity();
        entity.setText1("tesxt1");
        entity.setText2("tesxt2");
        encrytedEntity.save(entity);
    }
}
