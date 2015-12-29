package com.donc.repos;

import com.donc.config.DS1Config;
import com.donc.config.DS2Config;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Donovan Chong on 2015-11-11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DS1Config.class, DS2Config.class})
public abstract class SuperTest {
}
