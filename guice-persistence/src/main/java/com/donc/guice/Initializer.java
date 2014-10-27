package com.donc.guice;

import com.google.inject.persist.PersistService;

import javax.inject.Inject;

/**
 * Date: 2014/10/27
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
public class Initializer {

    @Inject
    public Initializer(PersistService service) {
        service.start();
    }
}
