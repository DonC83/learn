package com.donc.services;

import com.donc.entities.TestTable;

import java.util.List;

/**
 * Date: 2014/10/09
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
public interface TestService {

    int add(String text);
    TestTable getTestTable(int id);
    List<TestTable> getAll();
    void deleteText(int id);
    void deleteText(String text);

}
