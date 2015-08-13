package com.donc.repositories;

import com.donc.entities.TestTable;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by donovan on 15/06/05.
 */
@Repository
public class TestRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public TestRepository(SessionFactory sessionFactory) {
        System.out.println(sessionFactory);
        this.sessionFactory = sessionFactory;
    }


    public List<TestTable> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(TestTable.class).list();
    }

    public int add(String text) {
        TestTable testTable = new TestTable();
        testTable.setText(text);
        sessionFactory.getCurrentSession()
                .save(testTable);
        return testTable.getId();
    }


}
