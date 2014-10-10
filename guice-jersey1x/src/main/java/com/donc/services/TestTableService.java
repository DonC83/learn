package com.donc.services;

import com.donc.entities.TestTable;

/**
 * Date: 2014/10/09
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
public interface TestTableService {

    void add(String text);
    TestTable getTestTable(int id);
}
