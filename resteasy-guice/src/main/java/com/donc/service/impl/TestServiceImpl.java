package com.donc.service.impl;

import com.donc.entities.TestTable;
import com.donc.service.TestService;
import com.google.inject.persist.Transactional;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.BadRequestException;

/**
 * Created by donovan on 15/04/09.
 */
public class TestServiceImpl implements TestService {

    @Inject
    private EntityManager em;

    @Override
    public TestTable get(int id) {
        TestTable tt = em.find(TestTable.class, id);
        return tt;
    }

    @Override
    @Transactional
    public int create(String text) {
        TestTable tt = new TestTable();
        tt.setText(text);
        em.persist(tt);
        return tt.getId();
    }

    @Override
    @Transactional
    public TestTable create(TestTable testTable) {
        em.persist(testTable);
        return testTable;
    }

    @Override
    @Transactional
    public void delete(int id) {
        TestTable tt = em.find(TestTable.class, id);
        // What should we do here if entities are not found?? How should it be handled
        if (tt==null)
            throw new EntityNotFoundException("TestTable with id=" + id + " not found");
        em.remove(tt);
    }

    @Override
    @Transactional
    public void update(int id, TestTable testTable) {
        TestTable tt = em.find(TestTable.class, id);
        tt.setText(testTable.getText());
        em.persist(tt);
    }
}
