package com.donc;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Date: 2014/12/08
 * <p/>
 *
 * @author <a href="mailto:donovan@guruhut.com">Donovan</a>
 */
@WebService
public interface TestService {

    @WebMethod
    void testMethod(TestRequestObj obj);
}
