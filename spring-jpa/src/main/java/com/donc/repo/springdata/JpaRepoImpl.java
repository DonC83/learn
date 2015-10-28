package com.donc.repo.springdata;

import com.donc.entities.TestTable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by donovan on 15/06/09.
 */
@Transactional
public class JpaRepoImpl implements JpaBaseRepo {

    @PersistenceContext
    private EntityManager em;


    @Override
    public boolean evaluateTest(TestTable testTable) {
        TestTable t1 = em.find(TestTable.class, testTable.getId());
        return t1.getText().equalsIgnoreCase(testTable.getText());
    }
}
