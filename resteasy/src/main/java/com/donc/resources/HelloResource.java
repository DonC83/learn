package com.donc.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by donovan on 15/03/16.
 */
@Path("/hello")
public class HelloResource {

    @GET
    @Path("{name}")
    public String hello(@PathParam("name") final String name) {
        return "Hello " + name;
    }

    @GET
    @Path("/byte/{name}")
    @Produces("text/plain")
    public byte[] get(@PathParam("name") final String name) {
        return ("Byte hello " + name).getBytes();
    }

}
