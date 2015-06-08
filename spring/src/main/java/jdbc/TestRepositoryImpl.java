package jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

/**
 * Created by donovan on 15/06/04.
 */
@Repository
public class TestRepositoryImpl {


    private JdbcOperations operations;

    @Autowired
    public TestRepositoryImpl(JdbcOperations operations) {
        this.operations = operations;
    }
}
