package com.donc.services;

import com.donc.entities.TestTable;
import com.google.inject.persist.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Date: 2014/10/09
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
public class TestTableServiceImpl implements TestTableService {

    @Inject
    private EntityManager em;


    @Override
    @Transactional
    public void add(String text) {
        TestTable testTable = new TestTable();
        testTable.setText(text);
        em.persist(testTable);
    }

    @Override
    public TestTable getTestTable(int id) {
        return em.find(TestTable.class, id);
    }
}
