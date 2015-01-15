package com.donc.api;

import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Date: 2014/11/11
 * <p/>
 *
 * @author <a href="mailto:donovan@guruhut.com">Donovan</a>
 */
public class CustomerResourceIT {

    private static final String uri = "http://localhost:8080/webapi/customers";

    @Test
    public void testCreate() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("<customer>")
                .append("<firstName>Donovan</firstName>")
                .append("<lastName>Chong</lastName>")
                .append("<street>288 Acacia</street>")
                .append("<city>Johannesburg</city>")
                .append("<state>Gauteng</state>")
                .append("<zip>2195</zip>")
                .append("<country>South Africa</country>")
                .append("</customer>");

        Client c = ClientBuilder.newClient();
        Response response = c.target(uri).request(MediaType.APPLICATION_XML_TYPE).post(Entity.xml(sb.toString()));
        if (response.getStatus()== Response.Status.OK.getStatusCode()) {
            System.out.println("fsdfsdf");
        }

    }
}
