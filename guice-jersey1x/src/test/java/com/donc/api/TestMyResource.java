package com.donc.api;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Date: 2014/10/10
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
public class TestMyResource extends JerseyTest {

    private final String url = "http://localhost:8080/webapi/";
    private static Client c;

    public TestMyResource()  {
        super("com.donc.api");
        //This does not seem to be required
//        Map<String,Object> p = cc.getProperties();
//        p.put("jersey.test.containerFactory", "com.sun.jersey.test.framework.spi.container.external.ExternalTestContainerFactory");
//        p.put("jersey.test.port", "8080");
//        p.put("jersey.test.host", "localhost");
        c = Client.create();
    }

    @Test
    public void testGetIt() throws Exception {
        WebResource resource = c.resource(url);
        String response = resource.path("myresource").get(String.class);
        assertEquals("Hi there!", response);
    }

    @Test
    public void testAddText() throws Exception {
        WebResource resource = c.resource(url);
//        JSONObject testDTO = new JSONObject();
//        testDTO.put("text", "Testing post on resource");
//        resource.path("myresource/json").entity(testDTO, MediaType.APPLICATION_JSON).post();
        try {

            resource.path("myresource/text").post(String.class, "Testing post on resource");
            ClientResponse resp = resource.head();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetAll() throws Exception {
        WebResource resource = c.resource(url);
        String response = resource.path("myresource/all").get(String.class);
        System.out.println(response);

    }

    @Test
    public void testDeleteText() throws Exception {
        WebResource resource = c.resource(url);
        try {

            resource.path("myresource/text/delete").queryParam("text", "Testing post on resource").delete();
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }
}
