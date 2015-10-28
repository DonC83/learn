package com.donc.config;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by donovan on 15/10/27.
 */
@Configuration
@ComponentScan(basePackages = { "com.donc.service" })
public class AppConfig {

    @Bean
    public StrongPasswordEncryptor strongPasswordEncryptor() {
        return new StrongPasswordEncryptor();
    }

}
