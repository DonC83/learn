package com.donc.guice;

import com.donc.resources.HelloResource;
import com.donc.service.ClientService;
import com.donc.service.impl.ClientServiceImpl;
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
        bind(ClientService.class).to(ClientServiceImpl.class);
        bind(HelloResource.class);


    }
}
