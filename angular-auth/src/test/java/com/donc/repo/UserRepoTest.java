package com.donc.repo;

import com.donc.config.DataConfig;
import com.donc.entities.User_;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by donovan on 15/10/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class UserRepoTest {

    @Autowired
    private UserRepo repo;

    @Test
    public void testCreate() throws Exception {
        User_ user = new User_();
        user.setUsername("donc83");
        StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
        user.setPassword(spe.encryptPassword("helmet9853"));
        repo.save(user);

        User_ user2 =  repo.findOne(user.getId());
        assertTrue(spe.checkPassword("helmet9853", user2.getPassword()));
        assertFalse(spe.checkPassword("fdjkfds", user2.getPassword()));

        repo.delete(user2);
    }

    @Test
    public void testFindByUsername() throws Exception {
        User_ user = new User_();
        user.setUsername("donc83");
        StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
        user.setPassword(spe.encryptPassword("helmet9853"));
        repo.save(user);
        User_ user2 = repo.findByUsername("donc83");
        assertNotNull(user2);
        repo.delete(user2);

    }
}
