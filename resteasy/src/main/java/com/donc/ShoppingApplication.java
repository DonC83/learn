package com.donc;

import com.donc.resources.HelloResource;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by donovan on 15/03/18.
 */
public class ShoppingApplication extends Application {

    private Set<Object> singletons = new HashSet<>();
    private Set<Class<?>> empty = new HashSet<>();

    public ShoppingApplication() {
        singletons.add(new CustomerResourceService());
        singletons.add(new HelloResource());
    }

    @Override
    public Set<Class<?>> getClasses() {
        return empty;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
