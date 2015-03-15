package com.donc;

import javax.jws.WebService;

/**
 * Date: 2014/12/08
 * <p/>
 *
 * @author <a href="mailto:donovan@guruhut.com">Donovan</a>
 */
@WebService(endpointInterface = "com.donc.TestService")
public class TestServiceImpl implements TestService{

    public void testMethod(TestRequestObj obj) {
        System.out.println(obj.getId() + " " + obj.getName());
    }
}
