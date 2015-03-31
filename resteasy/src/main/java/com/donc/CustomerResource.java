package com.donc;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.InputStream;

/**
 * Created by donovan on 15/03/18.
 */
@Path("/customers")
public interface CustomerResource {

    @POST
    @Consumes("application/xml")
    Response createCustomer(InputStream is);

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    StreamingOutput getCustomer(@PathParam("id") int id);

    @PUT
    @Path("{id}")
    @Consumes("application/xml")
    void updateCustomer(@PathParam("id") int id, InputStream is);

    @GET
    @Produces({"application/xml", "application/json"})
    String getAllCustomers();

}
