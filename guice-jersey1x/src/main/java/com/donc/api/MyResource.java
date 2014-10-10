package com.donc.api;

import com.donc.services.TestTableService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
    public String getIt() {
        System.out.println(testTableService);
        return "Hi there!";
    }
}
