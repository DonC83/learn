package com.donc.repo.springdata;


import com.donc.entities.TestTable;

/**
 * Created by donovan on 15/06/09.
 */
public interface JpaBaseRepo {
    //interface methods that do not conform with spring data's DSL should go here.

    boolean evaluateTest(TestTable testTable);
}
