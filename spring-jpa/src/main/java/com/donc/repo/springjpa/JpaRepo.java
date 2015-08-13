package com.donc.repo.springjpa;


import com.donc.entities.TestTable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by donovan on 15/06/08.
 */
@Repository
@Transactional
public interface JpaRepo {


    int add(String text);

    TestTable get(int id);

    List<TestTable> getAll();

    void delete(int id);

}
