package com.donc.repositories;

import com.donc.entities.TestTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by donovan on 15/06/05.
 */
@Repository
public class TestRepositoryImpl implements TestRepository {

    private SessionFactory sessionFactory;

    @Inject
    public TestRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }


    public List<TestTable> getAll() {
        return currentSession().createCriteria(TestTable.class).list();
    }


    public int add(String text) {
        TestTable tt = new TestTable();
        tt.setText(text);
        currentSession().save(tt);
        return tt.getId();
    }

}
