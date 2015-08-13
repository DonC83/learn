package com.donc.repo.springjpa;

import com.donc.entities.TestTable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by donovan on 15/06/08.
 */
@Repository
@Transactional
public class JpaRepoImpl implements JpaRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public int add(String text) {
        TestTable tt = new TestTable();
        tt.setText(text);
        em.persist(tt);
        return tt.getId();
    }

    @Override
    public TestTable get(int id) {
        return em.find(TestTable.class, id);
    }

    @Override
    public List<TestTable> getAll() {
        return em.createNamedQuery("TestTable.getAll").getResultList();
    }

    @Override
    public void delete(int id) {
        TestTable tt = get(id);
        em.remove(tt);
    }
}
