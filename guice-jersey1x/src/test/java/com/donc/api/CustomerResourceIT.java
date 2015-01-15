package com.donc.api;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXB;

/**
 * Date: 2014/11/11
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
public class CustomerResourceIT {

    private final String url = "http://localhost:8080/webapi/";
    private static Client c;




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


        c = Client.create();
        WebResource resource = c.resource(url);
//        resource.type(MediaType.APPLICATION_XML_TYPE).post(Entity);




    }
}
