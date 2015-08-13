package jdbc;

import entities.TestTable;

/**
 * Created by donovan on 15/06/04.
 */
public interface TestRepository {


    void addTest(TestTable testTable);

    TestTable getTestTable(int id);
}
