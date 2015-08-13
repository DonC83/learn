package jdbc;

import entities.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by donovan on 15/06/04.
 */
@Repository
public class TestRepositoryImpl implements TestRepository {


    private JdbcOperations operations;

    @Autowired
    public TestRepositoryImpl(JdbcOperations operations) {
        this.operations = operations;
    }

    @Override
    public void addTest(TestTable testTable) {
        operations.update("insert into testtable (id, text) values (?,?)",
                testTable.getId(),
                testTable.getText());
    }

    //class mapper
//    @Override
//    public TestTable getTestTable(int id) {
//        return operations.queryForObject("select id, text from testtable where id=?", new TestTable.TestTableRowMapper(), id);
//    }


//lambda
    @Override
    public TestTable getTestTable(int id) {
        return operations.queryForObject("select id, text from testtable where id=?",
                (rs, rowNum) -> {
                return new TestTable(rs.getInt("id"), rs.getString("updateByEmail"));
            }, id);
    }

    //java 8 method references
//    @Override
//    public TestTable getTestTable(int id) {
//        return operations.queryForObject("select id, text from testtable where id=?", this::ttMapper, id);
//    }

    private TestTable ttMapper(ResultSet rs, int rowNum) throws SQLException {
        return new TestTable(rs.getInt("id"), rs.getString("text"));
    }
}
