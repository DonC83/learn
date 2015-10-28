package com.donc.config;

import com.donc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

/**
 * Created by donovan on 15/08/12.
 */
@Configuration
@ComponentScan(basePackages = { "com.donc.service" })
public class RemoteConfig {

    @Bean
    @Autowired
    public RmiServiceExporter rmiExporter(TestService testService) {
        System.out.println("Configuring " + testService.getClass().getName());
        RmiServiceExporter rmiExporter = new RmiServiceExporter();
        rmiExporter.setService(testService);
        rmiExporter.setServiceName("TestService");
        rmiExporter.setServiceInterface(TestService.class);
        rmiExporter.setRegistryPort(1888);
//        rmiExporter.setRegistryHost("daitengu");
        return rmiExporter;
    }

}
