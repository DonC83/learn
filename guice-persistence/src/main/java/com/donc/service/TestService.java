package com.donc.service;

import com.donc.entities.TestTable;

/**
 * Date: 2014/10/27
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
public interface TestService {

    TestTable create(TestTable testTable);
    void update(TestTable testTable);
    void delete(int id);
    TestTable get(int id);
}
