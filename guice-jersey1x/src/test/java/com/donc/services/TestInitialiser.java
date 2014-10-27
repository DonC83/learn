package com.donc.services;

import com.google.inject.persist.PersistService;

import javax.inject.Inject;

/**
 * Date: 2014/10/22
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
public class TestInitialiser {

    @Inject
    public TestInitialiser(PersistService service) {
        service.start();
    }
}
