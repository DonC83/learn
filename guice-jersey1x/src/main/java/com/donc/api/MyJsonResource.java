package com.donc.api;

import com.donc.entities.TestTable;
import com.donc.objects.TestDTO;
import com.donc.services.TestService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 * Date: 2014/10/21
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
@Path("myjsonresource")
public class MyJsonResource {

    @Inject
    private TestService testTableService;

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
