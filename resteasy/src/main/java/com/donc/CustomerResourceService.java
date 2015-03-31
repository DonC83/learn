package com.donc;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by donovan on 15/03/18.
 */
public class CustomerResourceService implements CustomerResource {

    private Map<Integer, Customer> customerDB = new ConcurrentHashMap<>();
    private AtomicInteger idCounter = new AtomicInteger();

    public CustomerResourceService() {
        Customer c = new Customer();
        c.setId(idCounter.incrementAndGet());
        c.setFirstName("Donovan");
        c.setLastName("Chong");
        customerDB.put(c.getId(), c);
    }

    @Override
    public Response createCustomer(InputStream is) {
        Customer cs = readCustomer(is);
        cs.setId(idCounter.incrementAndGet());
        customerDB.put(cs.getId(), cs);
        System.out.println("Created customer " + cs.getId());
        return Response.created(URI.create("/customers/" + cs.getId())).build();
    }

    @Override
    public StreamingOutput getCustomer(int id) {
        final Customer customer = customerDB.get(id);
        if (customer == null) {
            throw new WebApplicationException(
                    Response.Status.NOT_FOUND);
        }

        //TODO replace with lambda
        return new StreamingOutput() {
            public void write(OutputStream outputStream)
                    throws IOException, WebApplicationException {
                outputCustomer(outputStream, customer);
            }
        };
    }

    @Override
    public void updateCustomer(int id, InputStream is) {
        Customer update = readCustomer(is);
        Customer current = customerDB.get(id);
        if (current == null)
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        current.setFirstName(update.getFirstName());
        current.setLastName(update.getLastName());
        current.setStreet(update.getStreet());
        current.setState(update.getState());
        current.setZip(update.getZip());
        current.setCountry(update.getCountry());
    }

    @Override
    public String getAllCustomers() {
        return null;
    }

    private Customer readCustomer(InputStream is) {
        return null;
    }

    private void outputCustomer(OutputStream os, Customer cust) {
        PrintStream writer = new PrintStream(os);
        writer.println("<customer id=\"" + cust.getId() + "\">");
        writer.println(" <first-name>" + cust.getFirstName()
                + "</first-name>");
        writer.println(" <last-name>" + cust.getLastName()
                + "</last-name>");
        writer.println(" <street>" + cust.getStreet() + "</street>");
        writer.println(" <city>" + cust.getCity() + "</city>");
        writer.println(" <state>" + cust.getState() + "</state>");
        writer.println(" <zip>" + cust.getZip() + "</zip>");
        writer.println(" <country>" + cust.getCountry() + "</country>");
        writer.println("</customer>");
    }
}
