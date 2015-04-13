package com.donc.resources;

import com.donc.entities.TestTable;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * Created by donovan on 15/04/09.
 */
public class TestResourceIT {

    private ClientBuilder client;
    private static final String urlString = "http://localhost:8080/hello/test";

    @Before
    public void setUp() throws Exception {
        client = ClientBuilder.newBuilder();
    }

    @Test
    public void testCreate() throws Exception {
        Response response = client.build().target(urlString + "/dummy").request()
                .post(Entity.entity("dummy", MediaType.APPLICATION_JSON));
        if (response.getStatus()==Response.Status.CREATED.getStatusCode()) {
            String location = response.getHeaders().get("Location").get(0).toString();
            String result = client.build().target(URI.create(location)).request().get(String.class);
            assertNotNull(result);
            TestTable tt = client.build().target(URI.create(location)).request().get(TestTable.class);
            assertNotNull(tt);
            assertEquals("Expected text value does not match", "dummy", tt.getText());

        } else {
            assertFalse("Failed to created object", false);
        }

        TestTable tt = new TestTable();
        tt.setText("testTable");
        response = client.build().target(urlString).request()
                .post(Entity.entity(tt, MediaType.APPLICATION_JSON));
        if (response.getStatus()==Response.Status.CREATED.getStatusCode()) {
            String location = response.getHeaders().get("Location").get(0).toString();
            TestTable result = client.build().target(URI.create(location)).request().get(TestTable.class);
            assertEquals("Expected text value does not match", "testTable", result.getText());
        } else {
            assertFalse("Failed to created object", false);
        }
    }

    @Test
    public void testUpdate() throws Exception {
        TestTable tt = new TestTable();
        tt.setText("testTable");

        Response response = client.build().target(urlString).request()
                .post(Entity.entity(tt, MediaType.APPLICATION_JSON));
        if (response.getStatus()==Response.Status.CREATED.getStatusCode()) {
            String location = response.getHeaders().get("Location").get(0).toString();
            TestTable result = client.build().target(URI.create(location)).request().get(TestTable.class);
            assertEquals("Expected text value does not match", "testTable", result.getText());
            result.setText("newText");
            client.build().target(urlString).request().put(Entity.entity(result, MediaType.APPLICATION_JSON));

        } else {
            assertFalse("Failed to created object", false);
        }

    }

    @Test
    public void testGetHello() throws Exception {
        ClientBuilder client = ClientBuilder.newBuilder();
        String response = client.build().target("http://localhost:8080/hello/donovan").request().get(String.class);
        assertEquals("Hello donovan", response);
    }
}
