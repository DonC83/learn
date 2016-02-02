package com.donc.repos.db1.impl;

import com.donc.db1.entities.Person;
import com.donc.repos.db1.PersonRepoCust;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Donovan Chong on 2015-11-11.
 */
public class PersonRepoImpl implements PersonRepoCust {

    @PersistenceContext(unitName = "db1EntityManagerFactory")
    private EntityManager em;

    @Override
    public List<Person> personCreatedBetween(Date start, Date end) {
        return em.createNativeQuery("select p.* from person p where p.created_at between ? and ?", Person.class)
                .setParameter(1, new Timestamp(start.getTime()))
                .setParameter(2, new Timestamp(end.getTime())).getResultList();
    }
}
