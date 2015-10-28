package com.donc.service;

import com.donc.config.AppConfig;
import com.donc.config.DataConfig;
import com.donc.dto.UserDTO;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;

/**
 * Created by donovan on 15/10/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, DataConfig.class})
public class UserServiceTest {

    @Mock
    UserDTO dto;

    @Mock
    StrongPasswordEncryptor spe;

    @Test
    public void testAuthenticate() throws Exception {

        UserDTO dto = mock(UserDTO.class);
        dto.setUsername("donc");
        dto.setPassword("helmet9853");

//        when(mock())


    }
}
