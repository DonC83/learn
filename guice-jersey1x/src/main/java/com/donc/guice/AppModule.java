package com.donc.guice;

import com.donc.services.TestTableService;
import com.donc.services.TestTableServiceImpl;
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
        install(new JpaPersistModule("rest-learn"));

        bind(TestTableService.class).to(TestTableServiceImpl.class);
    }
}
