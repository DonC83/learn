package com.donc.api;

import com.donc.entities.TestTable;
import com.donc.objects.TestDTO;
import com.donc.services.TestService;
import com.sun.jersey.api.NotFoundException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource")
@Produces(MediaType.TEXT_PLAIN)
public class MyResource {

    @Inject
    private TestService testTableService;

    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET
    public String getIt(@Context SecurityContext sc) {
        return "Hi there!";
    }

    @GET
    @Path("{id}")
    public String getIt(@PathParam("id") int id) {
        TestTable tt = testTableService.getTestTable(id);
        if (tt==null)
            throw new NotFoundException("Entity TestTable with ID=" + id + " not found.");
        return tt.getText();
    }

    @Path("text")
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public Response addText(String text) {
        int id = testTableService.add(text);
        return Response.created(UriBuilder.fromPath("/{id}").build(id)).build();
    }

    @Path("all")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @GET
    public List<TestDTO> getAll() {
        List<TestDTO> testDTOs = new ArrayList<TestDTO>();
        for (TestTable tt : testTableService.getAll()) {
            testDTOs.add(new TestDTO(tt.getId(), tt.getText()));
        }
        return testDTOs;
    }

    @Path("id/{id}")
    @DELETE
    public void deleteText(@PathParam("id")String text) {
        testTableService.deleteText(text);
//        return Response.noContent().build();
    }


}
