package com.donc.guice;

import com.donc.services.CustomerService;
import com.donc.services.CustomerServiceImpl;
import com.donc.services.TestService;
import com.donc.services.TestServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

/**
 * Date: 2014/10/09
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new JpaPersistModule("testPU"));

        bind(TestService.class).to(TestServiceImpl.class);
        bind(CustomerService.class).to(CustomerServiceImpl.class);
    }
}
