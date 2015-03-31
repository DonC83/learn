package com.donc.guice;

import com.donc.resources.HelloResource;
import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * Created by donovan on 15/02/25.
 */
public class AppModule implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(HelloResource.class);
    }
}
