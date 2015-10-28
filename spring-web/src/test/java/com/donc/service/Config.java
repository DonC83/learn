package com.donc.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

/**
 * Created by donovan on 15/08/12.
 */
@Configuration
@ComponentScan(basePackages = { "com.donc.service" })
public class Config {

    @Bean
    public RmiProxyFactoryBean testService() {
        RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
        rmiProxy.setServiceUrl("rmi://localhost:1888/TestService");
        rmiProxy.setServiceInterface(TestService.class);
        return rmiProxy;
    }

}
