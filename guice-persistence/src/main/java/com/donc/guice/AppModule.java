package com.donc.guice;

import com.donc.service.TestService;
import com.donc.service.TestServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

/**
 * Date: 2014/10/27
 * <p/>
 *
 * @author <a href="mailto:donovan@guruhut.com">Donovan</a>
 */
public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new JpaPersistModule("testPU"));
        bind(Initializer.class).asEagerSingleton();
        bind(TestService.class).to(TestServiceImpl.class);
    }
}
