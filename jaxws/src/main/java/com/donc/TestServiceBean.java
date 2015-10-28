package com.donc;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Created by donovan on 15/05/19.
 */
@Remote(TestService.class)
@Stateless
public class TestServiceBean extends TestServiceImpl {


}
