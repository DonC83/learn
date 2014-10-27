package com.donc.service;

import com.donc.entities.TestTable;
import com.google.inject.persist.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Date: 2014/10/27
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
public class TestServiceImpl implements TestService {

    @Inject
    private EntityManager em;

    @Override
    @Transactional
    public TestTable create(TestTable testTable) {
        em.persist(testTable);
        return testTable;
    }

    @Override
    @Transactional
    public void update(TestTable testTable) {
        TestTable obj = this.get(testTable.getId());
        if (obj==null)
            return;
        obj.setText(testTable.getText());
        em.persist(obj);
    }

    @Override
    @Transactional
    public void delete(int id) {
        TestTable obj = this.get(id);
        if (obj==null)
            return;
        em.remove(obj);
    }

    @Override
    public TestTable get(int id) {
        return em.find(TestTable.class, id);
    }
}
