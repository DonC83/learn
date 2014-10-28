package com.donc.services;

import com.donc.entities.TestTable;
import com.google.inject.persist.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Date: 2014/10/09
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
public class TestServiceImpl implements TestService {

    @Inject
    private EntityManager em;


    @Override
    @Transactional
    public int add(String text) {
        TestTable testTable = new TestTable();
        testTable.setText(text);
        em.persist(testTable);
        return testTable.getId();
    }


    @Override
    public TestTable getTestTable(int id) {
        return em.find(TestTable.class, id);
    }

    @Override
    public List<TestTable> getAll() {
        return em.createNativeQuery("select * from testtable", TestTable.class).getResultList();
    }

    @Override
    @Transactional
    public void deleteText(int id) {
        TestTable tt = getTestTable(id);
        em.remove(tt);
    }

    @Override
    @Transactional
    public void deleteText(String text) {
        Query q = em.createNativeQuery("select * from testtable where text=?", TestTable.class);
        q.setParameter(1, text);
        List<TestTable> results = q.getResultList();
        for (TestTable tt : results) {
            em.remove(tt);
        }
    }
}
