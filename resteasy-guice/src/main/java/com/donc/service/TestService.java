package com.donc.service;

import com.donc.entities.TestTable;

/**
 * Created by donovan on 15/04/09.
 */
public interface TestService {

    TestTable get(int id);

    int create(String text);

    TestTable create(TestTable testTable);

    void delete(int id);

    void update(int id, TestTable testTable);
}
