package com.donc.resources;

import com.donc.service.ClientService;
import za.co.nwtrust.entities.Client;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by donovan on 15/04/08.
 */
@Path("hello")
public class TestResource {

    @Inject
    private ClientService clientService;

    @GET
    @Path("{name}")
    @Produces("application/json")
    public String hello(@PathParam("name") String name) {
        return "Hello ".concat(name);
    }


    @GET
    @Path("client/{id}")
    @Produces("application/json")
    public Client getClient(@PathParam("id") int id) {
        return clientService.getClient(id);
    }
}
