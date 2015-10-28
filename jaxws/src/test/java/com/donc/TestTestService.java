package com.donc;

import com.donc.client.*;
import com.donc.client.TestRequestObj;
import com.donc.client.TestService;
import org.junit.Test;


/**
 * Created by donovan on 15/05/19.
 */
public class TestTestService {

    @Test
    public void testMethod() throws Exception {
        TestServiceImplService tsImpl = new TestServiceImplService();
        TestService ts = tsImpl.getTestServiceImplPort();
        TestRequestObj tro = new TestRequestObj();
        tro.setId("1");
        tro.setName("Test");
        ts.testMethod(tro);


    }
}
