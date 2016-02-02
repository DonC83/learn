package com.donc.repos.db1;

import com.donc.db1.entities.Person;
import com.donc.db2.entities.Address;
import com.donc.repos.SuperTest;
import com.donc.repos.db2.AddressRepo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Donovan Chong on 2015-11-11.
 */
public class TestPersonRepo extends SuperTest{

    @Autowired
    private PersonRepo repo;

    @Autowired
    private AddressRepo addressRepo;

    @Test
    public void testAdd() throws Exception {
        Person p = new Person();
        p.setName("Donovan");
        repo.save(p);
        Address a = new Address();
        a.setPersonId(p.getId());
        a.setStreeName("6 Tessa Place");
        addressRepo.save(a);
    }

    @Test
    public void testGetCreatedBetween() throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = df.parse("2015-11-11 09:00:00");
        Date end = df.parse("2015-11-11 09:40:00");
        List<Person> persons = repo.personCreatedBetween(start, end);
        assertNotNull(persons);
        assertTrue(persons.size()>0);

    }
}
