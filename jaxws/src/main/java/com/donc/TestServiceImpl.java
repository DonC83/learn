package com.donc;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebEndpoint;

/**
 * Date: 2014/12/08
 * <p/>
 *
 * @author <a href="mailto:donovan@guruhut.com">Donovan</a>
 */
@WebService(endpointInterface = "")
public class TestServiceImpl {

    @WebMethod
    public void testMethod(TestRequestObj obj) {
        System.out.println(obj.getId() + " " + obj.getName());
    }
}
