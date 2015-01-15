package com.donc.services;

import com.donc.entities.CustomerEntity;
import com.donc.objects.Customer;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * Date: 2014/11/11
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
public class CustomerServiceImpl implements CustomerService {

    @Inject
    private EntityManager em;

    @Transactional
    public int create(Customer customer) {
        CustomerEntity ce = mapCustomer(customer);
        em.persist(ce);
        return ce.getId();
    }

    private CustomerEntity mapCustomer(Customer customer) {
        CustomerEntity ce = new CustomerEntity();
        ce.setId(customer.getId());
        ce.setFirstName(customer.getFirstName());
        ce.setLastName(customer.getLastName());
        ce.setStreet(customer.getStreet());
        ce.setCountry(customer.getCountry());
        ce.setCity(customer.getCity());
        ce.setState(customer.getState());
        ce.setZip(customer.getZip());
        return ce;
    }

    private Customer mapCustomer(CustomerEntity customerEntity) {
        Customer c = new Customer();
        c.setId(customerEntity.getId());
        c.setFirstName(customerEntity.getFirstName());
        c.setLastName(customerEntity.getLastName());
        c.setStreet(customerEntity.getStreet());
        c.setCountry(customerEntity.getCountry());
        c.setCity(customerEntity.getCity());
        c.setState(customerEntity.getState());
        c.setZip(customerEntity.getZip());
        return c;
    }

}
