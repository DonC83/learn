package com.donc.service.impl;

import com.donc.service.LoginService;
import com.google.inject.Inject;

import javax.persistence.EntityManager;

/**
 * Created by donovan on 15/04/14.
 */
public class LoginServiceImpl implements LoginService {

    @Inject
    private EntityManager em;

    @Override
    public boolean login(String username, String password) {
        return false;
    }

}
