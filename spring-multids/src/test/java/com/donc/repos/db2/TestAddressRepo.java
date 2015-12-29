package com.donc.repos.db2;

import com.donc.db2.entities.Address;
import com.donc.repos.SuperTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Donovan Chong on 2015-11-11.
 */
public class TestAddressRepo extends SuperTest {

    @Autowired
    private AddressRepo repo;

    @Test
    public void testCreate() throws Exception {

    }
}
