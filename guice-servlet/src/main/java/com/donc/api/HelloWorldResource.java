package com.donc.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Date: 2014/10/09
 * <p/>
 *
 * @author <a href="mailto:donovan@guruhut.com">Donovan</a>
 */
@Path("/hello")
public class HelloWorldResource {


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello World";
    }

}
