package com.donc.api;

import com.donc.entities.TestTable;
import com.donc.objects.TestDTO;
import com.donc.services.TestTableService;
import com.donc.services.TestTableServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource")
public class MyResource {

    @Inject
    private TestTableService testTableService;
    
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET 
    @Produces("text/plain")
    public String getIt(@Context SecurityContext sc) {
        return "Hi there!";
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(@PathParam("id") int id) {
        TestTable tt = testTableService.getTestTable(id);
        return tt.getText();
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("text")
    public Response addText(String text) {
        int id = testTableService.add(text);
        return Response.created(UriBuilder.fromPath("/{id}").build(id)).build();
    }

    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("text/delete/{text}")
    public Response deleteText(@PathParam("text") String text) {
        testTableService.deleteText(text);
        return Response.noContent().build();
    }

    @GET
    @Path("json/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TestDTO getJson(@PathParam("id") int id) {
        TestTable tt = testTableService.getTestTable(id);
        TestDTO t = new TestDTO();
        t.setText(tt.getText());
        return t;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("json")
    public Response addJsonText(TestDTO testDTO) {
        int id = testTableService.add(testDTO.getText());
        return Response.created(UriBuilder.fromPath("/{id}").build(id)).build();
    }
}
