package com.donc.api;

import com.donc.services.CustomerService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Date: 2014/11/11
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
@Path("/customers")
public class CustomerResource {

    @Inject
    private CustomerService service;

    @POST
    @Consumes("application/xml")
    public Response create(InputStream is) {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc =  db.parse(is);
            Element root = doc.getDocumentElement();

            String name = root.getAttribute("name");

            System.out.println(name);

        } catch (IOException | SAXException | ParserConfigurationException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
