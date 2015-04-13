package com.donc.guice;

import com.donc.resources.TestResource;
import com.donc.service.TestService;
import com.donc.service.impl.TestServiceImpl;
import com.google.inject.AbstractModule;

/**
 * Created by donovan on 15/04/08.
 */
//public class HelloModule implements Module {
//
//    public void configure(final Binder binder) {
//
//        binder.bind(HelloResource.class);
//    }
//
//}

//You can either extend AbstractModule as well if you so wish
public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(TestService.class).to(TestServiceImpl.class);
        bind(TestResource.class);
    }
}
