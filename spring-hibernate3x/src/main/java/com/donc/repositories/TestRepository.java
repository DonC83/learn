package com.donc.repositories;

import com.donc.entities.TestTable;

import java.util.List;

/**
 * Created by donovan on 15/06/05.
 */
public interface TestRepository {

    List<TestTable> getAll();

    int add(String text);
}
