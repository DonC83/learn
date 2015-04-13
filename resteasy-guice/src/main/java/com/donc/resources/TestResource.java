package com.donc.resources;

import com.donc.entities.TestTable;
import com.donc.service.TestService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * Created by donovan on 15/04/08.
 */
@Path("hello")
public class TestResource {

    @Inject
    private TestService testService;

    @GET
    @Path("{name}")
    @Produces("application/json")
    public String hello(@PathParam("name") String name) {
        return "Hello ".concat(name);
    }

    @GET
    @Path("test/{id}")
    @Produces("application/json")
    public TestTable get(@PathParam("id") int id) {
        TestTable tt = testService.get(id);
        return tt;
    }

    @POST
    @Path("test/{text}")
    public Response create(@PathParam("text") String text) {
        int id = testService.create(text);
        System.out.println(id);
        return Response.created(URI.create("/hello/test/" + id)).build();
    }

    @POST
    @Path("test")
    public Response create(TestTable testTable) {
        TestTable tt = testService.create(testTable);
        return Response.created(URI.create("/hello/test/" + tt.getId())).build();
    }

    @PUT
    @Path("test/{id}")
    public void update(@PathParam("id") int id, TestTable testTable) {
        testService.update(id, testTable);
    }

    @DELETE
    @Path("test/{id}")
    public void delete(@PathParam("id") int id) {
        testService.delete(id);
    }

}
