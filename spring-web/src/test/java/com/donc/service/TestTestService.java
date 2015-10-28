package com.donc.service;

import com.donc.dto.TestDTO;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by donovan on 15/08/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Config.class })
public class TestTestService {

    @Autowired
    private TestService testService;

    @Test
    public void testAdd() throws Exception {
        TestDTO dto = new TestDTO();
        dto.setText("Hello from rmi client");
        testService.addTestTable(dto);

    }
}
